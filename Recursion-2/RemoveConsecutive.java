/*
Given a string S, remove consecutive duplicates from it recursively.
Input Format :
String S
Output Format :
Output string
Constraints :
1 <= |S| <= 10^3
where |S| represents the length of string
Sample Input 1 :
aabccba
Sample Output 1 :
abcba
Sample Input 2 :
xxxyyyzwwzzz
Sample Output 2 :
xyzwz
*/

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
