package stevejobs;

import java.util.Scanner;

public class Test104
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter limit");
		long l=Integer.parseInt(sc.nextLine());
		int x=0;
		int y=1;
		System.out.print(x+" "+y+" ");                          
		int z=x+y;
		do
		{
			System.out.print(z+" ");
			x=y;
			y=z;
			z=x+y;
		}while(z<=l);	
	}
}







