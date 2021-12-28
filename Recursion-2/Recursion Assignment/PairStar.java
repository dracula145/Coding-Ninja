/*

Given a string S, compute recursively a new string where identical chars that are adjacent in the original string are separated from each other by a "*".
Input format :
String S
Output format :
Modified string
Constraints :
0 <= |S| <= 1000
where |S| represents length of string S.
Sample Input 1 :
hello
Sample Output 1:
hel*lo
Sample Input 2 :
aaaa
Sample Output 2 :
a*a*a*a

*/

import java.util.Scanner;

public class PairStar {
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(addStars(input));
	}
    public static String addStars(String s) {
		if(s.length()==0 || s.length()==1) return s;
        if(s.charAt(0) == s.charAt(1)) return s.charAt(0) + "*" + addStars(s.substring(1));
        return s.charAt(0) + addStars(s.substring(1));
	}
}

