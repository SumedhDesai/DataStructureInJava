package oops3;

interface VehicleInteface {

	int numDoor();
	int numGear();

}

interface Ineterface {

	void print();
}

class Vehicle implements Ineterface {

	private String colour;

	public void setColour(String colour) {
		this.colour=colour;
	}
	public String getColour() {
		return colour;
	}
	@Override
	public void print() {
		System.out.print(this.colour+" ");
	}

}

abstract class Car extends Vehicle implements VehicleInteface{

	@Override
	public int numDoor() {
		return 4;
	}

	@Override
	public int numGear() {
		return 8;
	}

	public abstract String getComponey();

}

class BMW extends Car {

	public String getComponey() {
		return "BMW";
	}

}

class Truck extends Vehicle implements VehicleInteface {

	@Override
	public int numDoor() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int numGear() {
		// TODO Auto-generated method stub
		return 5;
	}

}

public class VehicleUse {
	public static void main(String[] args) {

		BMW B1= new BMW();
		B1.setColour("red");
		System.out.println( B1.getColour());
		System.out.println(B1.numDoor()+" "+B1.numGear());

		Truck T1= new Truck();
		T1.setColour("Black");
		System.out.println(T1.getColour()+"  "+T1.numDoor()+"  "+T1.numGear());
	}


}
