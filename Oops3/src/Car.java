
public abstract class Car extends Vehicle implements VehicleInteface{

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
