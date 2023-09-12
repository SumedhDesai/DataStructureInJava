package dynamicArray;

public class DynamicArrayUse {

	public static void main(String[] args) {

		DynamicArray d1 = new DynamicArray();
		
		for(int i=0; i<100; i++) {
			d1.add(100+i);
		}
	System.out.println(d1.get(1000));
	}
}