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
