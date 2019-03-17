package stevejobs;

import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Button;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Location;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;

public class Demy {

	public static void main(String[] args) throws SikuliException {
		System.setProperty("webdriver.chrome.driver","E:\\batch239\\chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://www.udemy.com/courses/search/?q=sql%20database%20for%20beginners&src=sac&kw=sql%20database");
		Screen s=new Screen();
		Location l=new Location(300,300);
		s.wheel(Button.WHEEL_DOWN,1);
		s.click("demy.png");
		
	}

}
