/*
 * Implement Map
 */
public class MapUse {

	public static void main(String[] args) {
		Map <String, Integer> map = new Map<>();
		for(int i=1; i<=10; i++) {
			map.insert("abc"+i, i+1);
			System.out.println(map.loadFactor());
		}
		map.removeKey("abc7");
		map.removeKey("abc9");

		for(int i=1; i<=10; i++) {
			System.out.println("abc"+i+":"+map.getValue("abc"+i));
		}
	}
}
