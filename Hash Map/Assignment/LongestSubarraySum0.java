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
