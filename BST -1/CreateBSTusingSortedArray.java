/*

Given a sorted integer array A of size n, which contains all unique elements. You need to construct a 
balanced BST from this input array. Return the root of constructed BST.
Note: If array size is even, take first mid as root.

Constraints:
Time Limit: 1 second
Sample Input 1:
7
1 2 3 4 5 6 7
Sample Output 1:
4 2 1 3 6 5 7 

*/

public class CreateBSTusingSortedArray {
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
			return helper(arr, 0, arr.length-1);
    }
    private static BinaryTreeNode<Integer> helper(int[] arr, int si, int ei){
        if(si>ei) return null;
        int root_index = (si+ei)/2;
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(arr[root_index]);
        newNode.left = helper(arr, si, root_index-1);
        newNode.right = helper(arr, root_index+1, ei);
        return newNode;
    }
}
