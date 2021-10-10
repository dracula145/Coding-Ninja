public class SumNodes {
    public static int sumOfAllNode(TreeNode<Integer> root){
		if(root == null) return 0;
        int child_sum = root.data;
        for(TreeNode<Integer> i : root.children) child_sum += sumOfAllNode(i);
        
        return child_sum;
	}
}
