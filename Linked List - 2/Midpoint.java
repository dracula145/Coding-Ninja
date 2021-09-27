public class Midpoint {
    public static LinkedListNode<Integer> midPoint(LinkedListNode<Integer> head) {
        if(head == null || head.next == null) return head;
      LinkedListNode<Integer> slow = head, fast = head;
      while(fast.next!=null && fast.next.next !=null){
          slow = slow.next;
          fast = fast.next.next;
      }
      return slow;
  }
}
