public class Duplicate {
    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
		if(root == null) return;
        BinaryTreeNode<Integer> duplicate = new BinaryTreeNode<>(root.data);
        duplicate.left = root.left;
        root.left = duplicate;
        insertDuplicateNode(root.left.left);
        insertDuplicateNode(root.right);
	}
}
