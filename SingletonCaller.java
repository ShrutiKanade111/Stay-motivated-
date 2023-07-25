package singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonCaller {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, CloneNotSupportedException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		SingletonClass singletonClassOriginal = SingletonClass.getInstance();
		
		System.out.println("Original Instance hash value "+singletonClassOriginal.hashCode());
		//Reflection
		
		  Class<?> singletonClass = Class.forName("singleton.SingletonClass");
		  Constructor<SingletonClass> declaredConstructor =
		  (Constructor<SingletonClass>) singletonClass.getDeclaredConstructor();
		  Constructor<SingletonClass> constructor = declaredConstructor;
		  constructor.setAccessible(true); SingletonClass singletonClassReflection
		  =constructor.newInstance(); System.out.println("Reflect object"+
		  singletonClassReflection);
		   
		  //Clonable
		 		
		SingletonClass singletonClassClone =  (SingletonClass) singletonClassOriginal.clone();
	    System.out.println("Clonable object "+singletonClassClone);
		
		//Deserializable
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:/serializable.ser"));
		objectOutputStream.writeObject(singletonClassOriginal);
		objectOutputStream.close();
		
		ObjectInputStream objectOutputStream2 = new ObjectInputStream(new FileInputStream("D:/serializable.ser"));
		SingletonClass singletonClassSerializable=(SingletonClass) objectOutputStream2.readObject();
		System.out.println("Serializable object"+singletonClassSerializable);
	}

}
