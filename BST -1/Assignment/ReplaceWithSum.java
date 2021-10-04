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
