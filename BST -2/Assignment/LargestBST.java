/*

Given a Binary tree, find the largest BST subtree. That is, you need to find the BST with maximum height 
in the given binary tree. You have to return the height of largest BST.

Constraints:
Time Limit: 1 second
Sample Input 1:
5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1:
2

*/

package Assignment;

public class LargestBST {

    // we're return min, max, isBST below, and height upto everynode with every nodes
    private static class Set{
        int height;
        int min, max;
        boolean isBST;
        public Set(int min, int max, boolean isBST, int height){
            this.min = min;
            this.max = max;
            this.isBST = isBST;
            this.height = height;
        }
    }

    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
            return helper(root).height;  
	}

    private static Set helper(BinaryTreeNode<Integer> root){
        
        if(root == null) return new Set(Integer.MAX_VALUE, Integer.MIN_VALUE, true, 0);

        Set leftOutput = helper(root.left);
        Set rightOutput = helper(root.right);

        if (!(leftOutput.isBST && rightOutput.isBST)) 
        return new Set(0, 0, false, Math.max(leftOutput.height, rightOutput.height));

        if(root.data > leftOutput.max && root.data < rightOutput.min)
        return new Set( Math.min(root.data, Math.min(leftOutput.min, rightOutput.min)),
                        Math.max(root.data, Math.max(leftOutput.max, rightOutput.max)),
                        true,
                        Math.max(leftOutput.height, rightOutput.height)+1);

        return new Set( Math.min(leftOutput.min, rightOutput.min),
                        Math.max(leftOutput.max, rightOutput.max),
                        false,
                        Math.max(leftOutput.height, rightOutput.height));
        

    }
}
