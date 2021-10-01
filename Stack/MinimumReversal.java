import java.util.*;
public class MinimumReversal {
    public static int countBracketReversals(String input) {
		int l = input.length();
        if((l&1) == 1) return -1; // odd number of brackets can't be balanced
        Stack <Character> bracket = new Stack<>();
        for(int i=0;i<l;i++){
            char c = input.charAt(i);
            if(c=='{') bracket.push(c);
            
            else{
                if(!bracket.isEmpty() && bracket.peek()=='{') bracket.pop();
                else bracket.push(c);
            }
        }
        // now the input expression is simplified.. all the balanced part is removed
        int k=0;
        while(!bracket.isEmpty()){
            char c1 = bracket.pop(), c2 = bracket.pop();
            if(c1==c2) k++;
            else k+=2;
        }
        return k;
	}
}
