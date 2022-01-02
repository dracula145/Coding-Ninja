/*

Given a binary search tree and data of two nodes, find 'LCA' (Lowest Common Ancestor) of the given two nodes in the BST.
LCA
LCA of two nodes A and B is the lowest or deepest node which has both A and B as its descendants. 

Note:
It is defined that each node is a descendant to itself, so, if there are two nodes X and Y and X has a direct connection 
from Y, then Y is the lowest common ancestor.

Note:
1. If out of 2 nodes only one node is present, return that node. 
2. If both are not present, return -1.
3. all the node data will be unique.

Constraints:
Time Limit: 1 second
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2 10
Sample Output 1:
8
Sample Input 2:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2 6
Sample Output 2:
5
Sample Input 3:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12 78
Sample Output 3:
-1

*/

package Assignment;

public class LCAofBST {

    public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
        boolean aPresent = isNodePresent(root, a), bPresent = isNodePresent(root, b);

        if(!aPresent && !bPresent) return -1;
        if(!aPresent && bPresent) return b;
        if(aPresent && !bPresent) return a;

        return helper(root, a, b);      // if both nodes present then only call helper

	}
    private static boolean isNodePresent(BinaryTreeNode<Integer> root, int a){      //checks if a node value is present
        if(root == null) return false;
        if(root.data == a) return true;
        return isNodePresent(root.left, a) || isNodePresent(root.right, a);
    }

    private static int helper(BinaryTreeNode<Integer> root, int a, int b){
        if(root == null) return -1;
        if(root.data >= a && root.data <= b) return root.data;      // once left <= root <= right.. that's our value
        if(root.data > a && root.data > b) return helper(root.left, a, b);
        return helper(root.right, a, b);
    }
}
