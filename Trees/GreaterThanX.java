/*

Given a tree and an integer x, find and return number of Nodes which are greater than x.

Sample Input 1 :
35 10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
3
Sample Input 2 :
10 10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 2:
5

*/

import javax.swing.tree.TreeNode;

public class GreaterThanX {

    public static int numNodeGreater(TreeNode<Integer> root,int x){

		if(root == null) return 0;
        int ans = 0;
        for(TreeNode<Integer> i : root.children) ans += numNodeGreater(i, x);

        if(root.data > x) ans++;
        return ans;

	}
}
