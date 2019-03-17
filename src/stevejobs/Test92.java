package stevejobs;

import java.util.Scanner;

public class Test92
{
	public static void main(String[] args)
	{
		//Get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number");
		int x=Integer.parseInt(sc.nextLine());
		//validation
		if(x%2==0)
		{
			System.out.println(x+" is even number");            
		}
		else
		{
			System.out.println(x+" is odd number");
		}
		

	}

}
