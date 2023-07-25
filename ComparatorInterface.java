package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> l= new ArrayList<Integer>();
		l.add(10);
		l.add(15);
		l.add(5);
		l.add(12);
		System.out.println(l);
		
		Comparator<Integer> c = (i1, i2) -> (i1<i2)?-1:(i1>i2)?+1:0;
		Collections.sort(l,c);
		l.stream().forEach(System.out::println);
		List<Integer> list = l.stream().filter(i->i%2==0).collect(Collectors.toList());
		list.stream().forEach(System.out::println);
	}

}
