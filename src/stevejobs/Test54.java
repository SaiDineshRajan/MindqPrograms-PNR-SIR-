package stevejobs;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Test54 
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
		//Create driver object to launch app in AVD
		AndroidDriver driver=new AndroidDriver(u,dc);
		Thread.sleep(10000);
		//Get package and Activity names of opened app
		String x=driver.getCurrentPackage();
		System.out.println(x);
		String y=driver.currentActivity();
		System.out.println(y);
		//Send app to background for 10 seconds
		Duration d=Duration.of(10, ChronoUnit.SECONDS);
		driver.runAppInBackground(d);
		Thread.sleep(20000);
		//reset app
		driver.findElement(By.xpath("//*[@text='8']")).click();
		Thread.sleep(10000);
		driver.resetApp();
		Thread.sleep(20000);
		//go home and then launch app and close app
		driver.pressKeyCode(AndroidKeyCode.HOME);
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




