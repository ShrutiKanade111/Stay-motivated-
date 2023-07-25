package java8;

import java.util.ArrayList;
import java.util.function.Predicate;


//name and salary is greater than 2000
public class PredefinedEmployee {
	
	public static void main(String[] arg)
	{
		ArrayList<Employee> al = new ArrayList<Employee>();
		
		al.add(new Employee(1000,"Shruti"));
		al.add(new Employee(1900,"Omkar"));		
		al.add(new Employee(3000,"Shweta"));	
		
		Predicate<Employee> p = e->e.sal>2000 && e.name.startsWith("S");
		Predicate<Employee> p1 = e-> e.name.contains("m");
		for(Employee e1:al)
		{
			if(p.and(p1).test(e1))
			{
				System.out.println("Employee eligible" +e1.toString());
			}
			
		}
	}

}
