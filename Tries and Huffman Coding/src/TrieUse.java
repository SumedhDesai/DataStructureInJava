/*
 * Implement Tries class
 */
public class TrieUse {
	
	public static void main(String[] args) {
		
		Tries t = new Tries();
		t.add("NOTE");
		t.add("AS");
		t.add("NINE");
		t.add("NO");
		System.out.println(t.search("NOTE"));
		System.out.println(t.search("NINE"));
		System.out.println(t.search("NO"));
//		t.remove("NO");
		System.out.println(t.search("NOTE"));
		t.remove("NOTE");
		System.out.println(t.search("NOTE"));

		System.out.println(t.search("NO"));
		System.out.println(t.countWord());
	}
}
