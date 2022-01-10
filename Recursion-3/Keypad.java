/*
Given an integer n, using phone keypad find out all the possible strings that can be made using digits of input n.
Return empty string for numbers 0 and 1.
Note : 1. The order of strings are not important.
2. Input and output has already been managed for you. You just have to populate the output array and return the count 
of elements populated in the output array.
Input Format :
Integer n
Output Format :
All possible strings in different lines
Constraints :
1 <= n <= 10^6
Sample Input:
23
Sample Output:
ad
ae
af
bd
be
bf
cd
ce
cf

*/

public class Keypad {
    public static String[] keypad(int n){
		if(n==0) return new String[] {""}; // base case

        String[] small_output = keypad(n/10);
        String options = options(n%10);

        String[] new_output = new String[small_output.length * options.length()];
        int c = 0;

        // multiply the strings e.g => a,b,c and de = ad, ae, bd, be, cd, ce
        for(String s : small_output) {
            for(int i=0; i<options.length(); i++)
            new_output[c++] = s + options.charAt(i);
        }
        return new_output;
	}

    //return corresponding strings of given number
    private static String options(int n){
        if(n==2) return "abc";
        if(n==3) return "def";
        if(n==4) return "ghi";
        if(n==5) return "jkl";
        if(n==6) return "mno";
        if(n==7) return "pqrs";
        if(n==8) return "tuv";
        if(n==9) return "wxyz";
        return "";
    }
}
