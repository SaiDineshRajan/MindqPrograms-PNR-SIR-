package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test24
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to open browser                    
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch236\\chromedriver.exe");
		//Create object to access that opened browser
		WebDriver driver=new ChromeDriver();
		//Launch site and go to Register page
		driver.get("https://www.gmail.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				        "//*[text()='More options']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				      "//*[text()='Create account']")).click();
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("alert('Registration page is ready');");
		Thread.sleep(5000);
		driver.switchTo().alert().dismiss();
		//Fill fields in register page
		WebElement e=driver.findElement(By.name("FirstName"));
		js.executeScript("arguments[0].style.border='2px dotted blue';",e);
		js.executeScript("arguments[0].value='Apj';",e);
	/*			
		driver.findElement(By.name("LastName"))
		                               .sendKeys("Abdul kalam");
		driver.findElement(By.name("GmailAddress"))
		                           .sendKeys("batch236.sleep");
		driver.findElement(By.name("Passwd"))
		                               .sendKeys("active@1pm");
		driver.findElement(By.name("PasswdAgain"))
		                               .sendKeys("active@1pm");
		Thread.sleep(5000);
		//Automate <div> tag single select drop-downs
		WebElement e1=driver.findElement(By.xpath(
				                    "//*[@title='Birthday']"));
		Actions a=new Actions(driver);
		a.click(e1).build().perform();
		Thread.sleep(5000);
		a.sendKeys("o").build().perform();
		Thread.sleep(5000);
		a.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.name("BirthDay")).sendKeys("10");
		driver.findElement(By.name("BirthYear"))
		                                     .sendKeys("1932");
		Thread.sleep(5000);
		WebElement e2=driver.findElement(By.xpath(
				                      "//*[@title='Gender']"));
		a.click(e2).build().perform();
		Thread.sleep(5000);
		a.sendKeys("m").build().perform();
		Thread.sleep(5000);
		a.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		driver.findElement(By.name("RecoveryPhoneNumber"))
		                               .sendKeys("9999999900");
		driver.findElement(By.name("RecoveryEmailAddress"))
		                       .sendKeys("apj@abdulkalam.com");
		driver.findElement(By.name("submitbutton")).click();
		Thread.sleep(5000);
		for(int i=1;i<=25;i++)
		{
			a.sendKeys(Keys.DOWN).build().perform();
			Thread.sleep(2000);
		} */
	}

}
