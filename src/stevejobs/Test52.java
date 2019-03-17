package stevejobs;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Test52
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
		//Create driver object to launch app
		AndroidDriver driver=new AndroidDriver(u,dc);
		Thread.sleep(10000);
		//Lock and unlock
		driver.lockDevice();
		Thread.sleep(10000);
		if(driver.isLocked())
		{
			driver.unlockDevice();
			Thread.sleep(10000);
		}
		//perform rotations
		if(driver.getOrientation().name().equals("PORTRAIT"))
		{
			driver.rotate(ScreenOrientation.LANDSCAPE);
		}
		else
		{
			driver.rotate(ScreenOrientation.PORTRAIT);
		}
		Thread.sleep(10000);
		//close app 
		driver.closeApp();
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}

}
