import java.util.*;
public class Bracket {
    public static boolean isBalanced(String expression) {
        Stack <Character> bracket = new Stack<>();
        for(int i=0;i<expression.length();i++){
            char c = expression.charAt(i);
            if(c=='(' || c=='{' || c=='[') bracket.push(c);
            else if(c==')'){
                if(!bracket.isEmpty() && bracket.peek()=='(') bracket.pop();
                else return false;
            }
            else if(c=='}'){
                if(!bracket.isEmpty() && bracket.peek()=='{') bracket.pop();
                else return false;
            }
            else if(c==']'){
                if(!bracket.isEmpty() && bracket.peek()=='[') bracket.pop();
                else return false;
            }
        }
        return bracket.isEmpty();
    }
}
