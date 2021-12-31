/*

For a given Binary Tree of type integer and a number K, print out all root-to-leaf paths where 
the sum of all the node data along the path is equal to K.

Constriants:
1 <= N <= 10^5
0 <= K <= 10^8
Where N is the total number of nodes in the binary tree.

Time Limit: 1 second
Sample Input 1:
2 3 9 4 8 -1 2 4 -1 -1 -1 6 -1 -1 -1 -1 -1
13
 Sample Output 1:
2 3 4 4 
2 3 8
Sample Input 2:
5 6 7 2 3 -1 1 -1 -1 -1 9 -1 -1 -1 -1
13
 Sample Output 2:
5 6 2
5 7 1

*/

public class PathSum {
    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
		helper(root, k, "");
	}

    private static void helper(BinaryTreeNode<Integer> root, int k, String s){
        if(root == null) return;

        s += String.valueOf(root.data) + " ";
        
        if(root.left == null && root.right == null && k==root.data) System.out.println(s);
        
        helper(root.left, k-root.data, s);
        helper(root.right, k-root.data, s);
    }
}
