
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
