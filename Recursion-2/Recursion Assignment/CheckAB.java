/*

Suppose you have a string, S, made up of only 'a's and 'b's. Write a recursive function that checks if the string was generated using the following rules:
a. The string begins with an 'a'
b. Each 'a' is followed by nothing or an 'a' or "bb"
c. Each "bb" is followed by nothing or an 'a'
If all the rules are followed by the given string, return true otherwise return false.
Input format :
String S
Output format :
'true' or 'false'
Constraints :
1 <= |S| <= 1000
where |S| represents length of string S.
Sample Input 1 :
abb
Sample Output 1 :
true
Sample Input 2 :
abababa
Sample Output 2 :
false

*/

import java.util.Scanner;

public class CheckAB {
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		System.out.println(checkAB(input));
	}
    public static boolean checkAB(String input) {
      if(input.length() == 0) return false;
      if(input.charAt(0) == 'b') return false;  // to check if string starts with a 'b'
      return check(input);
	}
  public static boolean check(String input){
    if(input.length()==0) return true;
    if(input.equals("ab") || input.equals("ba") || input.equals("b")) return false;  //last remaining substring
    if(input.charAt(0)=='a') return check(input.substring(1));
    if(input.charAt(0)=='b' && input.charAt(1)=='b') return check(input.substring(2));
    return false;
  }
}
