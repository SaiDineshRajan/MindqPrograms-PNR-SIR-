package stevejobs;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Test59 
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
		dc.setCapability("appPackage","com.whatsapp");
		dc.setCapability("appActivity","com.whatsapp.Main");
		//Create driver object to launch app
		AndroidDriver driver=new AndroidDriver(u,dc);
		Thread.sleep(20000);
		//Get current context name
		String c=driver.getContext();
		System.out.println(c);
		Thread.sleep(10000);
		//Get contexts
		Set<String> cl=driver.getContextHandles();
		List<String> acl=new ArrayList(cl);
		for(int i=0;i<acl.size();i++)
		{
			System.out.println(acl.get(i));
		}
		//Check current context as WEBVIEW
		if(driver.isBrowser())
		{
			System.out.println("In WEBVIEW");
			driver.context("NATIVE_APP");
		}
		else
		{
			System.out.println("Not in WEBVIEW");
		}
		//Close app
		driver.closeApp();
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
