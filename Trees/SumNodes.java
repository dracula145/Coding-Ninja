/*

Given a generic tree, count and return the sum of all nodes present in the given tree.
Input format :
Elements in level order form separated by space (as per done in class). Order is - 
Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output Format :
Sum of all nodes
Sample Input :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output :
190

*/

public class SumNodes {
    public static int sumOfAllNode(TreeNode<Integer> root){
		if(root == null) return 0;
        int child_sum = root.data;
        for(TreeNode<Integer> i : root.children) child_sum += sumOfAllNode(i);
        
        return child_sum;
	}
}
