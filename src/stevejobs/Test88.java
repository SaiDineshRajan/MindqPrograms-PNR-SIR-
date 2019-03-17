package stevejobs;

public class Test88
{
	public static void main(String[] args)
	{
		String x="mindq";
		String y="mindQ";
		int z=x.compareToIgnoreCase(y);
		System.out.println(z); //0
	}
}
