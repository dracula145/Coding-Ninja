public class SwapNodes {
    public static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int i, int j) {
		if(head==null || head.next == null || i==j) return head;
        LinkedListNode<Integer> dummy_head = new LinkedListNode<>(1), h1=dummy_head, 
        h2=null, t1=dummy_head, t2=null, temp=null;
        dummy_head.next = head;
        int f = (j-i == 1)? 0 : 1 ;
        if(j<i){
            int t = i;
            i=j;
            j=t;
        }
        i++;j++;
        while(i-- > 1) h1 = h1.next;
        h2 = h1.next;
        while(j-- > 1) t1 = t1.next;
        t2 = t1.next;
        
        // swapping
        if(f == 1){
        h1.next = t2;
        temp = t2.next;
        t2.next = h2.next;
        t1.next = h2;
        h2.next = temp;
        }
        else {		// to handle those cases where nodes are adjacent
            h1.next = t2;
            h2.next = t2.next;
            t2.next = h2;
        }
        
        return dummy_head.next;
	}
}
