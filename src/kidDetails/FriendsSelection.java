package kidDetails;

import java.net.MalformedURLException;

import launchApp.WebDriverDecider;
import launchApp.WebDriverWaitDecider;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class FriendsSelection {
  
  public static void Selectedfriends() throws MalformedURLException, InterruptedException {
	  
	  System.out.println("***** Test Scenario - Verifying whether three flare friends are selected and button label of the selected friends should change to 'IN MY FRIENDS'*****");
	  System.out.println("Test case :");
	  System.out.println("1. Consider user has navigated to 'Flare Friends Selection' screen.");
	  System.out.println("2. Verifying whether selected flare friends are listed at bottom of the screen.");
	  System.out.println("3. Verifying whether button label of selected flare firends is changed to 'IN MY FRIENDS'.");
	  System.out.println("\nTest Output >>>\n");
	  
	  //Verify whether friends selection screen is loaded (Collection view)
	  WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]")));
	  System.out.println("Application has successfully launched 'Flare Friends Selection' screen.");
	  
	  //Verifying whether Electro(friend) is loaded
	  
	  
	  String button_label = WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")).getText();
	  System.out.println(button_label);
	  
	  //Clickng on next view to show next friend(Jelly bean)
	  Thread.sleep(10000);
	  WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[3]")).click();
	  String button_label_jellybean = WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")).getText();
	  
	  
	//Clickng on next view to show next friend(Unknown)
	  Thread.sleep(10000);
	  WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[3]")).click();
	  String button_label_unknown = WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")).getText(); 
	  
	  
	//Clickng on next view to show next friend(Fancy Pants)
	  Thread.sleep(10000);
	  WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[3]")).click();
	  String button_label_fancypants = WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")).getText(); 
	  
	  
	//Clickng on next view to show next friend(Fancy Pants)
	  Thread.sleep(10000);
	  WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[3]")).click();
	  String button_label_princesspearl = WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")).getText(); 
	  
	  
	  String electro_text = "I’m a robot, but some of my wires are crossed. Can you hamburger me? Am I making silly sauce? Why’s everyone laughing at me?! Pumpkins!!";
	  WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.name("I’m a robot, but some of my wires are crossed. Can you hamburger me? Am I making silly sauce? Why’s everyone laughing at me?! Pumpkins!!")));
	 //Verifying button label
	
	  
	  
  }
}
