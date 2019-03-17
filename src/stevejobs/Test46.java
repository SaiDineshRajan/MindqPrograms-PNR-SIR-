package stevejobs;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Button;
import org.sikuli.script.Key;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;
public class Test46
{
	public static void main(String[] args) throws Exception
	{
		//Run browser driver to get browser(Java)                    
		System.setProperty("webdriver.chrome.driver",
				  "E:\\batch236\\chromedriver.exe");
		//Create object to access that opened browser(SWD)
		WebDriver driver=new ChromeDriver();
		//Launch site(SWD)
		driver.get("http://www.youtube.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
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
		Thread.sleep(5000);
		//Move mouse pointer to video body to get icons
		s.wheel(l,Button.LEFT,0);
		//Move mouse pointer to volume icon
		s.mouseMove("volume.png");
		//decrease volume
		Match e=s.find("bubble.png");
		int x=e.getX();
		int y=e.getY();
		Location sl1=new Location(x-30,y);
		s.dragDrop(e,sl1); //to left
		Thread.sleep(5000);
		//Increase volume
		Location sl2=new Location(x+30,y);                      
		s.dragDrop(e,sl2); //to right
		Thread.sleep(5000);
		//Close browser window
		s.keyDown(Key.ALT);
		s.keyDown(Key.F4);
		s.keyUp(Key.F4);
		s.keyUp(Key.ALT);
	}

}





