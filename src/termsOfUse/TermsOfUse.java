package termsOfUse;

import launchApp.WebDriverDecider;
import launchApp.WebDriverWaitDecider;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class TermsOfUse {
	@Test
	  public void checkTermsOfUse() {
		  //Click on Terms Of Use button
		  try{
			  WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.name("TERMS OF USE"))); 
			  WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.name("TERMS OF USE")).click();
		  }catch(Exception e){
			  System.out.println("Application could not identify TERMS OF USE button");
		  }
			//Verifying whether TERMS OF USE Web Page has been loaded successfully.
			try{
				WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[1]")));
				System.out.println("Application has successfully loaded Terms of Use web page");
				//Tap on close button to close Privacy Policy screen
				WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.name("PrivacyPolicy Close Button")).click();
			}catch(Exception e){	
			}
	  }
}
