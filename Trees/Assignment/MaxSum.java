/*

Given a tree, find and return the node for which sum of data of all children and the node itself is maximum. In the sum, data of node itself and data of immediate children is to be taken.
Input format :

Line 1 : Elements in level order form separated by space (as per done in class). Order is -

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element

Output format : Node with maximum sum.

Sample Input 1 :
5 3 1 2 3 1 15 2 4 5 1 6 0 0 0 0
Sample Output 1 :
1

*/

public class MaxSum {

    private static class Pair{
        TreeNode<Integer> node;
        int sum;
        public Pair(TreeNode<Integer> node, int sum){
            this.node = node;
            this.sum = sum;
        }
    }

    static Pair res = new Pair(null, 0);

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
		helper(root);
        return res.node;
	}

    private static void helper(TreeNode<Integer> root){
        if(root == null) return;
        updateRes(root);
        for(TreeNode<Integer> i : root.children) helper(i);
    }
    private static void updateRes(TreeNode<Integer> root){
        int temp = root.data;
        for(TreeNode<Integer> i : root.children) temp += i.data;
        if (temp > res.sum) res = new Pair(root, temp);
    }
}
