public class SecondLargest {

    static TreeNode<Integer> largest, second_largest;

    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
        largest = new TreeNode<>(Integer.MIN_VALUE);
        second_largest = new TreeNode<>(Integer.MIN_VALUE);
        helper(root);
        return (second_largest.data == Integer.MIN_VALUE)? null : second_largest;
	}

    private static void helper(TreeNode<Integer> root){
        if(root == null) return;
        if(root.data > largest.data) {
            second_largest = largest;
            largest = root;
        }
        else if(root.data > second_largest.data && root.data!=largest.data) second_largest = root;
        // root.data!=largest.data .. need to check bcz when 10, 10, 10, 5... then 10 gets stored in
        // second_largest too 5 never really gets a chance to be stored

        for(TreeNode<Integer> i : root.children) helper(i);
    }
}
