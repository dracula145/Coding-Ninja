/*

For a given preorder and inorder traversal of a Binary Tree of type integer stored in an array/list, 
create the binary tree using the given two arrays/lists. You just need to construct the tree and return the root.
Note:
Assume that the Binary Tree contains only unique elements. 

Constraints:
1 <= N <= 10^4
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
7
1 2 4 5 3 6 7 
4 2 5 1 6 3 7 
Sample Output 1:
1 
2 3 
4 5 6 7 
Sample Input 2:
6
5 6 2 3 9 10 
2 6 3 9 5 10 
Sample Output 2:
5 
6 10 
2 3 
9 

*/

public class BuildInorderPreorder {
    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
        int l = inOrder.length;
        if(l==0) return null;
        int root = preOrder[0], root_in = 0;

        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(root);

        while(inOrder[root_in] != root) root_in ++;
		
        int left_in[] = new int[root_in];
        int right_in[] = new int[l-root_in-1];
        int left_pre[] = new int[root_in];
        int right_pre[] = new int[l-root_in-1];

        for(int i=0;i<root_in;i++){
            left_in[i] = inOrder[i];
            left_pre[i] = preOrder[i+1];
        }
        for(int i=0;i<l-root_in-1;i++){
            right_in[i] = inOrder[root_in+i+1];
            right_pre[i] = preOrder[root_in+i+1];
        }

        newNode.left = buildTree(left_pre, left_in); // can be done using indices .. no need to copy array
        newNode.right = buildTree(right_pre, right_in);

        return newNode;
	}
}
