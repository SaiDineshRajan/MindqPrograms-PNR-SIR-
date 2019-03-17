package stevejobs;
import java.util.Scanner;
public class Test114
{
	public static void main(String[] args) throws 
	           InterruptedException, ArithmeticException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int x=sc.nextInt();
		System.out.println("Enter another number");
		int y=sc.nextInt();
		Thread.sleep(5000);
		int z=x/y;
		System.out.println(z);
	}
}

