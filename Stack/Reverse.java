import java.util.*;
public class Reverse {
    public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
		if(input.size() == 1 || input.size() == 0) return ;
        int temp = input.pop();
        reverseStack(input, extra);
        while(!input.isEmpty()) extra.push(input.pop());
        input.push(temp);
        while(!extra.isEmpty()) input.push(extra.pop());
	}
}
