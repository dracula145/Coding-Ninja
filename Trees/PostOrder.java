/*

Given a generic tree, print the post-order traversal of given tree.
The post-order traversal is: visit child nodes first and then root node.

Constraints:
Time Limit: 1 sec
Sample Input 1:
10 3 20 30 40 2 400 50 0 0 0 0 
Sample Output 1:
400 50 20 30 40 10

*/

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
