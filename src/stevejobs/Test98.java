package stevejobs;
import java.util.Scanner;
public class Test98
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		String n=sc.nextLine();
		String x=null;
		for(int i=0;i<n.length();i++)
		{
			char c=n.charAt(i);
			switch(c)
			{
			case '0':
				x="zero";
				break;
			case '1':
				x="one";
				break;
			case '2':
				x="two";
				break;
			case '3':
				x="three";
				break;
			case '4':
				x="four";
				break;
			case '5':
				x="five";
				break;
			case '6':
				x="six";
				break;
			case '7':
				x="seven";
				break;
			case '8':
				x="eight";
				break;
			case '9':
				x="nine";
				break;
			}
			System.out.print(x+" ");                                
		}
	}
}



