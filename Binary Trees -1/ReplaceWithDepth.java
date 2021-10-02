public class ReplaceWithDepth {
    public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
	    helper(root, 0);
	}
    
    private static void helper(BinaryTreeNode<Integer> root, int k){
        if(root == null) return;
        root.data = k;
        helper(root.left, k+1);
        helper(root.right, k+1);
    }
}
