public class EvenAfterOdd{

    public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {
		if(head == null || head.next == null) return head;
        LinkedListNode<Integer> odd_head = null, odd_tail = null, even_head = null, even_tail = null;
        while(head != null){
        if(head.data %2 !=0){
            if(odd_head == null){
                odd_head = head;
                odd_tail = head;
            }
            else{
                odd_tail.next = head;
                odd_tail = odd_tail.next;
            }
        }
        else{
            if(even_head == null){
                even_head = head;
                even_tail = head;
            }
            else{
                even_tail.next = head;
                even_tail = even_tail.next;
            }
        }
            head = head.next;
      }
        if(odd_head == null) return even_head;
        else odd_tail.next = even_head;
        if(even_head!=null) even_tail.next = null; //this case needs to be handled ow TLE.. some nodes may be there after even_tail
        return odd_head;
	}
}
