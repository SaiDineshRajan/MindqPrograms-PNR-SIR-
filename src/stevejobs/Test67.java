package stevejobs;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
public class Test67
{
	public static void main(String[] args) throws Exception
	{
		//Get name of environment
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter computer or mobile");
		String env=sc.nextLine();
		//Create driver object w.r.t environment
		WebDriver driver=null;
		if(env.equals("computer"))
		{
			System.setProperty("webdriver.chrome.driver",
			           "E:\\batch236\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else
		{
			//Start appium server
			Runtime.getRuntime().exec(
			"cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
			Thread.sleep(20000);
			URL u=new URL("http://0.0.0.0:4723/wd/hub");
			//Details of ARD and app in testing
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME,
													"chrome");
			dc.setCapability("deviceName","4200e6519aac84b9");
			dc.setCapability("platformName","android");
			dc.setCapability("platformVersion","6.0.1");
			driver=new AndroidDriver(u,dc);
		}
		//Common automation code
		driver.get("http://newtours.demoaut.com");
		Thread.sleep(5000);
		//Click Register link
		driver.findElement(By.linkText("REGISTER")).click();
		Thread.sleep(5000);
		//Fill fields
		driver.findElement(By.name("firstName"))
		                           .sendKeys("Abdul",Keys.TAB,
		                        		   			"Kalam");
		
		
		
		
		driver.findElement(By.name("phone"))
									.sendKeys("900062918");
		driver.findElement(By.name("userName"))
                             .sendKeys("apj@abdulkalam.com");
		driver.findElement(By.name("address1"))
        					.sendKeys("Mosque street");
		driver.findElement(By.name("address2"))
        					.sendKeys("Dhanushkoti road");
		driver.findElement(By.name("city"))
        					.sendKeys("Rameshwaram");
		driver.findElement(By.name("state"))
        					.sendKeys("Tamilnadu");
		driver.findElement(By.name("postalCode"))
        					.sendKeys("630436");
		Thread.sleep(5000);
		WebElement e=driver.findElement(By.name("country"));
		Select s=new Select(e);
		s.selectByVisibleText("INDIA");
		Thread.sleep(5000);
		driver.findElement(By.name("email"))
		                .sendKeys("abdulkalam11");
		driver.findElement(By.name("password"))
        				.sendKeys("batch236insleep");
		driver.findElement(By.name("confirmPassword"))
        				.sendKeys("batch236insleep");
		
		
		
		driver.findElement(By.name("register")).click();
		Thread.sleep(5000);
		driver.close();
		//Close appium server for mobile
		if(!env.equals("computer"))
		{
		  //stop appium server
		  Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		  Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		}
	}
}



