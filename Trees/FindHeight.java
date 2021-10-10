public class FindHeight {
    public static int getHeight(TreeNode<Integer> root){
		if(root == null) return 0;
        int height = 0;
        for(TreeNode<Integer> i : root.children) height = Math.max(height, getHeight(i));
        return height+1;
	}
}
