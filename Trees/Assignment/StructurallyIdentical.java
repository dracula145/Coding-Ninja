public class StructurallyIdentical {
    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){
		if( root1 == null && root2 == null) return true;
		if( root1 == null && root2 != null) return false;
		if( root1 != null && root2 == null) return false;

        boolean ans  = true;
        
        if(root1.data != root2.data) return false;
        int min_size = Math.min(root1.children.size(), root2.children.size());
        for(int i = 0;i<min_size;i++) 
        ans = ans & checkIdentical(root1.children.get(i), root2.children.get(i)); // if any one false then all false

        return ans;
        
	}
}
