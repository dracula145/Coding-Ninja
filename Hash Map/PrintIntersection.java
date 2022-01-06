/*

You have been given two integer arrays/lists (ARR1 and ARR2) of size N and M, respectively. 
You need to print their intersection; An intersection for this problem can be defined when both 
the arrays/lists contain a particular value or to put it in other words, when there is a common 
value that exists in both the arrays/lists.

Note :
Input arrays/lists can contain duplicate elements.

The intersection elements printed would be in the order they appear in the first sorted array/list (ARR1).

Constraints :
0 <= N <= 10^6
0 <= M <= 10^6

Time Limit: 1 sec 
Sample Input 1 :
6
2 6 8 5 4 3
4
2 3 4 7 
Sample Output 1 :
2
3 
4
Sample Input 2 :
4
2 6 1 2
5
1 2 3 4 2
Sample Output 2 :
1 
2 
2

*/

import java.util.HashMap;

public class PrintIntersection {
    public static void printIntersection(int[] arr1,int[] arr2){
		HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr2) {       // first arr2 ... bcz we need to check in order in arr1
            if (map.containsKey(i)) map.put(i,map.get(i)+1);
            else map.put(i,1);
        }
        for(int i : arr1){
            if(map.containsKey(i)){
                System.out.println(i);
                map.put(i,map.get(i)-1);
                if(map.get(i) == 0) map.remove(i);
            } 
        } 
	}
}
