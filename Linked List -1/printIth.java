public class printIth {
    public static void printIthNode(LinkedListNode<Integer> head, int i){
        LinkedListNode<Integer> temp = head;
        if(temp==null) return;
		while(i-- > 0 && temp!=null)  temp = temp.next;
        if(temp!=null) System.out.println(temp.data);
	}
}
