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
