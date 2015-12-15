package kidDetails;

import java.net.MalformedURLException;

import launchApp.WebDriverDecider;
import launchApp.WebDriverWaitDecider;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class KidsSelection {
  @Test
  public static void SelectFirstKid() throws MalformedURLException {
	  try{
		  WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[2]/UIACollectionCell[1]")));
		  WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[2]/UIACollectionCell[1]")).click(); 
	  }catch(Exception e){
		  System.out.println("Seems like Who's Watching screen is not loaded. App might have crashed or did not load the screen.");
	  }
	  
	  
  
  }
  
  
  @Test
  public static void SelectSecondKid() {
  }
  
  
  @Test
  public static void SelectThirdKid() {
  }
  
}
