/*

For a given Binary Tree of type integer, print all the nodes without any siblings.

Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 second
Sample Input 1:
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1:
9    
Sample Input 2:
2 4 5 6 -1 -1 7 20 30 80 90 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 2:
6 7  
Explanation of Sample Input 2:
The input tree when represented in a two-dimensional plane, it would look like this:     
alt txt

In respect to the root, node data in the left subtree that satisfy the condition of not having a sibling would be 6, taken in a top-down sequence. Similarly, for the right subtree, 7 is the node data without any sibling.

Since we print the siblings in the left-subtree first and then the siblings from the right subtree, taken in a top-down fashion, we print 6 7.

*/

public class NodesWithoutSiblings {
    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
		if(root == null) return;
        helper(root.left, root);
        helper(root.right, root);
	}
	
    private static void helper(BinaryTreeNode<Integer> node, BinaryTreeNode<Integer> parent){
        if(node == null) return;
        if(parent.left == null || parent.right == null) System.out.print(node.data + " ");
        helper(node.left, node);
        helper(node.right, node);
    }
}
