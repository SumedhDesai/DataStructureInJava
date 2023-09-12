/*
 * Remove duplicates from array
 */
import java.util.ArrayList;

public class RemoveDublicates {

	public static void main(String[] args) {

		int[] arr= {10,10,20,20,30,20,20,20,10};
		ArrayList<Integer> result= new ArrayList<>();
		result=removeDublicates(arr);
		for(int element:result) {
			System.out.println(element);
		}

	}

	public static ArrayList<Integer> removeDublicates (int[] arr){

		ArrayList<Integer> result= new ArrayList<>();
		result.add(arr[0]);
		for(int i=1; i<arr.length;i++) {
			if(arr[i]!=arr[i-1]) {
				result.add(arr[i]);
			}
		}

		return result; 
	}

}
