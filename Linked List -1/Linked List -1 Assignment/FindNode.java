public class FindNode {
    public static int findNode(LinkedListNode<Integer> head, int n) {
        int count =0;
		while(head!=null){
            if(head.data == n) return count;
        	head = head.next;
            count++;
        }
        return -1;
	}
}
