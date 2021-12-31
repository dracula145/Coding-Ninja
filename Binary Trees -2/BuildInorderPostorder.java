/*

For a given postorder and inorder traversal of a Binary Tree of type integer stored in an array/list, 
create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.
Note:
Assume that the Binary Tree contains only unique elements. 

Constraints:
1 <= N <= 10^4
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
7
4 5 2 6 7 3 1 
4 2 5 1 6 3 7 
Sample Output 1:
1 
2 3 
4 5 6 7 
Sample Input 2:
6
2 9 3 6 10 5 
2 6 3 9 5 10 
Sample Output 2:
5 
6 10 
2 3 
9 

*/

public class BuildInorderPostorder {
    public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
		return helper(postOrder, inOrder, 0, postOrder.length-1, 0, inOrder.length-1);
	}

    private static BinaryTreeNode<Integer> helper(int[] postOrder, int[] inOrder,
     int si_post, int ei_post, int si_in, int ei_in){
    
        if(si_in>ei_in || si_post>ei_post) return null;
    
        int root = postOrder[ei_post], root_in = 0;

        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(root);

        //while(inOrder[root_in] != root) root_in ++;     // gets to the root in inorder

        for(int i=si_in;i<=ei_in;i++) if(inOrder[i] == root) root_in = i;

        int si_in_left = si_in,
        ei_in_left = root_in -1,            // in-order
        si_in_right = root_in +1,
        ei_in_right = ei_in,
        
        si_post_left = si_post,
        ei_post_left = si_post_left + root_in-si_in_left -1,      // post order
        si_post_right = ei_post_left +1,
        ei_post_right = ei_post -1;

        newNode.left = helper(postOrder, inOrder, si_post_left, ei_post_left, si_in_left, ei_in_left);
        newNode.right = helper(postOrder, inOrder, si_post_right, ei_post_right, si_in_right, ei_in_right);

        return newNode;
     }
}
