package stevejobs;

import java.util.Scanner;

public class Test116
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int x=sc.nextInt();
		System.out.println("Enter another number");
		int y=sc.nextInt();
		int z=0;
		try
		{
			z=x/y;
		}
		catch(ArithmeticException ex)
		{
			z=0;
		}
		finally
		{
			System.out.println(z);
		}
	}
}
