package stevejobs;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.URL;
import java.util.Scanner;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Test60
{
	public static void main(String[] args) throws Exception
	{
		//Get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a mobile number");
		String x=sc.nextLine();
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
		dc.setCapability("appActivity",
				      "com.android.dialer.DialtactsActivity");
		//Create driver object to launch app in ARD
		AndroidDriver driver=new AndroidDriver(u,dc);
		Thread.sleep(10000);
		//dail a number
		for(int i=0;i<x.length();i++)
		{
			char d=x.charAt(i);
			driver.findElement(By.xpath("//*[@text='"+d+"']")).click();
			Thread.sleep(10000);
		}
		driver.findElement(By.xpath(
			  "//*[@content-desc='Call'][@index='1']")).click();
		Thread.sleep(3000);
		//Take screen shot
		File src=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("toastedmsg.png");
		FileUtils.copyFile(src,dest);
		Thread.sleep(5000);
		//Get toasted message (3.4.0 is stable for tess4j)
		File fo=LoadLibs.extractTessResources("tessdata");
		ITesseract obj=new Tesseract();
		obj.setDatapath(fo.getAbsolutePath());
		String result=obj.doOCR(dest);
		Thread.sleep(10000);
		if(result.contains("Conditional call"))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
		Thread.sleep(10000);
		driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.android.incallui:id/endCallButton\")").click();
		//close app 
		driver.closeApp();
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}




