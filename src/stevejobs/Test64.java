package stevejobs;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Test64
{
	public static void main(String[] args) throws Exception
	{
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		Thread.sleep(20000);
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Details of ARD and app in testing
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","4200e6519aac84b9");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","6.0.1");
		dc.setCapability("appPackage","com.android.contacts");
		dc.setCapability("appActivity","com.android.dialer.DialtactsActivity");
		//Create driver object to launch app in ARD
		AndroidDriver driver=new AndroidDriver(u,dc);
		Thread.sleep(10000);
		driver.pressKeyCode(AndroidKeyCode.HOME);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@text='Apps']")).click();
		Thread.sleep(10000);
		driver.context("NATIVE_APP");
		int w=driver.manage().window().getSize().getWidth();
		int h=driver.manage().window().getSize().getHeight();
		TouchAction ta=new TouchAction(driver);
		//swipe from right to left for required element
		int x=(int)(w*0.9); //right
		int y=(int)(h/2); 
		int temp=(int)(w*0.7); //left
		while(2>1) //infinite loop
		{
			try
			{
				if(driver.findElement(By.xpath(
						"//*[@text='Unlock']")).isDisplayed())
				{
					break; //to terminate from current loop
				}
			}
			catch(Exception ex)
			{
			 ta.press(x,y).moveTo(temp-x,0).release().perform();
			}
			Thread.sleep(5000);
		}
		Thread.sleep(10000);
		//swipe from left to right for required element
		temp=(int)(w*0.9); //right
		x=(int)(w*0.7); //left
		while(2>1) //infinite loop
		{
			try
			{
				if(driver.findElement(By.xpath(
					"//*[@text='Calculator']")).isDisplayed())
				{
					break; //to terminate from current loop
				}
			}
			catch(Exception ex)
			{
			 ta.press(x,y).moveTo(temp-x,0).release().perform();
			}
			Thread.sleep(5000);
		}
		
		//Back to app
		driver.launchApp();
		Thread.sleep(10000);
		//close app
		driver.closeApp();
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
