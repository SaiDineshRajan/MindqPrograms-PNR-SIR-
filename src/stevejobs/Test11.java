package stevejobs;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test11 
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser window on desktop   
		System.setProperty("webdriver.chrome.driver",
			               "E:\\batch236\\chromedriver.exe");
		//create driver object to access that browser window
		WebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//Maximize window
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Get width and height of window
		int w=driver.manage().window().getSize().getWidth();
		int h=driver.manage().window().getSize().getHeight();
		System.out.println(w+" "+h);
		Thread.sleep(5000);
		//Change width and height
		Dimension d=new Dimension(100,700); //w,h
		driver.manage().window().setSize(d);
		Thread.sleep(5000);
		//Get x and y coordinates
		int x=driver.manage().window().getPosition().getX();
		int y=driver.manage().window().getPosition().getY();
		System.out.println(x+" "+y);
		Thread.sleep(5000);
		//Change position of browser window on desktop
		Point p=new Point(400,200); //x,y
		driver.manage().window().setPosition(p);
		Thread.sleep(5000);
		//Close site
		driver.close();
	}
}




