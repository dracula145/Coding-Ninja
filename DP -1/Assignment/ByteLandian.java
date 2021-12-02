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
