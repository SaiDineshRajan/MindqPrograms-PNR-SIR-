package stevejobs;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Test51
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
		dc.setCapability("appPackage","com.android.mms");
		dc.setCapability("appActivity","com.android.mms.ui.ConversationComposer");
		//Create driver object to launch app in ARD
		AndroidDriver driver=new AndroidDriver(u,dc);
		Thread.sleep(10000);
		//Perform operations
		List<MobileElement> msglist=driver.findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"com.android.mms:id/conversationList_item_root\")");
		Thread.sleep(5000);
		String x=msglist.get(0).findElement(By.xpath("//*[@class='android.widget.TextView'][@index='3']")).getAttribute("text");
		System.out.println(x);
		//close app 
		driver.closeApp();
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
