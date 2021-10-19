class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}
public class isCousin {

    static int parent_p, depth_p, parent_q, depth_q;
    public static boolean is_cousin(BinaryTreeNode<Integer> root, int p, int q) {
        
		storeParentDataOfPandQ(root.left, root, p, q, 1);
		storeParentDataOfPandQ(root.right, root, p, q, 1);

        if(depth_p == depth_q && parent_p!=parent_q) return true;
        return false;
	}
    private static void storeParentDataOfPandQ(BinaryTreeNode<Integer> node, BinaryTreeNode<Integer> parent,int p, int q, int k){
        if(node == null) return;
        if(node.data == p){ parent_p = parent.data; depth_p = k; }
        if(node.data == q){ parent_q = parent.data; depth_q = k; }

        storeParentDataOfPandQ(node.left, node, p, q, k+1);
        storeParentDataOfPandQ(node.right, node, p, q, k+1);
        
    }
}
