package signUp;

import java.io.File;
import java.io.IOException;

import launchApp.WebDriverDecider;
import launchApp.WebDriverWaitDecider;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import excelInfo.ReadFileInfo;

public class SignUp {
	@Test
	public void getStarted() throws IOException, InterruptedException{
		//Capturing screenshot
//		WebDriver driver_screenshot = new Augmenter().augment(WebDriverDecider.getWebDriverInstance().getDriver());
//		File screenshot_file = ((TakesScreenshot)driver_screenshot).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(screenshot_file, new File("screehshot1.jpg"));
		
		ReadFileInfo readFile = new ReadFileInfo();
		
		Reporter.log("<font color='orange'>Test Scenario 2: Tapping on SIGN UP button and verifying whether application navigates to SIGN UP screen</font>");
		Reporter.log("<font color='blue'>-----Test Case 2-----</font>" +"<br> 1. Consider user in First Launch screen."+"<br>2. Tap  on SIGN UP button."+"<br>3. Verify whether application navigates to SIGN UP screen");
		
		//Click on SIGN UP NOW button
		WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.name("SIGN UP NOW ")).click();
		Sheet SignUpInfo = ReadFileInfo.ReadSignUpInfo("SignUp");
		//Verify whether placeholder text "Parent's First Name" is shown.
		WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIATextField[1]")));
		
		ATUReports.add("<font color='green'>Application successfully displayed 'LET'S GET STARTED!' screen</font>", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
		Reporter.log("<font color='orange'>Test Scenario 3: Verifying whether user is able to enter input data for 'First Name' and 'Last Name' and successfully navigating to next screen.</font>");
		Reporter.log("<font color='blue'>-----Test Case 3.1-----</font>" +"<br> 1. Consider user in LET'S GET STARTED! screen."+"<br>2. Tap  on 'First Name' text field."+"<br>3. Verify whether keyboard interface is popped up"+"<br>4. Enter input data for 'First Name' text field."+"<br>5. Verifying whether entered input data is displayed");
		
		//Tapping on "Parent's First Name text field
		WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIATextField[1]")).click();
		//Entering First Name
		WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIATextField[1]")).sendKeys(SignUpInfo.getRow(1).getCell(0).getStringCellValue());
		
		ATUReports.add("<font color='green'>Application successfully entered 'First Name'</font>", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
		Reporter.log("<font color='blue'>-----Test Case 3.2-----</font>" +"<br> 1. Consider user in LET'S GET STARTED! screen."+"<br>2. Tap  on 'Last Name' text field."+"<br>3. Verify whether keyboard interface is popped up"+"<br>4. Enter input data for 'Last Name' text field."+"<br>5. Verifying whether entered input data is displayed");
		
		//Entering Last Name
		WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIATextField[2]")).sendKeys(SignUpInfo.getRow(1).getCell(1).getStringCellValue());
		//Hide keyboard
		WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath(" //UIAApplication[1]/UIAWindow[2]/UIAKeyboard[1]/UIAButton[6]")).click();
		
		ATUReports.add("<font color='green'>Application successfully entered 'Last Name'</font>", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
		//Clicking on Privacy policy button present in the screen
		//WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[3]")).click();
		//Closing the Privacy policy screen after screen gets loaded.
		//	WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[8]")).click();
		
		Reporter.log("<font color='blue'>-----Test Case 3.3-----</font>" +"<br> 1. Enter First Name."+"<br>2. Enter Last Name."+"<br>3. Tap on 'NEXT' button"+"<br>4. Verify whether user has navigated to 'Parent's email address' screen.");
		//Tapping on NEXT button shown in "LET'S GET STARTED!" screen
		WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[2]")).click();
		//Verify whether Parent's email address entry screen is shown
		WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAStaticText[3]")));
		ATUReports.add("<font color='green'>Application successfully navigated to 'Parent's email address' screen.</font>", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
		Reporter.log("<font color='orange'>Test Scenario 4: Entering valid email address, check marking 'user doesn't reside in State of Texas' and navigating to 'Account Password creation' screen.</font>");
		Reporter.log("<font color='blue'>-----Test Case 4.1-----</font>" +"<br> 1. Consider user 'Parent's email address' screen"+"<br>2. Tap on email address text field."+"<br>3. Verify whether keyboard interface is popped up."+"<br>4. Enter input data for email address text field."+"<br>5. Verifying whether entered input data is displayed.");
		//Entering email address
		WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]/UIATextField[1]")).click();
		WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]/UIATextField[1]")).sendKeys("sukesh+23@codecraft.co.in");
		//	WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]/UIATextField[1]")).sendKeys(SignUpInfo.getRow(1).getCell(2).getStringCellValue());
		ATUReports.add("<font color='green'>Application successfully entered email address.</font>", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
		Reporter.log("<font color='blue'>-----Test Case 4.2-----</font>" +"<br> 1. Consider user has entered valid email address."+"<br>2. Tapping on check box of 'By checking this box I certify I do not reside in the state of Texas'."+"<br>3. Verifying whether check box is check marked.");
		//Check marking the residing status of Texas
		WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[3]")).click();
		String value = WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[3]")).getAttribute("value");	
		if(value.matches("1")){
			System.out.println("Application has check marked user doesn't reside in State of Texas");
			ATUReports.add("<font color='green'>Application successfully check marked 'By checking this box I certify I do not reside in the state of Texas'</font>", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}else
		{
			System.out.println("Application failed to check mark 'user doesn't reside in State of Texas', attempting to tap on it again....");
			WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[3]")).click();
			ATUReports.add("<font color='green'>Application failed to check mark 'By checking this box I certify I do not reside in the state of Texas'</font>", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			return;
		}
		Reporter.log("<font color='blue'>-----Test Case 4.3-----</font>" +"<br> 1. Consider user has entered valid email address."+"<br>2. Consider user has check marked 'By checking this box I certify I do not reside in the state of Texas'."+"<br>3. Tapping on 'Continue' button."+"<br>4. verifying whether application navigates to 'Account Password Creation' screen.");
		//Tapping on Continue button
		WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[2]")).click();
		//Verify whether password screen is loaded.
		WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]/UIAStaticText[3]")));
		ATUReports.add("<font color='green'>Application successfully navigated to 'Account Password Creation' screen.</font>", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
		
		Reporter.log("<font color='orange'>Test Scenario 5: Setting up of password and navigating to 'Account Verification' screen.</font>");
		Reporter.log("<font color='blue'>-----Test Case 5.1-----</font>" +"<br> 1. Considering user in 'Account Password creation' screen."+"<br>2. Tapping on 'Create Password' text field."+"<br>3. Verifying whether keyboard interface has popped up.");
		//Entering password
		WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]/UIASecureTextField[1]")).click();
		Reporter.log("<font color='blue'>-----Test Case 5.2-----</font>" +"<br> 1. Considering user in 'Account Password creation' screen."+"<br>2. Tapping on 'Create Password' text field."+"<br>3. Verifying whether keyboard interface has popped up."+"<br>4. Entering valid input data for 'Create password' text field."+"<br>5. Verifying whether entered input data is shown in the form of asterisk.");
		WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]/UIASecureTextField[1]")).sendKeys(SignUpInfo.getRow(1).getCell(3).getStringCellValue());
		ATUReports.add("<font color='green'>Application successfully entered password and it is being displayed in the form of asterisk", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
		//Entering Confirm Password
		Reporter.log("<font color='blue'>-----Test Case 5.3-----</font>" +"<br> 1. Considering user in 'Account Password creation' screen."+"<br>2. Tapping on 'Confirm Password' text field."+"<br>3. Verifying whether keyboard interface has popped up.");
		WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]/UIASecureTextField[2]")).click();
		//WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]/UIASecureTextField[2]")).sendKeys("Bangalore123");
		Reporter.log("<font color='blue'>-----Test Case 5.4-----</font>" +"<br> 1. Considering user in 'Account Password creation' screen."+"<br>2. Tapping on 'Confirm Password' text field."+"<br>3. Verifying whether keyboard interface has popped up."+"<br>4. Entering valid input data for 'Confirm password' text field."+"<br>5. Verifying whether entered input data is shown in the form of asterisk.");
		WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]/UIASecureTextField[2]")).sendKeys(SignUpInfo.getRow(1).getCell(4).getStringCellValue());
		ATUReports.add("<font color='green'>Application successfully entered confrim password and it is being displayed in the form of asterisk", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
		//Tapping on Continue button
		Reporter.log("<font color='blue'>-----Test Case 5.5-----</font>" +"<br> 1. Considering user has entered password in both 'Create Password' and 'Confirm Password' text fields."+"<br>2. Tapping on 'Continue'."+"<br>3. Verifying whether application navigated to 'Account verification' screen.");
		WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]/UIAButton[2]")).click();
		Thread.sleep(35000);
		//Validating whether entered password and confirm password matches
		try{
			String passwordMissmatch = WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]/UIAStaticText[5]")).getAttribute("value");
			if(passwordMissmatch.matches("The password you entered did not match.")){
				System.out.println("Seems like entered passowrds entered did not match");
				ATUReports.add("<font color='green'>Seems like entered passowrds entered did not match. Aborting the execution.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				return;
			}
		}catch(Exception e){
			//Verifying whether entered email address is already registered or not
			try{
				String emailAlreadyExist = WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath(" //UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIAScrollView[1]/UIAStaticText[2]")).getAttribute("value");
				if(emailAlreadyExist.matches("The email address you entered is already associated with a Flare Kids account. Please try again with different email address")){
					System.out.println("The email address you have entered is already associated with Flare Kids Account.");
					ATUReports.add("<font color='green'>Seems like the email address you have entered is already associated with Flare Kids Account. Aborting the execution.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					return;
				}

			}catch(Exception e2){
				//Verifying Email Address (this comes only if entered data is valid and email id is unique)
				//verify for the text "Please Verify your email address"
				try{
					String verifyEmailAddress = WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[11]")).getAttribute("value");
					

					System.out.println(verifyEmailAddress);
					if(verifyEmailAddress.matches("YOUR EMAIL ADDRESS")){
						//Tap on OK button.
						WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[8]")).click();
						System.out.println("Application has sent account verification link. Activate your account by clicking on the link manually.");
						ATUReports.add("<font color='green'>Application has sent account verification link. Activate your account by clicking on the link manually.", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					}		
				}catch(Exception e1){

				}
			}
		}
		
		Reporter.log("<font color='orange'>Test Scenario 6: Considering user has verified email address manually and tapping on 'Verify My Account' button inorder to navigate to 'My Family' screen.</font>");
		//Parent's Account Verification
		WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]")));
		ATUReports.add("<font color='green'>Application successfully navigated to 'Account Verification' screen.", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
		Reporter.log("<font color='blue'>-----Test Case 6.1-----</font>" +"<br> 1. Considering user in 'Account Verification' screen."+"<br>2. Tapping on 'Verify My Account' button."+"<br>3. Verifying whether application navigated to 'My Family' screen.");
		//Tapping on VERIFY MY ACCOUNT button
		Integer accountVerified=0;
		while(accountVerified<20){
			//Tapping on VERIFY MY ACCOUNT button.
			try{
				try{
					WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")).click();
				}catch(Exception e){
					break;
				}
				Thread.sleep(10000);
				//Verifying whether account has been verified manually
				String accountNotVerified = WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIAScrollView[1]/UIAStaticText[1]")).getAttribute("value");
				if(accountNotVerified.matches("Verification Required")){
					System.out.println("Application will wait for another 30 sec and check whether user has manually verified.");
					Reporter.log("<font color='blue'>Application will wait for another 30 sec and check whether user has manually verified.</font>");
					WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]")).click();
					Thread.sleep(20000);
					accountVerified++;
				}
			}catch(Exception e){

			}

		}

//		//Swiping Coach Cards
//		try{
//			//Wait till Coach Cards gets loaded
//			WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAImage[1]")));
//
//		}catch(Exception e){
//			System.out.println("Seems like there was an error in loading Coach Cards");
//			return;
//		}
//
//		try{
//			boolean coachCardsShown = true;
//			while(coachCardsShown == true){
//				//Swiping first Coach card
//				WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")).click();
//				coachCardsShown = true;
//			}
//
//		}catch(Exception e){
//			//Tapping on LET'S GET STARTED! button
//			WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]")).click();
//		}


//		//Verify whether Adding Child screen is loaded.
//		
//		WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[2]/UIACollectionCell[1]/UIAStaticText[1]")));
//
//		WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[2]/UIACollectionCell[1]/UIAStaticText[1]")).click();

		//Verifying whether 'Select Content Age Groups' screen is loaded.
		
		
		
//		try{
//			//Wait till Adding first child screen gets load
//			WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[3]/UIACollectionCell[1]/UIAStaticText[3]")));
//			//Enter Child1 username
//			WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[3]/UIACollectionCell[1]/UIATextField[1]")).sendKeys("ABC1");
//			//WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[3]/UIACollectionCell[1]/UIATextField[1]")).sendKeys(SignUpInfo.getRow(1).getCell(5).getStringCellValue());
//			//Tapping on Next button
//			WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[3]/UIACollectionCell[1]/UIAButton[2]")).click();
//			//try-catch block return for Block Networks screen
//			try{
//				//Verify whether BLOCK NETWORKS screen is loaded
//				WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[3]/UIACollectionCell[2]/UIAStaticText[1]")));
//				System.out.println("Block Networks screen has been loaded successfully");
//				//Selecting networks based on Parents choice
//				String blockNetworkStatus = SignUpInfo.getRow(1).getCell(6).getStringCellValue();
//				//String blockNetworkStatus = "Block All Networks";
//				if(blockNetworkStatus.matches("Block Selected Networks")){
//					//Verifying whether PBS Kids should be blocked or not
//					System.out.println("Application has navigated to Block Selected Networks");
//
//					//Blocking networks based on users choice
//					int cellValue=2;
//					int networkCellValue = 1;
//					String networktoBlock = SignUpInfo.getRow(cellValue).getCell(6).getStringCellValue();
//					while(networktoBlock!=null){
//						if(networktoBlock.contains("Don't Block")){
//							System.out.println("Application will not block "+networktoBlock+" network");
//						}else{
//							//Swipe
//							String xpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[3]/UIACollectionCell[2]/UIACollectionView[1]/UIACollectionCell["+networkCellValue+"]";
//							WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath(xpath)).click();
//						}
//						cellValue++;
//						networkCellValue++;
//						networktoBlock = SignUpInfo.getRow(cellValue).getCell(6).getStringCellValue();
//					}		
//					//Tapping on Next button
//					WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[3]/UIACollectionCell[2]/UIAButton[2]")).click();	
//				}else{
//					//Block all networks
//					int networkCellValue = 1;
//					while(networkCellValue<13){
//						String xpath = "//UIAApplication[1]/UIAWindow[1]/UIACollectionView[3]/UIACollectionCell[2]/UIACollectionView[1]/UIACollectionCell["+networkCellValue+"]";
//						WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath(xpath)).click();
//						networkCellValue++;
//					}	
//					//Tapping on Next button
//					WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[3]/UIACollectionCell[2]/UIAButton[2]")).click();	
//				}
//
//
//			}catch(Exception e1){
//				//Tapping on Next button
//				WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[3]/UIACollectionCell[2]/UIAButton[2]")).click();
//			}
//
//		}catch(Exception e){
//
//		}

//		try{
//			//Clicking on done button after successfully adding first child.
//			WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[3]")));
//			WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[3]")).click();
//		}catch(Exception e){
//			System.out.println("Seems like child addition screen is not loaded...");
//
//		}

	}
}
