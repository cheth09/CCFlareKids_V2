package launchApp;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import kidDetails.FirstKidSelection;
import kidDetails.FriendsSelection;
import kidDetails.ThemeSelection;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hslf.record.Environment;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import privacyPolicy.PrivacyPolicy;
import reporting.SendReport;
import termsOfUse.TermsOfUse;
import excelInfo.Elementdetectioninfo;

@Listeners({ATUReportsListener.class,ConfigurationListener.class,MethodListener.class})

public class CCLogin {
	{
		File file = new File("atu.properties");
		System.setProperty("atu.reporter.config", file.getAbsolutePath());
	}
	PrivacyPolicy policy;
	TermsOfUse terms;
	signUp.SignUp signup;
	@BeforeSuite
	public static void LaunchApp() throws MalformedURLException, IOException, EncryptedDocumentException, InvalidFormatException{
		//launch the app by setting capablities
		try {
			//Thread.sleep(120000);
			WebDriverDecider.getWebDriverInstance().SetWebDriver();
			WebDriverWaitDecider.getWebDriverInstance().setWebDriverWait();
			//ATUReports.add("Webpage Opened", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			ATUReports.setWebDriver(WebDriverDecider.getWebDriverInstance().getDriver());
			ATUReports.indexPageDescription= "Flare Kids";
			ATUReports.setAuthorInfo("Sukesh Bolar", Utils.getCurrentTime(), "1.0");
			
			SignUp(); 
			//SignIn();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static void SignUp() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException{
		//Verify whether cover page has loaded - verifying for text "PREMIUM"
		Sheet FindElement = Elementdetectioninfo.FindElementPath("ElementDetection");
		
		WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.name("PREMIUM")));
		Reporter.log("*****Application going to perform Sign Up test case*****");
		Reporter.log("<font color='orange'>Test Scenario : Launching the app and verifying whether FIRST LAUNCH screen is loaded</font>");
		Reporter.log("<font color='blue'>-----Test Case 1-----</font>" +"<br> 1. Install app and launch it."+"<br>2. Verify whether 'FIRST LAUNCH' screen is loaded.");
		ATUReports.add("<font color='green'>Application successfully launched and displayed 'FIRST LAUNCH' screen</font>", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		
		System.out.println("Application has successfully launched");
		//Checking Privacy Policy
//		policy = new PrivacyPolicy();
//		policy.CheckPrivacyPolicyLoaded();
		//Checking Terms Of use 
//		terms = new TermsOfUse();
//		terms.checkTermsOfUse();
		
		//Sign Up
		signUp.SignUp signup = new signUp.SignUp();
		signup.getStarted();
		
		
		
	}
	
	
		public void SignIn() throws MalformedURLException, InterruptedException{
			//sign In
				signIn.SignIn signin = new signIn.SignIn();
				signin.signIn();
				//Kids Selection, i.e selecting any kid
				ThemeSelection.SelectTheme();
				//Verifying the selected friends
				FriendsSelection.Selectedfriends();
		
		
		}
		
		@AfterSuite
		public void SendFinalReport(){
			SendReport.SendReportThroughMail();
		}
	
}
