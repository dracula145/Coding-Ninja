/*

Given a generic tree, count and return the number of leaf nodes present in the given tree.

Output Format :
Count of leaf nodes
Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
4

*/

public class NumberOfLeaf {
    public static int countLeafNodes(TreeNode<Integer> root){
        if(root == null) return 0;
		if(root.children.size() == 0) return 1;
        int ans = 0;
        for(TreeNode<Integer> i : root.children) ans += countLeafNodes(i);
        return ans;
	}
}
