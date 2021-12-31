/*

For a given a Binary Tree of type integer, duplicate every node of the tree and attach it to the left of itself.
The root will remain the same. So you just need to insert nodes in the given Binary Tree.

Constraints :
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
10 20 30 40 50 -1 60 -1 -1 -1 -1 -1 -1
Sample Output 1:
10 
10 30 
20 30 60 
20 50 60 
40 50 
40 
Sample Input 2:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output 2:
8 
8 10 
5 10 
5 6 
2 6 7 
2 7

*/

class BinaryTreeNode<T> {
  T data;
  BinaryTreeNode<T> left;
  BinaryTreeNode<T> right;

  public BinaryTreeNode(T data) {
      this.data = data;
      this.left = null;
      this.right = null;
  }
}
public class Duplicate {
    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
		if(root == null) return;
        BinaryTreeNode<Integer> duplicate = new BinaryTreeNode<>(root.data);
        duplicate.left = root.left;
        root.left = duplicate;
        insertDuplicateNode(root.left.left);
        insertDuplicateNode(root.right);
	}
}
