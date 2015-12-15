package kidDetails;

import launchApp.WebDriverDecider;
import launchApp.WebDriverWaitDecider;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class ThemeSelection {
	//Theme selection is done for fresh installs only
	public static void SelectTheme() {
		//Verify whether Who's watching screen is loaded
		try{
			 WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.name("Who's Watching?")));
			 WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[2]/UIACollectionCell[1]")).click();
			 System.out.println("Application tapped on First kid");
			 //Verifying whether Theme selection screen is loaded or not.
			 WebDriverWaitDecider.getWebDriverInstance().getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.name("LET'S PICK A THEME!")));
			
			 //Code to fetch theme from excel has to be written
			 
			 //Tapping on theme 1
			 WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAImage[2]")).click();
			 
//			 //Tapping on theme 2
//			 WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAImage[2]")).click();
//			 
//			 //Tapping on theme 3
//			 WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]/UIAImage[2]")).click();
//			 
//			 //Tapping on theme 4
//			 WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[4]/UIAImage[2]")).click();
//			 
//			 //Tapping on theme 5
//			 WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[5]/UIAImage[2]")).click();
//			 
//			 //Taping on theme 6
//			 WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[6]/UIAImage[2]")).click();
			 
			 //verifying whether continue button is enabled or not
			
				 if (WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")).isDisplayed()==true){
					 System.out.println("Application successfully selected one theme....");
					 WebDriverDecider.getWebDriverInstance().getDriver().findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")).click();
				 }else{
					 System.out.println("Continue button shown in theme selection screen is disabled. Further execution cannot be done.");
				 }
			 
			 
		}catch(Exception e){
			
		}
		
	}
}
