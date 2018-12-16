package crackingCodingInterviews.arraysStrings;

public class UniqueChars {

	public static boolean isUnique(String val){
		
		boolean[] is_set = new boolean[128]; //128 chars in ascii
		for(int i=0;i<val.length();i++) {
			int c = val.charAt(i);
			if(is_set[c]) return false;
			is_set[c]=true;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println("abcdef"+" : "+ UniqueChars.isUnique("abcdef"));
		System.out.println("adam"+" : "+ UniqueChars.isUnique("adam"));
		System.out.println("xxxx"+" : "+ UniqueChars.isUnique("xxxx"));
		System.out.println("abcdefghijklmnopgrstuwx"+" : "+ UniqueChars.isUnique("abcdefghijklmnopgrstuwx"));



	}
}
