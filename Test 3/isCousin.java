/*

Given the binary Tree and two nodes say ‘p’ and ‘q’. Determine whether the two nodes are cousins of e
ach other or not. Two nodes are said to be cousins of each other if they are at same level of the Binary Tree and have different parents.
Do it in O(n).

Constraints :
1 <= N <= 10^5
Sample Input :
5 6 10 2 3 4 -1 -1 -1 -1 9 -1 -1 -1 -1
2
4
Sample Output :
true

*/

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
