package stevejobs;
import java.util.Scanner;
public class Test103
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		long x=Integer.parseInt(sc.nextLine());
		long y=0;
		while(x!=0)
		{
			int d=(int) (x%10); //get last digit
			y=y*10+d; //add to reverse
			x=(int)x/10; //remove last digit
		}
		System.out.println(y);
	}
}






