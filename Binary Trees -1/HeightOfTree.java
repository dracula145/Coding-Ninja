/*

For a given Binary Tree of integers, find and return the height of the tree.
Height is defined as the total number of nodes along the longest path from the root to any of the leaf node.

Constraints:
0 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
10 20 30 40 50 -1 -1 -1 -1 -1 -1
Sample Output 1:
3
Sample Input 2:
3 -1 -1
Sample Output 2:
1

*/

public class HeightOfTree {
    public static int height(BinaryTreeNode<Integer> root) {
		if(root == null) return 0;
        int left_height = height(root.left);
        int right_height = height(root.right);
        return 1 + ((left_height > right_height)? left_height : right_height);
	}
}
