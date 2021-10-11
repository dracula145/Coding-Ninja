import jdk.javadoc.internal.doclets.formats.html.resources.standard;

public class CountLeaf {
    static int res = 0;
    public static int countLeafNodes(TreeNode<Integer> root){
        helper(root);
        return res;
	}
    private static void helper(TreeNode<Integer> root){
        if(root == null) return;
        if(root.children.size() == 0) res++;

        for(TreeNode<Integer> i : root.children) countLeafNodes(i);
    }
}
