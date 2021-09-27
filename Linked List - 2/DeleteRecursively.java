public class DeleteRecursively {
    public static LinkedListNode<Integer> deleteNodeRec(LinkedListNode<Integer> head, int pos) {
        if(head == null && pos>=0) return head;
    	if(pos==0) return head.next;
        head.next = deleteNodeRec(head.next, pos-1);
        return head;
	}
}
