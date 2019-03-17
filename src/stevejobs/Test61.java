package stevejobs;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.URL;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Test61
{
	public static void main(String[] args) throws Exception
	{
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		Thread.sleep(20000);
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Launch app in ARD
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
		Thread.sleep(13000);
		//Take screen shot
		File src=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("toastedmsg.png");
		FileUtils.copyFile(src,dest);
		//Get toasted message (3.4.0 is stable for tess4j)
		ITesseract obj=new Tesseract();
		File tessDataFolder=LoadLibs.extractTessResources("tessdata");
		obj.setDatapath(tessDataFolder.getAbsolutePath());
		String result=obj.doOCR(dest);
		Thread.sleep(10000);
		if(result.contains("You are here >"))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
		//close app
		driver.closeApp();
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
