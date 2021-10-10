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
