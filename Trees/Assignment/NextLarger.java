public class NextLarger {

    static TreeNode<Integer> res;

    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
        res = new TreeNode<>(Integer.MAX_VALUE);
		helper(root, n);
        return (res.data == Integer.MAX_VALUE)? null : res;
    }

    private static void helper(TreeNode<Integer> root, int n){
        if(root == null) return;
        if(root.data > n && root.data < res.data) res = root;
        for(TreeNode<Integer> i : root.children) helper(i, n);
    }
}
