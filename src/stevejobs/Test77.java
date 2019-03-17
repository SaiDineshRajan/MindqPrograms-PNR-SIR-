package stevejobs;

public class Test77
{
	public static void main(String[] args) 
	{
		//call method using object of interface
		Myinterface obj1=new Class4();
		int r1=obj1.addition(10, 60);
		System.out.println(r1);
		//call methods using object of concrete class
		Class4 obj2=new Class4();
		int r2=obj2.addition(10,60);
		System.out.println(r2);
		long r3=obj2.square(10);
		System.out.print(r3);
	}
}
