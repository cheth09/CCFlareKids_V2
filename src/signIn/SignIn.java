package signIn;

import java.net.MalformedURLException;

import kidDetails.KidsName;
import launchApp.WebDriverDecider;
import launchApp.WebDriverWaitDecider;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class SignIn {
	  boolean kid1Present = false;
	  boolean kid2Present = false;
	  boolean kid3Present = false;
  @Test
  public void signIn() throws MalformedURLException {
	  //commented till tapping on Sign In button 33
//	  //Tapping on Sign In button shown in Premium screen
//	  WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[3]")));
//	  WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[3]")).click();
//
//	  //Wait till SIGN IN screen is loaded
//	  WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.name("SIGN IN")));
//	  WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.name("SIGN IN")).click();
//	  
//	  //Entering Email Address by tapping on the text field and entering meta data 
//	  WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]")).click();
//	  WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]")).sendKeys("sukesh+556@codecraft.co.in");
//	  
//	  //Entering Password by tapping on the password text field and entering meta data 
//	  WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]")).click();
//	  WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]")).sendKeys("Sukesh123");
//	  
//	  //Tapping on SIGN IN button
//	  WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")).click();
	  
	  //Verifying whether user has successfully logged in or not
	  try{
	
		  WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAStaticText[3]")));

		  //Finding total number of kids listed
		  //finding whether first kid is present
		  try{
			  WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[2]/UIACollectionCell[1]")));
			  WebElement kid1= WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[2]/UIACollectionCell[1]"));
			  kid1Present = true;
		  }catch(Exception e1){
			  
		  }
		//finding whether second kid is present
		  try{
			  WebElement kid2= WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[2]/UIACollectionCell[2]"));
			  kid2Present = true;
		  }catch(Exception e1){
			  
		  }
		//finding whether second kid is present
		  try{
			  WebElement kid3= WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[2]/UIACollectionCell[3]"));
			  kid3Present = true;
		  }catch(Exception e1){
			  
		  }
		  
		  
		  if(kid1Present==true && kid2Present==true && kid3Present == true){
			 System.out.println("User has got three kids namely"); 
			  String Kid1Name = KidsName.FirstKidName();
			  String Kid2Name = KidsName.SecondKidName();
			  String Kid3Name = KidsName.ThirdKidName();
			  System.out.println("First Kid: "+Kid1Name);
			  System.out.println("Second Kid: "+Kid2Name);
			  System.out.println("Third Kid: "+Kid3Name);
			 
			 
		  }else if(kid1Present==true && kid2Present==true){
			  System.out.println("User has got two kids, namely:");
			  String Kid1Name = KidsName.FirstKidName();
			  String Kid2Name = KidsName.SecondKidName();
			  System.out.println("First Kid: "+Kid1Name);
			  System.out.println("Second Kid: "+Kid2Name);
			  
		  }else if(kid1Present==true ){
			  System.out.println("User has created only one kid."); 
			  String Kid1Name = KidsName.FirstKidName();
			  System.out.println("Kid Name: "+Kid1Name);
		  }
		  
		  
		  
		 
		  
	  }catch(Exception e){
		  //Checking whether SIGN IN screen is shown
		  try{
			  WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]"));
			  System.out.println("Ooopss!!! It seems like the credentials(Username and Password) did not match.");
		  }catch(Exception e1){
			
		  }
		  
		  
	  }
	  
	  
	  
	  
	  
  
  }
}
