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
