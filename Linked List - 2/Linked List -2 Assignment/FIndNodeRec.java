public class FIndNodeRec {
    static int c =0;
    
	public static int findNodeRec(LinkedListNode<Integer> head, int n) {
        if(head == null) return -1;
    	if(head.data == n) return c;
        c++;
        return findNodeRec(head.next, n);
	}
}
