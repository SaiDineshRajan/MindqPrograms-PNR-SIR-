package stevejobs;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Test56
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
		dc.setCapability("appPackage",
				          "com.google.android.apps.maps");
		dc.setCapability("appActivity",
				     "com.google.android.maps.MapsActivity");
		//Create driver object to launch app
		AndroidDriver driver=new AndroidDriver(u,dc);
		Thread.sleep(20000);
		//Set location to Bengaluru
		Location l=new Location(12.971599,77.594563,909);
		driver.setLocation(l);
		Thread.sleep(20000);
		//Search for address
		driver.findElement(By.xpath("//*[@text='Search here']"))
		                            .sendKeys("mindq madhapur");
		Thread.sleep(15000);
		if(driver.isKeyboardShown())
		{
			driver.hideKeyboard();
		}
		Thread.sleep(15000);
		driver.findElement(By.xpath(
			"//*[@text='Mind Q Systems Madhapur'][@index='0']"))
			.click();
		Thread.sleep(15000);
		driver.findElement(By.xpath(
				  "//*[@text='Got it'][@index='2']")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath(
			"//*[@text='Mind Q Systems Madhapur'][@index='0']"))
			.click();
		Thread.sleep(15000);
		driver.findElement(By.xpath(
				     "//*[@text='Call'][@index='1']")).click();
		Thread.sleep(15000);
		//Redirect to phone app to call and end call
		driver.findElement(By.xpath(
			"//*[@content-desc='Call'][@index='1']")).click();
		Thread.sleep(20000);
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.android.incallui:id/endCallButton\")").click();
		//close app 
		driver.closeApp();
		Thread.sleep(10000);
		driver.pressKeyCode(AndroidKeyCode.BACK);//close phone app
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
