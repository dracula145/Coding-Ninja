package Assignment;

public class LCAofBST {

    public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
        boolean aPresent = isNodePresent(root, a), bPresent = isNodePresent(root, b);

        if(!aPresent && !bPresent) return -1;
        if(!aPresent && bPresent) return b;
        if(aPresent && !bPresent) return a;

        return helper(root, a, b);      // if both nodes present then only call helper

	}
    private static boolean isNodePresent(BinaryTreeNode<Integer> root, int a){      //checks if a node value is present
        if(root == null) return false;
        if(root.data == a) return true;
        return isNodePresent(root.left, a) || isNodePresent(root.right, a);
    }

    private static int helper(BinaryTreeNode<Integer> root, int a, int b){
        if(root == null) return -1;
        if(root.data >= a && root.data <= b) return root.data;      // once left <= root <= right.. that's our value
        if(root.data > a && root.data > b) return helper(root.left, a, b);
        return helper(root.right, a, b);
    }
}
