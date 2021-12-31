/*

You are given the root node of a binary tree.Print its preorder traversal.

Constraints:
1 <= N <= 10^6
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
 Sample Output 1:
1 2 4 5 3 6 7
Sample Input 2:
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
 Sample Output 1:
5 6 2 3 9 10

*/

public class PreOrderTraversal {
    public static void preOrder(BinaryTreeNode<Integer> root) {
		if(root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
	}
}
