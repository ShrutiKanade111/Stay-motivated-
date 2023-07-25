package java8;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.Date;

public class predefinedFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Predicate
		Predicate<Integer> p= n -> n%2==0; 
		//IntPredicate
		System.out.println(p.test(5));
		
		BiPredicate<Integer, Integer> p1 = (a,b) ->a/b==0;
		System.out.println(p1.test(4, 2));
		
		String[] s= {"Shruti","Shweta","Trupti","Saii","Sonal"};
		
		Predicate<String> str= a -> a.length()>4 && a.startsWith("S");
		Consumer<String> c= st -> System.out.println("String is valid" + st);
		for(String s1:s)
		{
			if(str.test(s1))
			{
				c.accept(s1);
			}
		}
		
		//Function
		Function<Integer, Integer> f= i->i*i; //or i->{ return i*i; };
		
		Function<String, Integer> f2 = i->  i.length();
		System.out.println(f2.apply("Shruti"));
		System.out.println(f.apply(4));
		
		BiFunction<Integer,Integer,Integer> f1= (a,b) -> a+b;
		System.out.println(f1.apply(4, 5));
		
		
		//consumer
		
		Consumer<String> con = s2 -> System.out.println(s2);
		
		//Supplier
		
		Supplier<Date> sup = ()-> new Date();
		System.out.println(sup.get());
		
	}

}
