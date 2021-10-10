public class NumberOfLeaf {
    public static int countLeafNodes(TreeNode<Integer> root){
        if(root == null) return 0;
		if(root.children.size() == 0) return 1;
        int ans = 0;
        for(TreeNode<Integer> i : root.children) ans += countLeafNodes(i);
        return ans;
	}
}
