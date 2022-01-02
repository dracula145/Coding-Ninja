/*

Given a generic tree, find and return the height of given tree.

Constraints:
Time Limit: 1 sec
Sample Input 1:
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1:
3

*/

public class FindHeight {
    public static int getHeight(TreeNode<Integer> root){
		if(root == null) return 0;
        int height = 0;
        for(TreeNode<Integer> i : root.children) height = Math.max(height, getHeight(i));
        return height+1;
	}
}
