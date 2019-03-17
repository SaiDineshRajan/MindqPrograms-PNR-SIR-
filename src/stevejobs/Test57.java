package stevejobs;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import java.net.URL;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Test57
{
	public static void main(String[] args) throws Exception
	{
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		Thread.sleep(20000);
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Launch app in AVD
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","4200e6519aac84b9");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","6.0.1");
		dc.setCapability("locationServicesEnabled",true);
		dc.setCapability("locationServicesAuthorized",true);
		dc.setCapability("appPackage","com.google.android.apps.maps");
		dc.setCapability("appActivity","com.google.android.maps.MapsActivity");
		//Create driver object to launch app
		AndroidDriver driver=new AndroidDriver(u,dc);
		Thread.sleep(20000);
		//getRemoteAddress()
		URL x=driver.getRemoteAddress();
		System.out.println("Appium server url is "+x.getPath());
		System.out.println("Appium server port is "+x.getPort());
		System.out.println("Appium server protocol is "+x.getProtocol());
		Thread.sleep(10000);
		//getDeviceTime()
		String y=driver.getDeviceTime();
		System.out.println("Device time is "+y);
		Thread.sleep(10000);
		//getPlatformName()
		String w=driver.getPlatformName();
		System.out.println("Platform name is "+w);
		Thread.sleep(10000);
		//getDisplayDensity()
		long l=driver.getDisplayDensity();
		System.out.println("Display density is "+l);
		Thread.sleep(10000);
		//openNotifications()
		driver.openNotifications();
		Thread.sleep(10000);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(10000);
		//Close app 
		driver.closeApp();
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
