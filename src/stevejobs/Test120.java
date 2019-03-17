package stevejobs;
import java.util.HashMap;
import java.util.Map.Entry;
public class Test120
{
	public static void main(String[] args)
	{
		HashMap<Integer,String> hp=
				new HashMap<Integer,String>();
		//Storing data to hash map
		hp.put(101,"kalam");
		hp.put(102,"Steve jobs");
		hp.put(103,"Sachin");
		//Getting data from hash map
		for(Entry<Integer,String> m:hp.entrySet())              
		{  
			 System.out.println(m.getValue());  
		} 
	}
}
