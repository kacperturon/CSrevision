package crackingCodingInterviews.arraysStrings;

import java.util.Arrays;

public class Permutations {
	
	public static String sort(String val) {
		char[] chars = val.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	
	public static boolean isPermutation(String val1, String val2) {
		if(val1.length() != val2.length()) return false;
		return sort(val1).equals(sort(val2));
	}
	
	public static boolean isPermutation2(String val1, String val2) {
		if(val1.length() != val2.length()) return false;
		int[] chars = new int[128]; //Ascii

		for(int i=0; i<val1.length();i++)
		{
			chars[val1.charAt(i)]++;
		}
		
		for(int i=0; i<val2.length();i++) {
			int c = val2.charAt(i);
			chars[c]--;
			if(chars[c]<0)return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println("Abcd "+" "+"dabc"+" : "+Permutations.isPermutation("Abcd", "dabc"));
		System.out.println("abcd "+" "+"dabc"+" : "+Permutations.isPermutation("abcd", "dabc"));
		System.out.println("test "+" "+"best"+" : "+Permutations.isPermutation("test", "best"));
		System.out.println("ekans "+" "+"snake"+" : "+Permutations.isPermutation("ekans", "snake"));

		System.out.println();
		
		System.out.println("Abcd "+" "+"dabc"+" : "+Permutations.isPermutation2("Abcd", "dabc"));
		System.out.println("abcd "+" "+"dabc"+" : "+Permutations.isPermutation2("abcd", "dabc"));
		System.out.println("test "+" "+"best"+" : "+Permutations.isPermutation2("test", "best"));
		System.out.println("ekans "+" "+"snake"+" : "+Permutations.isPermutation2("ekans", "snake"));


	}
}
