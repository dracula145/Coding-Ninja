/*

Remove all leaf nodes from a given generic Tree. Leaf nodes are those nodes, which don't have any children.
Note : Root will also be a leaf node if it doesn't have any child. You don't need to print the tree, just 
remove all leaf nodes and return the updated root.

Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 : (Level wise, each level in new line)
10
20

*/

public class RemoveLeafGeneric {

    public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) {
		if(root == null) return null;
        if(root.children.size() == 0) return null;
        
        for(int i = 0 ; i< root.children.size(); i++){
            TreeNode<Integer>  temp = removeLeafNodes(root.children.get(i));
            if(temp == null){
                root.children.remove(i);
                i--;    // because the count of children has decreased.. the next child is now at i
            } 
            else root.children.set(i, temp);
        } 

        return root;
	}
}
