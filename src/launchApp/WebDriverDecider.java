package launchApp;


//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.ios.IOSDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriverDecider {
	private static WebDriverDecider wd = null;
	private static RemoteWebDriver driver;


	public static synchronized WebDriverDecider getWebDriverInstance() throws MalformedURLException{
		if(wd==null){
			wd = new WebDriverDecider();
		}
		return wd;	
	}

	public  void SetWebDriver() throws IOException, InterruptedException{
		String udid = getUDIDOfTheDevice();
		File classpathroot = new File(System.getProperty("user.dir"));
		File file = new File(classpathroot,"/app/FlareKids.ipa");
		DesiredCapabilities capablities = new DesiredCapabilities();
		//capablities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
		capablities.setCapability("deviceName","Codecraft's iPAD");
		capablities.setCapability("platformName", "iOS");
		System.out.println("device name and version");
		capablities.setCapability("app", file.getAbsolutePath());
		capablities.setCapability("bundleId","com.greenlane.flarekids");
		capablities.setCapability("udid",udid);
	//	capablities.setCapability("udid","cbb49b4e933a679113b5b19308d3aba235ceb988");
		System.out.println("UDID of the device" +udid);
		capablities.setCapability("autoAcceptAlerts", true);
		capablities.setCapability("waitForAppScript", true);
		driver =new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capablities);
	//	Assert.assertTrue(true);

	}
	public RemoteWebDriver getDriver(){
		return driver;
	}
	
	public String getUDIDOfTheDevice() throws IOException, InterruptedException{
		//finding UDID of the device
		String value=null;
		String line = null;
		File filepath = new File(System.getProperty("user.dir"));
		File shellScriptToRun = new File(filepath,"/getUDID.sh");
		Process proc = Runtime.getRuntime().exec(shellScriptToRun.toString());
		InputStream stdin = proc.getInputStream();
		InputStreamReader isr = new InputStreamReader(stdin);
		BufferedReader br = new BufferedReader(isr);
		while ( (line = br.readLine()) != null){
			  value = line;
		}   
		String udid = "\""+value+"\"";
		return udid;
	}


}
