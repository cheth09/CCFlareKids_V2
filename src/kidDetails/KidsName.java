package kidDetails;

import java.net.MalformedURLException;

import launchApp.WebDriverDecider;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class KidsName {
	@Test
	public static String FirstKidName() throws MalformedURLException {
	  //Fetching first name of kid
	  String KidName = WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[2]/UIACollectionCell[1]")).getAttribute("name").toString();
	  return KidName;
	}
  
	@Test
	public static String SecondKidName() throws MalformedURLException {
	  //Fetching first name of kid
	  String KidName = WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[2]/UIACollectionCell[2]")).getAttribute("name").toString();
	  return KidName;
	}
	
	@Test
	public static String ThirdKidName() throws MalformedURLException {
	  //Fetching first name of kid
	  String KidName = WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[2]/UIACollectionCell[3]")).getAttribute("name").toString();
	  return KidName;
	}
  
  
  
  
}
