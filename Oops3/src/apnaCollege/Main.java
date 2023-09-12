package apnaCollege;

abstract class Animal{
	// properties
	final int eyes = 2;
	
	// properties that are common to all class object
	// can be access by class name
	final static boolean breath = true;
	
	// to access static variable use static function
	// if we create non-static function we can't access that variable
	// with class name
	public static boolean isbreath() {
		return breath;
	}
	
	// Constructor
	public Animal(){
		System.out.println("it is type of Animal");
	}
	
	// complete method
	void hears() {
		System.out.println("it can hear");
	}
	
	// abstract method
	abstract String walk();
}

interface livingEnvironment{
	
	String environment();
}

interface eats{
	
	String eat();
}

class horse extends Animal implements livingEnvironment, eats{

	@Override
	public String eat() {
		return "Grass";
	}

	@Override
	public String environment() {
		return "ground";
	}

	@Override
	String walk() {
		return "walks on four leg";
	}
	
}

class tiger extends Animal implements livingEnvironment, eats{

	@Override
	public String eat() {
		return "meat";
	}

	@Override
	public String environment() {
		return "ground";
	}

	@Override
	String walk() {
		return "walks on 4 leg";	
	}
	
	
	
}


public class Main {
	
	public static void main(String[] args) {
		
		horse h = new horse();
		System.out.println("horse has "+ h.eyes+ " eyes");
		System.out.println("horse eats "+h.eat());
		System.out.println("horse " + h.walk() );
		System.out.println("horse lives on "+h.environment());
		
		tiger t = new tiger();
		System.out.println("tiger has "+ t.eyes+ "eyes");
		System.out.println("tiger eats "+t.eat());
		System.out.println("tiger " + t.walk() );
		System.out.println("tiger lives on "+t.environment());
		
	}
}
