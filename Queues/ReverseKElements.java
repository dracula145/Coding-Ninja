import java.util.*;
public class ReverseKElements {
    public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
		input = helper(input, k);
        int c = input.size() - k;
        while(c-- > 0){
            input.add(input.remove());
        }
        return input;
	}
    public static Queue<Integer> helper(Queue<Integer> input, int k) {
		if(k==0) return input;
        int temp = input.remove();
        input = helper(input, k-1);
        input.add(temp);
        return input;
	}
}
