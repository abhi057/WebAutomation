package practice;

import org.testng.annotations.Test;

public class StringDemo {
	
	
	/**
	 * String Concepts
	 */
	@Test(priority=1)
	public void stringDemo(){
		
		//String is an object that represents a sequence of Characters
		//Two was of declaring Strings
		// 1. With String Literal  - Created in String pool
		String s1 = "My name is Abhi";
		String s2 = "My name is Abhi";
		
		System.out.println(s1);
		System.out.println(s2);
		
		
		//2. With new Keyword - Created in Heap Memory
		String s3 = new String("My name is Abhi");
		String s4 = new String("My name is Abhi");
		
		System.out.println(s3);
		System.out.println(s4);
		
		
		
		// "==" - Used to compare String object references and not the content of the objects
		// "equals()" -Used to compare the content of two Strings, regardless of where they are located in the memory
		
//		In most cases, when comparing the content of strings, you should use String.equals() rather than == to avoid unexpected 
//		results due to the differences in object references.
		
		
		
	}

}
