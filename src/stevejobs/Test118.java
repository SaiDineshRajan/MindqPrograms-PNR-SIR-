package stevejobs;
import java.util.ArrayList;
import java.util.Scanner;
public class Test118
{
	public static void main(String[] args)
	{
		//Create dynamic array
		ArrayList<Integer> x=new ArrayList<Integer>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter limit");
		int l=sc.nextInt();
		System.out.println("Enter "+l+" values");               
		for(int i=0;i<l;i++)
		{
			x.add(sc.nextInt());
		}
		//sorting
		for(int i=0;i<l;i++)
		{
			for(int j=0;j<l-1;j++)
			{
				if(x.get(j)>x.get(j+1))
				{
					int temp=x.get(j);
					x.set(j,x.get(j+1));
					x.set(j+1, temp);
				}
			}
		}
		//Display array
		for(int i=0;i<l;i++)
		{
			System.out.println(x.get(i));
		}
	}
}
