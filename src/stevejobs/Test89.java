package stevejobs;
public class Test89
{
	public static void main(String[] args) 
	{
		//Parent class object to access Parent memmbers
		Parent p=new Parent();
		p.m1=10;
		p.displayparent();
		//Son class object to access Son & Parent members
		Son s=new Son();
		s.m1=10;
		s.m2=20;
		s.displayparent();
		s.displaychild();
		//Soninlaw class object to access Soninlaw members
		Soninlaw sl=new Soninlaw();
		sl.daughter.m1=10;
		sl.m2=20;
		sl.daughter.displayparent();
		sl.displaysoninlaw();
	}
}



