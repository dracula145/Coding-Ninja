public class MaxSum {

    private static class Pair{
        TreeNode<Integer> node;
        int sum;
        public Pair(TreeNode<Integer> node, int sum){
            this.node = node;
            this.sum = sum;
        }
    }

    static Pair res = new Pair(null, 0);

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
		helper(root);
        return res.node;
	}

    private static void helper(TreeNode<Integer> root){
        if(root == null) return;
        updateRes(root);
        for(TreeNode<Integer> i : root.children) helper(i);
    }
    private static void updateRes(TreeNode<Integer> root){
        int temp = root.data;
        for(TreeNode<Integer> i : root.children) temp += i.data;
        if (temp > res.sum) res = new Pair(root, temp);
    }
}
