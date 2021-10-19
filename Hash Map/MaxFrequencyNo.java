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
