
public class UseGeneric {

	public static void main(String[] args) {
		
		Pair<Pair<String, Integer>, Pair<String, Double>> p = new Pair<>();
		Pair<String, Integer> pFirst = new Pair<>();
		Pair<String, Double> pSecound = new Pair<>();
		p.fi=pFirst;
		p.si=pSecound;
//		pFirst.fi="sam";
//		pFirst.si=100;
//		pSecound.fi="durga";
//		pSecound.si=0.0;
		
//		p.fi.fi="sum";
//		p.fi.si=100;
//		p.si.fi="kali";
//		p.si.si=0.0;
//		
//		System.out.println("[("+p.fi.fi+","+p.fi.si+") , ("+p.si.fi+","+p.si.si+")]");
		
//		Genrics<Integer> gi= new Genrics<Integer>(10, 1);
//		System.out.println(gi.a +" "+gi.b);
		
//		Integer [] arr= new Integer[5];
//		
//		for(int i=0; i<arr.length; i++) {
//			arr[i]=i+1;
//		}
//		printArray(arr);
		
		Vehicle [] v = new Vehicle[5];
		for(int i=0; i<v.length; i++) {
			v[i]=new Vehicle();
			v[i].setColour("A"+i);
		}
		printArray(v);
		
		Student [] s = new Student[5];
		for(int i=0; i<s.length; i++) {
			s[i]=new Student(i+1);
		}
		printArray(s);
	}
	
	public static <T extends Ineterface> void printArray(T[] arr) {
		for(int i=0; i<arr.length; i++) {
			arr[i].print();
		}
		System.out.println();
	}

}
