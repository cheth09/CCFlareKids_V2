package launchApp;



import java.net.MalformedURLException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WebDriverWaitDecider {
	private static WebDriverWaitDecider wdw = null;
	private static WebDriverWait wait;
	
	public static synchronized WebDriverWaitDecider getWebDriverInstance() throws MalformedURLException{
		if(wdw ==null){
			wdw = new WebDriverWaitDecider();
		}
		return wdw;	
	}
	
	public void setWebDriverWait() throws MalformedURLException{
		wait = new WebDriverWait(WebDriverDecider.getWebDriverInstance().getDriver(), 90);
	}
	public WebDriverWait getWebDriverWait(){
		return wait;
		
	}
}
