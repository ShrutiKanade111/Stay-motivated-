package java8;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIEx {
	
	public static boolean isPrime(int number)
	{
		return number>1 && IntStream.range(2, number).noneMatch(n->number%n==0);
	}

	public static void main(String[] args) {
		
		//find even number multiply with 2 and then add those number in one (map, reduce, filter and peek optional if no start value else int)
		//sun using redure or collectors
		List<Integer> al = Arrays.asList(1,3,5);
		
		Optional<Integer> l= al.stream().filter(i->i%2==0).peek(System.out::println).map(i->i*2).peek(System.out::println).reduce((c,e)-> c+e);
		Optional<Integer> l1= al.stream().filter(i->i%2==0).peek(System.out::println).map(i->i*2).peek(System.out::println).reduce(Integer::sum);
		System.out.println(l);
		
		//collectors
		
		Double d= al.stream().map(i->i+2).collect(Collectors.summingDouble(i->i));
		System.out.println("collectors =" +d);
		//Count of each word 
		
		String s= "My name My name Shruti and your name";
		List<String> li = Arrays.asList(s.split(" "));		
		
		Map<String, Long> map =li.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(map);
		
		//number is prime or not
		Boolean b = IntStream.range(2, 7).noneMatch(n->n%n==0);
		IntStream.range(1,10).filter(i->i%2==0).forEach(System.out::println);
		System.out.println(b);
		
		
		//Find duplicate element in given integer list
		
		int[] a= {2,4,5,6,4,5,7,78,8,5,4};
		Set<Integer> set = new HashSet<Integer>();
		
	    IntStream.of(a).filter(s3->!set.add(s3)).distinct().forEach(System.out::println);
	    
	    //1st 10 prime number and then square root of those number 
	    
	    List<Double> lis = Stream.iterate(1,i->i+1).filter(StreamAPIEx::isPrime).map(Math::sqrt).limit(10).collect(Collectors.toList());
	    System.out.println(lis);
	    System.out.println("----------------------");
	    //convert list to set
	    
	    List<Integer> list1 = Arrays.asList(1,3,5,7,3,5,7,4,3,2);
	    
	    Set<int[]> set1 = Stream.of(a).collect(Collectors.toSet());
	    Set<Integer> set2 = list1.stream().collect(Collectors.toSet());
	    set2.forEach(System.out::println);
	    Map<Integer,Integer> map1= set2.stream().collect(Collectors.toMap(k->k, t->t));
	    
	    System.out.println("toMap"+map1);
	    
	    
	    //find duplicate using groupingBy
	    Set<String> duplicate = map.entrySet().stream().filter(entry->entry.getValue()>1).map(entry->entry.getKey()).collect(Collectors.toSet());
	    
	    System.out.println("Duplicate -"+duplicate);
	    
	    
	    //Employee sort salary in descending order
	    
	    List<Employee> empSalary= new ArrayList<Employee>();
	    
	    empSalary.add(new Employee(1000,"Shruti"));
	    empSalary.add(new Employee(500,"Shweta"));
	    empSalary.add(new Employee(800,"Trupti"));
	    empSalary.add(new Employee(800,"Trupti"));
	    
	    List<Employee> desSal= empSalary.stream().sorted((emp1,emp2)-> (emp1.getSal()>emp2.getSal())?-1:(emp1.getSal()<emp2.getSal())?+1:0).skip(1).limit(1).collect(Collectors.toList());
	    Employee young=empSalary.stream().min((emp1,emp2)-> (emp1.getSal()>emp2.getSal())?-1:(emp1.getSal()<emp2.getSal())?+1:0).get();
	    Employee Older=empSalary.stream().max((emp1,emp2)-> (emp1.getSal()>emp2.getSal())?-1:(emp1.getSal()<emp2.getSal())?+1:0).get();
	    
	    Employee young2=empSalary.stream().min(Comparator.comparingInt(Employee::getSal).reversed()).get();
	    Employee Older2=empSalary.stream().max(Comparator.comparingInt(Employee::getSal).reversed()).get();
	    
	    
	    Double avgSal=empSalary.stream().collect(Collectors.averagingInt(e->e.getSal()));
	    System.out.println("descending-"+desSal);
	    System.out.println("Young-"+young);
	    System.out.println("Older-"+Older);
	    System.out.println("Average Sal ="+avgSal);
	    
	    System.out.println("Young2-"+young);
	    System.out.println("Older2-"+Older);
	    
	    //or
	    
	    IntSummaryStatistics iss = empSalary.stream().mapToInt(e->e.getSal()).summaryStatistics();
	    System.out.println("Young-"+iss.getMin());
	    System.out.println("Older-"+iss.getMax());
	    System.out.println("Average Sal ="+iss.getAverage());
	    System.out.println("count Sal ="+iss.getCount());
	    System.out.println("Sum Sal ="+iss.getSum());
	    //or
	    
	    Optional<Employee> young1=empSalary.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getSal)));
	    Optional<Employee> Older1=empSalary.stream().collect(Collectors.minBy(Comparator.comparingInt(Employee::getSal)));
	    
	    Double avgSal1=empSalary.stream().collect(Collectors.averagingInt(e->e.getSal()));
	    System.out.println("descending-"+desSal);
	    System.out.println("Young1-"+young1);
	    System.out.println("Older-"+Older1);
	    System.out.println("Average Sal ="+avgSal1);
	    
	    //convert name to upper case and join using ,
	    
	    String joinString= empSalary.stream().map(e->e.getName()).collect(Collectors.joining(","));
	    
	    System.out.println(joinString);
	    
	    //groupBy salary
	    
	    Map<Integer, List<Employee>> gmap=empSalary.stream().collect(Collectors.groupingBy(e->e.getSal()));
	    System.out.println(" grpBy"+gmap);
	    
	    Map<Integer, Set<Employee>> gmap1=empSalary.stream().collect(Collectors.groupingBy(Employee::getSal,Collectors.toSet())); //hashcode and equal nees to override
	    System.out.println(" grpBy"+gmap1);
	    
	    //sorting using comparator
	    
	    empSalary.sort(Comparator.comparing(Employee::getSal).reversed().thenComparing(Employee::getName));
	    System.out.println(empSalary);
	    
	    Optional<List<Employee>> o=Optional.of(empSalary.stream().filter(e->e.getSal()>2000).collect(Collectors.toList()));
	    
	    //Optional<List<Employee>> o=Optional.of(ll);
	    
	    if(o.isPresent())
	    {
	    	System.out.println(o);
	    }
	    
	    
	    //character
	    
	    //vowel characters
	    
	    String vowel ="hjgdahgdyutwerienskdvjwud";
	    
	    Long count= vowel.chars().mapToObj(x->(char)x).filter(x->{return(x=='a'||x=='o'||x=='u'||x=='i'||x=='e');}).count();
	    System.out.println("Vowel Count ="+count);
	    
	    //duplicate characters
	    
	    Map<String,Long> dchar =vowel.chars().mapToObj(x->(char)x).collect(Collectors.groupingBy(Object::toString,Collectors.counting()));
	    System.out.println(dchar);
	    
	    List<String> list11=dchar.entrySet().stream().filter(e->e.getValue()>1).map(x->x.getKey()).map(x->x).collect(Collectors.toList());
	    
	    System.out.println(list11);
	    
	    
	    //Max salary of Employee from each department 
	    
	    List<Employees> maxDeptSal = new ArrayList<>();
	    maxDeptSal.add(new Employees(1, "Shruti", 10000.0));
	    maxDeptSal.add(new Employees(1, "Shruti1", 10000.0));
	    maxDeptSal.add(new Employees(1, "Trupti", 500.0));
	    maxDeptSal.add(new Employees(1, "Shweta", 800.0));
	    maxDeptSal.add(new Employees(2, "Omkar", 60000.0));
	    maxDeptSal.add(new Employees(2, "AAkash", 10000.0));
	    maxDeptSal.add(new Employees(3, "Sai", 20000.0));
	    
	    Map<Integer, Optional<Employees>> maxSal=maxDeptSal.stream().collect(Collectors.groupingBy(Employees::getDeptid,Collectors.reducing(BinaryOperator.maxBy(Comparator.comparingDouble(Employees::getSal)))));
	    
	    maxSal.forEach((key,value)->System.out.println("Key =" +key+ "Value ="+value));
	    System.out.println(maxSal);
	    
	    //pring employee details for each department
	    
	    Map<Integer, List<Employees>> empDet=maxDeptSal.stream().collect(Collectors.groupingBy(Employees::getDeptid));
	    System.out.println(empDet);
	    
	    Map<Integer, Set<Employees>> orer=maxDeptSal.stream().collect(Collectors.groupingBy(Employees::getDeptid,TreeMap::new,Collectors.toSet()));
	    System.out.println(orer);
	    
	    
	    //Average the sal according to dept id
	    
	    Map<Integer,Double> mapp=maxDeptSal.stream().collect(Collectors.groupingBy(Employees::getDeptid, Collectors.summingDouble(Employees::getSal)));
	    
	    System.out.println(mapp);
	    
	    
}

}
