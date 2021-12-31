/*

For a given expression in the form of a string, find if there exist any redundant brackets or not. 
It is given that the expression contains only rounded brackets or parenthesis and the input expression 
will always be balanced.
A pair of the bracket is said to be redundant when a sub-expression is surrounded by unnecessary or 
needless brackets.
Example:
Expression: (a+b)+c
Since there are no needless brackets, hence, the output must be 'false'.

Expression: ((a+b))
The expression can be reduced to (a+b). Hence the expression has redundant brackets and the output 
will be 'true'.

Constraints:
0 <= N <= 10^6
Where N is the length of the expression.

Time Limit: 1 second
Sample Input 1:
a+(b)+c 
Sample Output 1:
true
Explanation:
The expression can be reduced to a+b+c. Hence, the brackets are redundant.
Sample Input 2:
(a+b)
Sample Output 2:
false

*/

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
