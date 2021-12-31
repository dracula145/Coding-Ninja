/*

For a given Binary Tree of integers, find and return the sum of all the nodes data.

Constraints:
1 <= N <= 10^6
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
2 3 4 6 -1 -1 -1 -1 -1
Sample Output 1:
 15
Sample Input 2:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 2:
 28

*/

public class SumOfNodes {
    public static int getSum(BinaryTreeNode<Integer> root) {
		if(root == null) return 0;
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        return root.data + leftSum + rightSum;
	}
}
