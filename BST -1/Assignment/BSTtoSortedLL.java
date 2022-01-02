/*

Given a BST, convert it into a sorted linked list. You have to return the head of LL.

Constraints:
Time Limit: 1 second
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output 1:
2 5 6 7 8 10
*/

package Assignment;

class BinaryTreeNode<T> {
    T data; 
    BinaryTreeNode<T> left;
    BinaryTreeNode<T>right;
public BinaryTreeNode(T data) {
     this.data = data;
   }
}

class LinkedListNode<T> { T data; LinkedListNode<T> next;
    public LinkedListNode(T data) { this.data = data; } }

public class BSTtoSortedLL {

    private static class Pair{
        LinkedListNode<Integer> head;
        LinkedListNode<Integer> tail;

         public Pair(LinkedListNode<Integer>head, LinkedListNode<Integer> tail){
             this.head = head;
             this.tail = tail;
         }
    }

    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
		return helper(root).head;
	}
    
    private static Pair helper(BinaryTreeNode<Integer> root){
        if(root == null) return new Pair(null, null);
        LinkedListNode<Integer> newNode = new LinkedListNode<>(root.data);
        Pair ans = new Pair(newNode, newNode);
        Pair leftOutput = helper(root.left);
        Pair rightOutput = helper(root.right);
        
        if(leftOutput.head != null){
            
            leftOutput.tail.next = newNode;
            leftOutput.tail = leftOutput.tail.next;
            leftOutput.tail.next = rightOutput.head;
            if(rightOutput.tail != null) leftOutput.tail = rightOutput.tail;        // in-order type
            return leftOutput;
        }
        
        ans.tail.next = rightOutput.head;
        if(rightOutput.tail != null) ans.tail = rightOutput.tail;
        return ans;
    }
}
