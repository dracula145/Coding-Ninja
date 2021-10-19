public class RemoveLeafGeneric {

    public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) {
		if(root == null) return null;
        if(root.children.size() == 0) return null;
        
        for(int i = 0 ; i< root.children.size(); i++){
            TreeNode<Integer>  temp = removeLeafNodes(root.children.get(i));
            if(temp == null){
                root.children.remove(i);
                i--;    // because the count of children has decreased.. the next child is now at i
            } 
            else root.children.set(i, temp);
        } 

        return root;
	}
}
