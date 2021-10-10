import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;
import javax.swing.tree.TreeNode;

public class PostOrder {
    public static void printPostOrder(TreeNode<Integer> root){
		TreeNode<Integer> dummy_root = new TreeNode<>(0);
        dummy_root.children.add(root);
        printHelper(dummy_root);
	}
    private static void printHelper(TreeNode<Integer> root){
        if(root == null) return;
        for(TreeNode<Integer> i : root.children){
            printHelper(i);
            System.out.print(i.data + " ");
        }
    }
}
