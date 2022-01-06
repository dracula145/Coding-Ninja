/*

Given an array consisting of positive and negative integers, find the length of the longest subarray whose 
sum is zero.

Constraints:
0 <= N <= 10^8
Time Limit: 1 sec
Sample Input 1:
10 
 95 -97 -387 -435 -5 -70 897 127 23 284
Sample Output 1:
5
Explanation:
The five elements that form the longest subarray that sum up to zero are: -387, -435, -5, -70, 897 

*/

import java.util.HashMap;

public class LongestSubarraySum0 {
    public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
		HashMap <Integer, Integer> map = new HashMap<>();
        int sum = 0, max_len = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];

            // if at any stage sum=0, => from 0 to i... all result to 0 => longest leangth
            if(sum == 0) max_len = i+1; // like test case 2 -2 0 -2 2... 

            if(map.containsKey(sum)){
                int len = i-map.get(sum);
                if(len>max_len) max_len = len;
            }
            map.put(sum, i);
        }
        return max_len;
	}
}
