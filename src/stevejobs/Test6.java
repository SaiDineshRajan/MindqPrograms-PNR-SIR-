package stevejobs;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Test6
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser window on desktop   
		System.setProperty("webdriver.chrome.driver",
				           "E:\\batch236\\chromedriver.exe");
		//create driver object to access that browser window
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://newtours.demoaut.com");
		Thread.sleep(5000);
		//Click Register link
		driver.findElement(By.linkText("REGISTER")).click();
		Thread.sleep(5000);
		//Fill fields
		driver.findElement(By.name("firstName"))
		                           .sendKeys("Abdul",Keys.TAB,"Kalam");
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
		//Close site
		driver.close();
		
		

	}

}




