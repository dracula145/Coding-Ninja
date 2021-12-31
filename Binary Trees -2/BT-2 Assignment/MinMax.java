/*

For a given a Binary Tree of type integer, find and return the minimum and the maximum data values.
Return the output as an object of Pair class, which is already created.
Note:
All the node data will be unique and hence there will always exist a minimum and maximum node data.

Constraints:
2 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
Sample Output 1:
1 14
Sample Input 2:
10 20 60 -1 -1 3 50 -1 -1 -1 -1 
Sample Output 2:
3 60

*/

import java.lang.*;

class Pair<T, U> {
    T minimum;
    U maximum;

    public Pair(T minimum, U maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

}
public class MinMax {
    public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
		if(root == null) return new Pair<Integer,Integer>(Integer.MAX_VALUE,Integer.MIN_VALUE);
        
        Pair<Integer, Integer> leftOutput = getMinAndMax(root.left);
        Pair<Integer, Integer> rightOutput = getMinAndMax(root.right);
        Pair<Integer, Integer> ans = new Pair<>(0,0);
        
        ans.minimum = Math.min(root.data, Math.min(leftOutput.minimum, rightOutput.minimum));
        ans.maximum = Math.max(root.data, Math.max(leftOutput.maximum, rightOutput.maximum));
        return ans;
	}
}
