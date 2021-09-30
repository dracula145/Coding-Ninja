import java.util.*;
public class RedundantBracket {
    public static boolean checkRedundantBrackets(String expression) {
        int l = expression.length();
		//if(expression.charAt(0) == '(' && expression.charAt(l-1) == ')') return true;
        if(l==0 || l==1) return false;
        Stack <Character> stack = new Stack<>();
        for(int i=0;i<l;i++){
            char c = expression.charAt(i);
            if(c != ')') stack.push(c);
            else{
                int k = 0;
                while(stack.pop() != '(') k++;
                if(k<=1) return true;
            }
        }
        return false;
	}
}
