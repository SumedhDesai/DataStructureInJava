/*
 * Find subsequences of given string
 */
public class SubSequences {
	
	public static void main(String[] args) {
		String str = "abc";
		String[] ans = returnSubSequences(str);
		for(String s : ans) {
			System.out.println(s);
		}
		System.out.println("*");
		printSubSequences(str, "");
	}

	private static String[] returnSubSequences(String str) {
		if(str.length() == 0) {
			String[] ans = new String[1];
			ans[0]="";
			return ans;
		}
		String[] smallAns = returnSubSequences(str.substring(1));
		String[] ans = new String[2*smallAns.length];
		for(int i=0; i<smallAns.length; i++) {
			ans[i]=smallAns[i];
			ans[i+smallAns.length]=str.charAt(0)+smallAns[i];
		}
		return ans;
	}
	
	private static void printSubSequences(String str, String soFar) {
		if(str.length() == 0) {
			System.out.println(soFar);
			return;
		}
		printSubSequences(str.substring(1), soFar);
		char ch = str.charAt(0);
		printSubSequences(str.substring(1), soFar+ch);
	}
}
