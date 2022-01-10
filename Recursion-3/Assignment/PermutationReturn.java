/*

Given a string, find and return all the possible permutations of the input string.
Note : The order of permutations are not important.
Sample Input :
abc
Sample Output :
abc
acb
bac
bca
cab
cba

*/

import java.util.Scanner;

public class PermutationReturn {

    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		String output[] = permutationOfString(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}
    
    public static String[] permutationOfString(String input){
		return helper(input, 0);
	}
    private static String[] helper(String input, int start){
        if(start == input.length()-1){
            String arr[] = new String[1];
            arr[0] = input.substring(start);
            return arr;
        }
        String[] temp = helper(input, start+1);
        String[] output = new String[temp.length * input.substring(start).length()]; // (n-1)! x n

        // if bc and cb received then abc, bac, bca and in next loop acb, cab, cba.. insert 1st ch$
        int count = 0;
        for(String s : temp){
            for(int i=0; i<=s.length() ; i++) 
            output[count++] = s.substring(0, i) + input.charAt(start) + s.substring(i);
        }
        return output;
    }
}
