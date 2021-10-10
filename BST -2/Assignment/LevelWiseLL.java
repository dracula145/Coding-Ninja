package Assignment;

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

public class LevelWiseLL {
    public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
		if(root == null) return null;
        Queue<Node_Depth> pendingChildren = new LinkedList<>();
        pendingChildren.add(new Node_Depth(root, 0));
        ArrayList<LinkedListNode<Integer>> ans = new ArrayList<LinkedListNode<Integer>>();
        LinkedListNode<Integer> tail = new LinkedListNode<>(0);
        ans.add(tail);
        
        while(!pendingChildren.isEmpty()){
            Node_Depth obj = pendingChildren.poll();

            if(obj.node.left !=null) pendingChildren.add(new Node_Depth(obj.node.left, obj.depth + 1));
            if(obj.node.right !=null) pendingChildren.add(new Node_Depth(obj.node.right, obj.depth + 1));

            tail.data = obj.node.data;

            // logic to check whether or not to print a new line
            if(!pendingChildren.isEmpty()) {
                LinkedListNode<Integer> newNode = new LinkedListNode<>(0);
                if(pendingChildren.peek().depth != obj.depth) {
                    ans.add(newNode);
                    tail = newNode;
                }
                else {
                    tail.next = newNode;
                    tail = tail.next;
                }
            }
        }
        return ans;
	}
}

class BinaryTreeNode<T> { 
    T data; 
    BinaryTreeNode<T> left; 
    BinaryTreeNode<T> right;
    public BinaryTreeNode(T data) 
    { 
        this.data = data; 
    }
}
class LinkedListNode<T> 
	 { 
	T data; 
	LinkedListNode<T> next;
	public LinkedListNode(T data) 	
	{
		this.data = data; 
	} 
}