package stevejobs;
import java.net.URL;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
public class Test55 
{
	public static void main(String[] args) throws Exception
	{
		//Start appium server(CLI based)
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		Thread.sleep(20000);
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Provide details of AVD and app under testing
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","emulator-5554");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","4.2.2");
		dc.setCapability("appPackage","com.android.calculator2");
		dc.setCapability("appActivity","com.android.calculator2.Calculator");
		//Create driver object to launch app in AVD
		AndroidDriver driver=new AndroidDriver(u,dc);
		Thread.sleep(10000);
		//install app and start before remove
		driver.installApp("C:\\Users\\Mindq-pc\\com.skype.m2-1.apk");
		Thread.sleep(10000);
		if(driver.isAppInstalled("com.skype.m2"))
		{
			Activity a=new Activity("com.skype.m2","com.skype.m2.views.Hub");
			driver.startActivity(a);
			Thread.sleep(10000);
			driver.removeApp("com.skype.m2");
		}
		Thread.sleep(10000);
		driver.launchApp();
		Thread.sleep(10000);
		driver.closeApp();
		Thread.sleep(10000);
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
