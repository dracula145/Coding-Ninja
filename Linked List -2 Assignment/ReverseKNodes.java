public class ReverseKNodes{

    public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
		if(head==null || head.next == null || k==0 || k==1) return head;
        LinkedListNode<Integer> dummy_head = new LinkedListNode<>(0), temp = head, curr_head = head, next_head = null, prev_head = dummy_head;
        dummy_head.next = head;
        while(temp!=null){
            int t = k;
            while(t-- > 1 && temp.next !=null) temp = temp.next;
            next_head = temp.next;
            temp.next = null;
            prev_head.next = reverseLinkedListRec(curr_head);
            curr_head.next = next_head;
            temp = next_head;
            prev_head = curr_head;
            curr_head = prev_head.next;
        }
         return dummy_head.next;
	}

    public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {

        // actual nodes are reversed and not the values...
        
		if(head ==null || head.next == null) return head;
        LinkedListNode<Integer> temp = reverseLinkedListRec(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
}