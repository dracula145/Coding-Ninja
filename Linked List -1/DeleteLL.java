public class DeleteLL {
    public static LinkedListNode<Integer> deleteNode(LinkedListNode<Integer> head, int pos) {
		if(head == null) return head;
        LinkedListNode<Integer> temp = head;
        if(pos == 0) return head.next;
        while(pos-- > 1 && temp!=null) temp = temp.next;
        if(temp!=null && temp.next != null) temp.next = temp.next.next;
        return head;
	}
}
