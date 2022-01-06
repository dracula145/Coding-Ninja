/*

You are given with an array of integers and an integer K. You have to find and print the count of all 
such pairs which have difference K.
Note: Take absolute difference between the elements of the array.

Constraints :
0 <= n <= 10^4
Time Limit: 1 sec
Sample Input 1 :
4 
5 1 2 4
3
Sample Output 1 :
2
Sample Input 2 :
4
4 4 4 4 
0
Sample Output 2 :
6

*/

import java.util.HashMap;

public class PairsWithDiffK {
    public static int getPairsWithDifferenceK(int arr[], int k) {
        int result = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr) { // only iterate once... best approach
            if(!map.containsKey(i)) map.put(i, 1);
            else map.put(i, map.get(i)+1);
               int t1 = Math.abs(i-k), t2 = i+k;
            if(map.containsKey(t1) && k!=0) result += map.get(t1);  //watch hint video last approach
            if(map.containsKey(t2) && k!=0) result += map.get(t2);  //watch hint video last approach
        }
        int res2 = 0;
        if(k==0){
         for(Integer i : map.keySet())  res2 += map.get(i)*(map.get(i)-1)/2;     // nC2 = n(n-1)/2
            return res2;
        }
        return result;
	}
}
