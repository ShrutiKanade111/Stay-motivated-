package singleton;

import java.io.Serializable;

public class SingletonClass implements Cloneable,Serializable{
	private static volatile SingletonClass singletonClass;
	
	//Reflection Break Solution
	private SingletonClass() {	
		/* if(singletonClass != null) throw new IllegalStateException(); */
		}
	
	
	//Clone method break solution
	
	/*
	 * @Override protected Object clone() throws CloneNotSupportedException { //
	 * TODO Auto-generated method stub throw new CloneNotSupportedException(); }
	 */
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	//Deserializable break solution
	/*
	 * protected Object readResolve() { return singletonClass; }
	 */
   public static SingletonClass getInstance()
   {
	    //Double checklocking
	   if(singletonClass == null)
		   /*synchronized(SingletonClass.class)
		   {
			   if(singletonClass== null)*/
				   singletonClass = new SingletonClass();
				/* } */
        return singletonClass;
   }
	
	

}
