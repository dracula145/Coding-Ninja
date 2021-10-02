public class HeightOfTree {
    public static int height(BinaryTreeNode<Integer> root) {
		if(root == null) return 0;
        int left_height = height(root.left);
        int right_height = height(root.right);
        return 1 + ((left_height > right_height)? left_height : right_height);
	}
}
