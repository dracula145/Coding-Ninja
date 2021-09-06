import java.util.Scanner;

public class RemoveConsecutive {
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
    	String input = s.next();
    	System.out.println(removeConsecutiveDuplicates(input));
    }
    public static String removeConsecutiveDuplicates(String s) {
		if(s.length() ==0 || s.length()==1) return s;
        if(s.charAt(0) == s.charAt(1)) return removeConsecutiveDuplicates(s.substring(1));
        else return s.charAt(0) + removeConsecutiveDuplicates(s.substring(1));
	}
}
