/*

For a given Binary Tree of integers, print the post-order traversal.

Constraints:
1 <= N <= 10^6
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
 Sample Output 1:
4 5 2 6 7 3 1 
Sample Input 2:
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
 Sample Output 1:
2 9 3 6 10 5 

*/

public class PostOrderTraversal {
    public static void postOrder(BinaryTreeNode<Integer> root) {
		if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
	}
}
