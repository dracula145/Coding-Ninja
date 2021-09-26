public class AppendLastN {
    public static LinkedListNode<Integer> appendLastNToFirst(LinkedListNode<Integer> head, int n) {
        if(head==null || n==0) return head;
		LinkedListNode<Integer> temp = head, new_head = head, tail = head, new_tail =head;
        int l =0, c=0;
        while(temp!=null){
            l++;
            temp = temp.next;
        }
        temp = head;
        c=l+1;
        while(c-- > 2){
            if(c==n+1){
                new_tail = temp;
                new_head = temp.next;
            }
            if(c==1) tail= temp;
            temp = temp.next;            
        }
        tail = temp;
        tail.next = head;
        new_tail.next = null;
        return new_head;
	}
}
