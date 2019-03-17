package stevejobs;
import java.util.Iterator;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;
public class Test45
{
	public static void main(String[] args) throws Exception
	{
		Screen s=new Screen();
		s.click("mini.png");
		Thread.sleep(5000);
		Iterator<Match> l=s.findAll("file.png");
		l.next();
		l.next().click();
	}
}







