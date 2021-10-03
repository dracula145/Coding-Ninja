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
