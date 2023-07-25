package java8;

public class Employees {
	
	int deptid;
	String name;
	Double sal;
	
	Employees(int deptid, String name, Double sal)
	{
		this.deptid=deptid;
		this.name=name;
		this.sal=sal;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Employees [deptid=" + deptid + ", name=" + name + ", sal=" + sal + "]";
	}
	

}
