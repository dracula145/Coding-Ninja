public class ReplaceWithDepth {

    public static void replaceWithDepthValue(TreeNode<Integer> root){
        helper(root, 0);
	}
    private static void helper(TreeNode<Integer> root, int k){
        if(root == null) return;
        root.data = k;

        for(TreeNode<Integer> i : root.children) helper(i, k+1);
    }
}
