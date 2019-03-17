package stevejobs;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class Test35
{
	public static void main(String[] args) throws Exception
	{
		//Load properties file
		File f=new File("mydata.properties");
		FileInputStream fis=new FileInputStream(f);
		Properties p=new Properties();
		p.load(fis);
		//open browser without SSL Certification verification
		ProfilesIni pi=new ProfilesIni();
		FirefoxProfile fp=pi.getProfile("default");
		fp.setAcceptUntrustedCertificates(true);
		fp.setAssumeUntrustedCertificateIssuer(false);
		System.setProperty("webdriver.gecko.driver",
				p.getProperty("dp"));
		WebDriver driver=new FirefoxDriver();
		driver.get(p.getProperty("url"));
		
		

	}

}
