/*
 * Remove duplicate 
 */
import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] arr = {1,2,2,2,3,4,4,5,6,6,7};
		ArrayList<Integer> ans = removeDuplicates(arr);
		System.out.println(ans);
		// array list doesnt required for loop to print on consol
		// because it call stringTo() to print

	}

	private static ArrayList<Integer> removeDuplicates(int[] arr) {
		if(arr.length==0) {
			return null;
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		HashMap<Integer,Boolean> map = new HashMap<>();
		
		for(int i=0; i<arr.length; i++) {
			if(map.containsKey(arr[i])) {
				continue;
			}
			ans.add(arr[i]);
			map.put(arr[i], true);
		}
		return ans;
	}

}
