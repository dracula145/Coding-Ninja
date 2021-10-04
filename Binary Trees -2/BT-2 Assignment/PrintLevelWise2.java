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
