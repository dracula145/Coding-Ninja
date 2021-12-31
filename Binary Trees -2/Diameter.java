/*

For a given Binary of type integer, find and return the ‘Diameter’.
Diameter of a Tree

definition : 
The diameter of a tree can be defined as the maximum distance between two leaf nodes.
Here, the distance is measured in terms of the total number of nodes present along the path of the two leaf nodes, including both the leaves.

Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
2 4 5 6 -1 -1 7 20 30 80 90 -1 -1 8 -1 -1 9 -1 -1 -1 -1 -1 -1 
Sample Output 1:
9
Sample Input 2:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
Sample Output 2:
5

*/

import java.lang.*;
public class Diameter {
    
    private class Return2Values{  // for every node we keep its height and diameter wrapped around this single class
        int height;
        int diameter;
        public Return2Values(){
            
        }
        public Return2Values(int height, int diameter){
            this.height = height;
            this.diameter = diameter;
		}
    }

	public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
		Return2Values ans = helper(root);
        return ans.diameter;
	}
	private static Return2Values helper(BinaryTreeNode<Integer> root){
        if(root == null) return new Return2Values(0, 0);
        
        Return2Values leftOutput = helper(root.left);
        Return2Values rightOutput = helper(root.right);
        Return2Values ans = new Return2Values();
        ans.height = 1 + Math.max(leftOutput.height, rightOutput.height);
        ans.diameter = Math.max(1+leftOutput.height+rightOutput.height,       // watch video to know why diameter is so
                    	Math.max(leftOutput.diameter, rightOutput.diameter));
        return ans;
    }
}