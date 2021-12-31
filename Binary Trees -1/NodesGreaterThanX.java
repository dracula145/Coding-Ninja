/*

For a given a binary tree of integers and an integer X, find and return the total 
number of nodes of the given binary tree which are having data greater than X.

Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
1 4 2 3 -1 -1 -1
2
Sample Output 1:
2
Explanation for Sample Input 1:
Out of the four nodes of the given binary tree, [3, 4] are the node data that are greater than X = 2.
Sample Input 2:
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
5
Sample Output 2:
3

*/

public class NodesGreaterThanX {
    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
		if(root==null) return 0;
        int left = countNodesGreaterThanX(root.left, x);
        int right = countNodesGreaterThanX(root.right, x);
        if(root.data > x) return 1 + left + right;
        return 0 + left + right;
	}
}
