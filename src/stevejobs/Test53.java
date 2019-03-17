package stevejobs;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Test53
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
		dc.setCapability("appPackage",
				                    "com.android.calculator2");
		dc.setCapability("appActivity",
				         "com.android.calculator2.Calculator");
		//Create driver object to launch calculator app
		AndroidDriver driver=new AndroidDriver(u,dc);
		Thread.sleep(10000);
		//Goto apps list
		driver.pressKeyCode(AndroidKeyCode.HOME);
		Thread.sleep(10000);
		driver.findElement(By.xpath(
			"//*[@content-desc='Apps'][@index='2']")).click();
		Thread.sleep(10000);
		//Goto People app from apps list
		driver.findElement(By.xpath(
				"//*[@text='People'][@index='16']")).click();
		Thread.sleep(10000);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(10000);
		//Goto Messaging app from apps list
		driver.findElement(By.xpath(
				"//*[@text='Messaging'][@index='14']")).click();
		Thread.sleep(10000);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(10000);
		//Goto Phone app in apps list
		driver.findElement(By.xpath(
				"//*[@text='Phone'][@index='17']")).click();
		Thread.sleep(10000);
		if(driver.isKeyboardShown())
		{
			driver.hideKeyboard();
		}
		Thread.sleep(10000);
		//Goto home
		driver.pressKeyCode(AndroidKeyCode.HOME);
		Thread.sleep(10000);
		//Activate calculator 
		driver.launchApp();
		Thread.sleep(10000);
		//close calculator 
		driver.closeApp();
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
