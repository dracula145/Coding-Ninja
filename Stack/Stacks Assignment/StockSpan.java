import java.util.*;
public class StockSpan {
    public static int[] stockSpan(int[] price) {
		int l = price.length, res[] = new int[l];
        if(l==0) return new int[] {0};
        Stack <Integer> stack = new Stack<>();
        stack.push(0);
        res[0] = 1;
        for(int i=1;i<l;i++){
        
        while(!stack.isEmpty() && price[stack.peek()]<price[i]) stack.pop();
        if(!stack.isEmpty()) res[i] = i - stack.peek();
        else res[i] = i+1;
        stack.push(i);
        }
        return res;
	}
}
