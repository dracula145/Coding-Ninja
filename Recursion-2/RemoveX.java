/*
Given a string, compute recursively a new string where all 'x' chars have been removed.
Input format :
String S
Output format :
Modified String
Constraints :
1 <= |S| <= 10^3
where |S| represents the length of string S. 
Sample Input 1 :
xaxb
Sample Output 1:
ab
Sample Input 2 :
abc
Sample Output 2:
abc
Sample Input 3 :
xx
Sample Output 3:
*/

import java.util.Scanner;

public class RemoveX{
    public static String removeX(String input){
        if(input.length() == 0 ) return input;
        String smallerString = removeX(input.substring(1));
    	if(input.charAt(0) == 'x') return smallerString;
        else return input.charAt(0) + smallerString;
    }
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(removeX(input));
	}
}