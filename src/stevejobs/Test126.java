package stevejobs;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test126 
{
	@Parameters({"input1","input2"})
	@Test(priority=0)
	public void method(String x,String y)
	{
		int z=Integer.parseInt(x)+Integer.parseInt(y);
		System.out.println(z);
	}
}








