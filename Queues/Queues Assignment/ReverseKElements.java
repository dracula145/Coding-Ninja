/*

For a given queue containing all integer data, reverse the first K elements.
You have been required to make the desired change in the input queue itself.

Contraints :
1 <= N <= 10^6
1 <= K <= N
-2^31 <= data <= 2^31 - 1

 Time Limit: 1sec
Sample Input 1:
5 3
1 2 3 4 5
Sample Output 1:
3 2 1 4 5
Sample Input 2:
7 7
3 4 2 5 6 7 8
Sample Output 2:
8 7 6 5 2 4 3

*/

import java.util.*;
public class ReverseKElements {
    public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
		input = helper(input, k);
        int c = input.size() - k;
        while(c-- > 0){
            input.add(input.remove());
        }
        return input;
	}
    public static Queue<Integer> helper(Queue<Integer> input, int k) {
		if(k==0) return input;
        int temp = input.remove();
        input = helper(input, k-1);
        input.add(temp);
        return input;
	}
}
