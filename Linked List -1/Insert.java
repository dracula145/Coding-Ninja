public class Insert {
    public static LinkedListNode<Integer> insert(LinkedListNode<Integer> head, int pos, int data){
		LinkedListNode<Integer> newNode = new LinkedListNode<>(data), temp = head;
        if(pos ==0){
        	newNode.next = head;
            head = newNode;
            return head;
        }
        while(pos-- >1 && temp!=null) temp = temp.next;
        if(temp!=null){
            newNode.next = temp.next;
            temp.next = newNode;
        }
        return head;
	}
}
