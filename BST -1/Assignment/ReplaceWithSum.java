/*

Given a binary search tree, you have to replace each node's data with the sum of all nodes which are 
greater or equal than it. You need to include the current node's data also.
That is, if in given BST there is a node with data 5, you need to replace it with sum of its data (i.e. 5) 
and all nodes whose data is greater than or equal to 5.
Note: You don't need to return or print, just change the data of each node.

Constraints:
Time Limit: 1 second
Sample Input 1 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output 1 :
18 
36 10 
38 31 
25 

*/

package Assignment;

import javax.management.relation.Relation;

public class ReplaceWithSum {

    static int right_sum = 0;

    public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
		if(root == null) return;

        replaceWithLargerNodesSum(root.right);      // right_sum keeps adding from the right most root.. as its largest
        root.data += right_sum;
        right_sum = root.data;
        replaceWithLargerNodesSum(root.left);

	}
}
