package practice;

public class A {
	
	A(){
		System.out.println("Inside no argument constructor");
	}
	
	A(int a){
		this();
		System.out.println("Inside int argument constructor");
	}

	A(double a){
		this(3);
		System.out.println("Inside double argument constructor");
	}
	
	A(int a, int b){
		this(2.6);
		System.out.println("Inside int and double argument constructor");
	}
	
	A(double a, double b){
		this(2, 4);
		System.out.println("Inside double and double argument constructor");
	}
	
	A(double a, int b){
		this(2.4, 3.5);
		System.out.println("Inside double and int argument constructor");
	}
	
	public static void main(String[] args) {
		
		System.out.println("Program Starts");
		A a1 = new A(2.6, 8);
		

	}
	
	
class B{
	
 
}

}
