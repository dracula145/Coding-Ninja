/*

Given an integer n, using phone keypad find out and print all the possible strings that can be made using digits of input n.
Note : The order of strings are not important. Just print different strings in new lines.
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

import java.util.ArrayList;
public class PrintSubsequences {
    public static void main(String args[]){
        ArrayList<String> subsequence = printSubsequences("abc");
        for(String s : subsequence) System.out.print(s + " ");
    }

    /* every function call, add the first character of the word
        to all the elements in array list
        hence doubling it
    */
    public static ArrayList<String> printSubsequences(String word){
        if(word.length() == 0){
            ArrayList<String> result = new ArrayList<>();
            result.add("");
            return result;
        }

        ArrayList<String> output = printSubsequences(word.substring(1));
        int length = output.size();
        for(int i=0; i<length; i++) output.add(word.charAt(0) + output.get(i));

        return output;
    }
}
