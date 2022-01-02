/*

Given a BST and an integer k. Find and return the path from the node with data k and root (if a 
node with data k is present in given BST) in a list. Return empty list otherwise.
Note: Assume that BST contains all unique elements.

Constraints:
Time Limit: 1 second   
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2
Sample Output 1:
2 5 8

*/

public class GetPathBST {
    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){
		if(root == null) return null;
        if(root.data == data){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(data);
            return list;
        }
        if(root.data > data){
            ArrayList<Integer> leftOutput = getPath(root.left, data);
            if(leftOutput !=null){
                leftOutput.add(root.data);
                return leftOutput;
            }
        	else return null;
        }
        ArrayList<Integer> rightOutput = getPath(root.right, data);
        if(rightOutput != null){
            rightOutput.add(root.data);
                return rightOutput;
        }
         return null;
	}
}
