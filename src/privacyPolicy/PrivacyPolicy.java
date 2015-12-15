package privacyPolicy;

import launchApp.WebDriverDecider;
import launchApp.WebDriverWaitDecider;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class PrivacyPolicy {
	@Test
	  public void CheckPrivacyPolicyLoaded() {
		  System.out.println("Application is tapping on PRIVACY POLICY button and verifying whether web page gets loaded");
			try{
				WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.name("PRIVACY POLICY")).click();
				System.out.println("Application has tapped on PRIVACY POLICY button");
			}catch(Exception e){
				System.out.println("Application failed to tap on PRIVACY POLICY button");
			}
			//Verifying whether Privacy policy Web Page has been loaded successfully.
			try{
			//	WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.name("PRIVACY POLICY")));
				WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[1]")));
				System.out.println("Application has successfully loaded Privacy Policy web page");
				//Tap on close button to close Privacy Policy screen
				WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.name("PrivacyPolicy Close Button")).click();
			}catch(Exception e){	
			}
			
	  }
}
