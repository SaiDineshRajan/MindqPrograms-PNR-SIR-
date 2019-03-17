package stevejobs;

import java.util.Scanner;

public class Test99
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter cc type");
		String cc=sc.nextLine();
		switch(cc)
		{
		case "visa":
			System.out.println("Correct type");
			break;
		case "master":
			System.out.println("Correct type");
			break;
		default:
			System.out.println("Invalid card");                  
			break;
		}

	}

}
