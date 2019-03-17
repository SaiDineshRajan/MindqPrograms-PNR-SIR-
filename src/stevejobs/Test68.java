package stevejobs;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.Button;
import org.sikuli.script.Location;
import org.sikuli.script.Screen;
public class Test68
{
	public static void main(String[] args) throws Exception
	{
		//Get name of environment
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter computer or mobile");
		String env=sc.nextLine();
		//Create driver object w.r.t environment
		if(env.equals("computer"))
		{
			System.setProperty("webdriver.chrome.driver",
			           "E:\\batch236\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://www.youtube.com");
			Thread.sleep(20000);
			//Search video link(SWD)
			driver.findElement(By.name("search_query"))
			          .sendKeys("kalam sir speech",Keys.ENTER);
			Thread.sleep(5000);
			driver.findElement(By.partialLinkText(
					 "Dr. A P J Abdul Kalam in European")).click();
			Thread.sleep(10000);//time to start & to get skipadd
			//sikuli code
			Screen s=new Screen();
			if(s.exists("skipadd.png")!=null)
			{
				s.click("skipadd.png");
			}
			Thread.sleep(5000);
			//Move mouse pointer to video body to get icons
			Location l=new Location(300,200);
			s.wheel(l,Button.LEFT,0);
			//Click pause icon
			s.click("pause.png");
			Thread.sleep(5000);
			//Move mouse pointer to video body to get icons
			s.wheel(l,Button.LEFT,0);
			//Click play icon
			s.click("play.png");
			Thread.sleep(10000);
			//Close site
			driver.close();
		}
		else
		{
			//Start appium server
			Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
			Thread.sleep(20000);
			URL u=new URL("http://0.0.0.0:4723/wd/hub");
			//Details of ARD and app in testing
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME,"chrome");
			dc.setCapability("deviceName","4200e6519aac84b9");
			dc.setCapability("platformName","android");
			dc.setCapability("platformVersion","6.0.1");
			AndroidDriver driver=new AndroidDriver(u,dc);
			driver.get("http://www.youtube.com");
			Thread.sleep(10000);
			driver.context("NATIVE_APP");
			Thread.sleep(20000);
			driver.findElement(By.xpath("//*[@text='Search YouTube'][@index='0']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//*[@resource-id='koya_elem_1_4']"))
												.sendKeys("kalam sir speech");
			Thread.sleep(10000);
			driver.findElement(By.xpath("//*[@resource-id='koya_elem_1_2']"))
																	.click();
			Thread.sleep(10000);
			driver.findElement(By.xpath(
				"//*[contains(@text,'Dr. A P J Abdul Kalam in European')]"))
															.click();
			Thread.sleep(10000);
			driver.findElementByAndroidUIAutomator("new UiSelector().index(0).text(\"video\")").click();
			driver.findElement(By.xpath("//*[@text='pause']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//*[@text='play']")).click();
			Thread.sleep(15000);
			driver.closeApp();
			//stop appium server
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		}
	}
}
