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
