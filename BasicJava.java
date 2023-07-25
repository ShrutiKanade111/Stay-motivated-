package basicJava;

public class BasicJava {

	private int real;
	private int imaginary;
	private BasicJava b;
	public BasicJava(int real, int imaginary) {
		// TODO Auto-generated constructor stub
		
		this.real= real;
		this.imaginary= imaginary;
		
	}
	
	public void plus(BasicJava b)
	{
		this.b=b;
	real = real + b.real;
	imaginary= imaginary +b.imaginary;
	System.out.println(real+" + "+"i"+imaginary);
	System.out.println(b.real+" + "+"i"+b.imaginary);
	}
	
	public void minus(BasicJava b)
	{
		this.b=b;
	imaginary= imaginary * b.real + real * b.imaginary;
	real = real + b.imaginary;
	System.out.println("-"+real+" + "+"i"+imaginary);
	System.out.println(b.real+" + "+"i"+b.imaginary);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicJava b1= new BasicJava(4,5);
		BasicJava b2= new BasicJava(6,7);
		b1.plus(b2);
		BasicJava b3= new BasicJava(4,5);
		BasicJava b4= new BasicJava(6,7);
		b3.minus(b4);

	}

}
