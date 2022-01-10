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

public class KeypadInsideRecusiveFunction {
    public static void printKeypad(int input){
		printKeypadHelper(input, "");
	}
    public static void printKeypadHelper(int input, String string_so_far){
        if(input == 0){
            System.out.println(string_so_far);
            return;
        }
        String options = options(input%10);
        for(int i=0; i<options.length(); i++){
            printKeypadHelper(input/10, options.charAt(i) + string_so_far);
        }
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
