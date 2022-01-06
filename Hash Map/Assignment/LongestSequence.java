/*

You are given an array of unique integers that contain numbers in random order. You have to find the 
longest possible sequence of consecutive numbers using the numbers from given array.
You need to return the output array which contains starting and ending element. If the length of the 
longest possible sequence is one, then the output array must contain only single element.
Note:
1. Best solution takes O(n) time.
2. If two sequences are of equal length, then return the sequence starting with the number whose occurrence 
is earlier in the array.

Constraints :
0 <= n <= 10^6
Time Limit: 1 sec
Sample Input 1 :
13
2 12 9 16 10 5 3 20 25 11 1 8 6 
Sample Output 1 :
8 12 
Sample Input 2 :
7
3 7 2 1 9 8 41
Sample Output 2 :
7 9
Explanation: Sequence should be of consecutive numbers. Here we have 2 sequences with same length i.e. [1, 2, 3] and [7, 8, 9], but we should select [7, 8, 9] because the starting point of [7, 8, 9] comes first in input array and therefore, the output will be 7 9, as we have to print starting and ending element of the longest consecutive sequence.
Sample Input 3 :
7
15 24 23 12 19 11 16
Sample Output 3 :
15 16

*/

import java.util.*;

public class LongestSequence {

    // to store which starting_index comes first in array
    private static class Pair{
        int index;
        boolean toVisit;

        public Pair(int index, boolean toVisit){
            this.index = index;
            this.toVisit = toVisit;
        }
    }
    
    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
		HashMap<Integer, Pair> map = new HashMap<>();
        for(int i=0; i<arr.length; i++) map.put(arr[i], new Pair(i, true));  // true = element not traversed

        int max_count = 0, starting_no = -1, index = -1;
        for(Integer i : map.keySet()){
            if(!map.get(i).toVisit) continue;   // don't look if already traversed once
            map.get(i).toVisit = false;
            //map.put(i, false);

            int temp = i, count = 0;;
            while(map.containsKey(++temp)){ // traversing forward
                map.get(temp).toVisit = false;
                //map.put(temp, false);
                count++;
            }
            temp = i;       // traversing backward
            while(map.containsKey(--temp)){
                map.get(temp).toVisit = false;
                //map.put(temp, false);
                count++;
            }
            int t = Math.min(i, temp+1);
            if(count > max_count || (count == max_count && map.get(t).index < index)){
                max_count = count;
                starting_no = t;
                index = map.get(t).index;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(starting_no);
        if(max_count!=0) result.add(starting_no + max_count);
        return result;
    }
}
