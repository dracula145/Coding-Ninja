public class MergeSort {
    public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
		if (head == null || head.next==null) return head;
        LinkedListNode <Integer> slow = head, fast = head, temp =null, l1=null, l2=null;
        
        while(fast.next!=null && fast.next.next !=null){
          slow = slow.next;
          fast = fast.next.next;
         }
        temp = slow.next;
        slow.next = null;
        l1 = mergeSort(head);
        l2 = mergeSort(temp);
        return mergeTwoSortedLinkedLists(l1, l2);
	}
    
    //merging
    public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        if(head1==null) return head2;
        if(head2==null) return head1;
        LinkedListNode<Integer> head = null, tail = null;
        if(head1.data < head2.data){
            head = head1;
            tail = head1;
            head1 = head1.next;
        }
        else {
            head = head2;
            tail = head2;
            head2 = head2.next;
        }
        while(head1!=null && head2!=null){
            if(head1.data < head2.data){
       	    	tail.next = head1;
                tail = tail.next;
                head1 = head1.next;
       		 }
            else{
                tail.next = head2;
                tail = tail.next;
                head2 = head2.next;
            }
        }
        if(head1==null) tail.next = head2;
        else tail.next = head1;
        return head;
    }
}
