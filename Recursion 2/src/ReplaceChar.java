/*
 * Replace char with given char
 */
public class ReplaceChar {

	public static void main(String[] args) {
		
		System.out.println(replaceChar("axbxcxdx", 'x','y'));
	}

	private static String replaceChar(String str, char a, char b) {
		
		if(str.length()==0) {
			return str;
		}
		String smallStr=replaceChar(str.substring(1), a, b);
		if(str.charAt(0)==a) {
			return b+smallStr;
		}else {
		return str.charAt(0)+smallStr;
		}
	}

}
