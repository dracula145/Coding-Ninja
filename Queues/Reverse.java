import java.util.*;

public class Reverse {

	public static void reverseQueue(Queue<Integer> input) {
        if(input.size()==1) return;
		int temp = input.remove();
        reverseQueue(input);
        input.add(temp);
	}

}