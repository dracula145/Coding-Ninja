public class NodesGreaterThanX {
    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
		if(root==null) return 0;
        int left = countNodesGreaterThanX(root.left, x);
        int right = countNodesGreaterThanX(root.right, x);
        if(root.data > x) return 1 + left + right;
        return 0 + left + right;
	}
}
