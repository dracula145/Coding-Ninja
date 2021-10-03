import java.util.*;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class PrintLevelWise {
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
		if(root == null) return;
        
        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<>();
        pendingChildren.add(root);
        
        while(!pendingChildren.isEmpty()){
            BinaryTreeNode<Integer> node = pendingChildren.poll(); // remove() also same thing
            int left, right;
            if(node.left !=null){
                pendingChildren.add(node.left);
                left = node.left.data;
            }
            else left = -1;
            if(node.right !=null){
                pendingChildren.add(node.right);
                right = node.right.data;
            }
            else right = -1;

            System.out.println(node.data + ":L:" + left + ",R:" + right);
        }
	}
}
