import java.util.*;

public class PairSumTo0 {

    public static int PairSum(int[] input, int size) {
        int result = 0;
		HashMap <Integer, Integer> map = new HashMap<>();
        for(int i : input) { // only iterate once... best approach
            if(!map.containsKey(i)) map.put(i, 1);
            else map.put(i, map.get(i)+1);
               
            if(map.containsKey(-i) && i!=0) result += map.get(-i);  //watch hint video last approach
        }
        int adjustment = 0; // to count pairs having zeros
        if(map.containsKey(0)){
        int no_of_zeros = map.get(0);
        adjustment = no_of_zeros*(no_of_zeros-1)/2;
        }
        return result+adjustment;
	} 
}
