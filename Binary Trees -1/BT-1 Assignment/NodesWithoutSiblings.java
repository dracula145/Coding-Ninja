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
