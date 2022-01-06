/*

Given a string S, you need to remove all the duplicates. That means, the output string should contain 
each character only once. The respective order of characters should remain same, as in the input string.

Constraints :
0 <= Length of S <= 10^8
Time Limit: 1 sec
Sample Input 1 :
ababacd
Sample Output 1 :
abcd
Sample Input 2 :
abcde
Sample Output 2 :
abcde

*/

package Assignment;

import java.util.HashMap;

public class UniqueChar {
    public static String uniqueChar(String str){
		HashMap<Character, Boolean> map = new HashMap<>();
        String result = "";
        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);
            if(!map.containsKey(c)){
                result += c;
                map.put(c, true);
            }
        }
        return result;
	}
}
