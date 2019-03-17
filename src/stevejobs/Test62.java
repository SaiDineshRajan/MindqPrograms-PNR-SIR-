package stevejobs;
import java.io.File;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;
public class Test62 
{
	public static void main(String[] args) throws Exception
	{
		File fo=LoadLibs.extractTessResources("tessdata");
		ITesseract obj=new Tesseract();
		obj.setDatapath(fo.getAbsolutePath());
		File f=new File("C:\\Users\\Mindq-pc\\Desktop\\untitled.png"); //take any image
		String result=obj.doOCR(f);
		Thread.sleep(10000);
		System.out.println(result);
	}
}







