package stevejobs;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Test42
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser(Java)                    
		System.setProperty("webdriver.chrome.driver",
				  "E:\\batch236\\chromedriver.exe");
		//Create object to access that opened browser(SWD)
		WebDriver driver=new ChromeDriver();
		//Launch site(SWD)
		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Do login(SWD)
		driver.findElement(By.name("identifier")).sendKeys("sunil.komandala");
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("dadmom@1216");
		driver.findElement(By.id("passwordNext")).click();
		Thread.sleep(5000);
		//Click compose and fill fields
		driver.findElement(By.xpath("//*[text()='COMPOSE']"))
		                                       .click();
		Thread.sleep(5000);
		driver.findElement(By.name("to"))
		                       .sendKeys("apj@abdulkalam.com");
		Thread.sleep(5000);
		driver.findElement(By.name("subjectbox"))
		                                   .sendKeys("Wishes");
		Thread.sleep(5000);
		driver.findElement(By.name("subjectbox")).click();
		Actions a=new Actions(driver);
		a.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(5000);
		a.sendKeys("Hi sir,\nHow r u in heaven?").build()
		                                           .perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath(
			"//*[@aria-label='Attach files']/descendant::*[3]"))
			.click();
		Thread.sleep(5000);
		//Handle file upload window(Java Robot)
		String f="C:\\Users\\Public\\Pictures\\Sample Pictures\\tulips.jpg";
		StringSelection x=new StringSelection(f);
		Toolkit.getDefaultToolkit().getSystemClipboard()
		                            .setContents(x,null);
		Robot r=new Robot();
		if(System.getProperty("os.name").contains("Windows"))
		{
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(5000);
		}
		else if(System.getProperty("os.name").contains("Mac"))
		{
			r.keyPress(KeyEvent.VK_META);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_META);
			Thread.sleep(5000);
		}
		else if(System.getProperty("os.name").contains("Linux"))
		{
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(5000);
		}
		else
		{
			System.exit(0);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(25000);//for file uploading
		//Send email and get message to display
		driver.findElement(By.xpath(
				"//*[contains(@aria-label,'Send')]")).click();
		Thread.sleep(5000);
		String m=driver.findElement(By.xpath(
			"//*[@role='alert']/descendant::*[3]")).getText();
		System.out.println(m);
		//Do logout
		driver.findElement(By.xpath(
			"//*[contains(@title,'Google Account')]/child::*"))
			.click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign out")).click();
		Thread.sleep(5000);
		//close site
		driver.close();
	}
}
