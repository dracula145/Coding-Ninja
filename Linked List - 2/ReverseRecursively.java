public class ReverseRecursively {
    public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {

        // actual nodes are reversed and not the values...
        
		if(head ==null || head.next == null) return head;
        LinkedListNode<Integer> temp = reverseLinkedListRec(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
	}
}
