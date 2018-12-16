package crackingCodingInterviews.arraysStrings;

public class spaceEncoder {
	public static String encodeSpaces(String val) {
		if(val.length()<1) return "";
		int spaces = 0;
		for(int i=0;i<val.length();i++) {
			char c = val.charAt(i);
			if(c == ' ') spaces++;
		}
		if(spaces>0) {
			char[] output = new char[val.length()+(spaces*3)];
			for(int i=0, index=0;i<val.length();i++) {
				char c = val.charAt(i);
				if(c==' ') {
					output[index]='%';
					output[index+1]='2';
					output[index+2]='0';
					index+=3;
				}else {
					output[index]=c;
					index++;
				}
				
			}
			
			return new String(output);
		}
		return val;
	}
	
	
	public static void main(String[] args) {
		System.out.println("kacper turon test" +" : "+spaceEncoder.encodeSpaces("kacper turon test"));
		System.out.println("kacperuronest" +" : "+spaceEncoder.encodeSpaces("kacperuronest"));
		System.out.println("" +" : "+spaceEncoder.encodeSpaces(""));

	}
}
