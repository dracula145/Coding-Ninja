/*

For a given a Binary Tree of type integer, print it in a level order fashion where each level will be 
printed on a new line. Elements on every level will be printed in a linear fashion and a single space 
will separate them.

Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
10 20 30 40 50 -1 60 -1 -1 -1 -1 -1 -1 
Sample Output 1:
10 
20 30 
40 50 60 
Sample Input 2:
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
Sample Output 2:
8 
3 10 
1 6 14 
4 7 13 

*/

import java.util.*;

// this class wraps the node and its depth into a single object
class Node_Depth{
    BinaryTreeNode<Integer> node;
    int depth;
    public Node_Depth(BinaryTreeNode<Integer> node, int depth){
        this.node = node;
        this.depth = depth;
    }
}

public class PrintLevelWise2 {
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
		if(root == null) return;
        Queue<Node_Depth> pendingChildren = new LinkedList<>();
        pendingChildren.add(new Node_Depth(root, 0));
        
        while(!pendingChildren.isEmpty()){
            Node_Depth obj = pendingChildren.poll();

            if(obj.node.left !=null) pendingChildren.add(new Node_Depth(obj.node.left, obj.depth + 1));
            if(obj.node.right !=null) pendingChildren.add(new Node_Depth(obj.node.right, obj.depth + 1));

            System.out.print(obj.node.data + " ");

            // logic to check whether or not to print a new line
            if(!pendingChildren.isEmpty()) {
                if(pendingChildren.peek().depth != obj.depth) System.out.println();
            }
        }
	}
}
