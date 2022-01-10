/*

Byteland has a very strange monetary system.
Each Bytelandian gold coin has an integer number written on it. A coin n can be exchanged in a bank into 
three coins: n/2, n/3 and n/4. But these numbers are all rounded down (the banks have to make a profit).
You can also sell Bytelandian coins for American dollars. The exchange rate is 1:1. But you can not buy 
Bytelandian coins.
You have one gold coin. What is the maximum amount of American dollars you can get for it?

Constraints :
0 <= n <= 10 ^ 9

Time Limit: 1 sec
Sample Input 1 :
12
Sample Output 1 :
13
Explanation of Sample Output 1 :
 You can change 12 into 6, 4 and 3, and then change these into $6 + $4 + $3 = $13.
Sample Input 2 :
2
Sample Output 1 :
2
Explanation of Sample Output 2 :
If you try changing the coin 2 into 3 smaller coins, you will get 1, 0 and 0, and later you can get no more 
than $1 out of them. It is better just to change the 2 coin directly into $2.

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ByteLandian {

    //Recursive DP approach
     public static long bytelandian(long n, HashMap<Long, Long> memo) {
        if(n ==0|| n==1) return n;
         //DP part
        if(memo.containsKey(n)) return memo.get(n);
        long max = Math.max(n, bytelandian(n/2,memo) + bytelandian(n/3,memo) + bytelandian(n/4,memo));
        memo.put(n,max);
        return max;
	}
    // iterative DP approach// doesn't work for test case 4 and 6 because hashmaps can have 10^7 pairs but
    // here the constraint of n is 10^9
    public static long bytelandianIDP(long n, HashMap<Long, Long> memo) {
        memo.put((long)0,(long)0);
        memo.put((long)1,(long)1);
        
        for (int j=2;j<=n;j++) {
            long i = (long)j;
            long ans1 = memo.get(i/2);
            long ans2 = memo.get(i/3);
            long ans3 = memo.get(i/4);
            
            long res = ans1 + ans2 + ans3;
            memo.put(i, Math.max(res, i));
        }
        
        return memo.get(n);
	}

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws NumberFormatException, IOException {
            long n = Long.parseLong(br.readLine().trim());
            HashMap<Long, Long> memo = new HashMap<Long, Long>();
            System.out.println(bytelandian(n,memo));
    }
}
