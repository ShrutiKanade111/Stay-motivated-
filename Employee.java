package java8;

public class Employee {
	
	int sal;
	String name;
	
	//String Addr;
	
	public Employee(int sal, String name) {
		this.sal=sal;
		this.name=name;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Employee [sal=" + sal + ", name=" + name + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/*
	 * public String getAddr() { return Addr; } public void setAddr(String addr) {
	 * Addr = addr; }
	 */
	

}
