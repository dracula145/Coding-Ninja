/*

Given a generic tree, print the input tree in level wise order. That is, print the elements at same 
level in one line (separated by space). Print different levels in differnet lines.

Sample Input :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output :
10
20 30 40 
40 50

*/

import java.util.Queue;

import javax.swing.tree.TreeNode;

public class PrintLevelWise {

    private static class Pair{
        TreeNode<Integer> node;
        int depth;
        
        public Pair(TreeNode<Integer> node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }

    public static void printLevelWise(TreeNode<Integer> root){

        Queue<Pair> pending_children = new LinkedList<>();
        pending_children.add(new Pair(root, 0));

        while(!pending_children.isEmpty()){
            Pair front = pending_children.remove();
            System.out.print(front.node.data + " ");
            for(TreeNode<Integer> i : front.node.children) pending_children.add(new Pair(i, front.depth + 1));
            if(!pending_children.isEmpty()) if(front.depth != pending_children.peek().depth) System.out.println();
        }

	}
}
