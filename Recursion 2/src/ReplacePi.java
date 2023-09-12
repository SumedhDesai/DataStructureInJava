/*
 * replace pi char with 3.14
 */
public class ReplacePi {

	public static void main(String[] args) {
		
		System.out.println(replacePi("apibpicippopi"));
	}

	private static String replacePi(String str) {
		
		if(str.length()<=1) {
			return str;
		}
		if(str.charAt(0)=='p' && str.charAt(1)=='i') {
			String smallStr= replacePi(str.substring(2));
			return "3.14"+smallStr;
		}else {
			String smallStr= replacePi(str.substring(1));
			return str.charAt(0)+smallStr;
		}
	}

}
