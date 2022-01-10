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

public class PrintSubsequencesInsideRecusiveFunction {

    public static void main(String args[]){
        printSubsequences("abc", "");
    }

    public static void printSubsequences(String word, String string_so_far){
        if(word.length() == 0){
            System.out.print(string_so_far + " ");
            return;
        }
        printSubsequences(word.substring(1), string_so_far);
        printSubsequences(word.substring(1), string_so_far + word.charAt(0));
    }
}
