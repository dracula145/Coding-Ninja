/*

You are given an array of integers that contain numbers in random order. Write a program to find and return the 
number which occurs the maximum times in the given input. If two or more elements contend for the maximum 
frequency, return the element which occurs in the array first.

Constraints:
0 <= N <= 10^8
Time Limit: 1 sec
Sample Input 1 :
13
2 12 2 11 12 2 1 2 2 11 12 2 6 
Sample Output 1 :
2
Sample Input 2 :
3
1 4 5
Sample Output 2 :
1

*/

import java.util.HashMap;

public class MaxFrequencyNo {

    // have to do in order... read qstn carefully

    public static int maxFrequencyNumber(int[] arr){ 
		
        HashMap<Integer,Integer> countMap = new HashMap<>();

        for (int i : arr) {
            if (countMap.containsKey(i)) countMap.put(i,countMap.get(i)+1);
            else countMap.put(i,1);
        }
        
        int maxCount = Integer.MIN_VALUE, maxEle = arr[0];
        for (int i : arr)  // don't traverse hashmap ow we can't get in order
        {
            if (countMap.get(i)>maxCount) {
                maxCount=countMap.get(i);
                maxEle=i;
            }
        }
        return maxEle;
    }
}
