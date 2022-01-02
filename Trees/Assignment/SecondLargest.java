/*

Given a generic tree, find and return the node with second largest value in given tree. Return NULL if no node with required value is present.
Input format :
Elements in level order form separated by space (as per done in class). Order is - 

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output format:
Second Largest node data
Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
40

*/

public class SecondLargest {

    static TreeNode<Integer> largest, second_largest;

    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
        largest = new TreeNode<>(Integer.MIN_VALUE);
        second_largest = new TreeNode<>(Integer.MIN_VALUE);
        helper(root);
        return (second_largest.data == Integer.MIN_VALUE)? null : second_largest;
	}

    private static void helper(TreeNode<Integer> root){
        if(root == null) return;
        if(root.data > largest.data) {
            second_largest = largest;
            largest = root;
        }
        else if(root.data > second_largest.data && root.data!=largest.data) second_largest = root;
        // root.data!=largest.data .. need to check bcz when 10, 10, 10, 5... then 10 gets stored in
        // second_largest too 5 never really gets a chance to be stored

        for(TreeNode<Integer> i : root.children) helper(i);
    }
}
