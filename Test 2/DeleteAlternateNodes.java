public class DeleteAlternateNodes {
    public static void deleteAlternateNodes(Node<Integer> head) {
        if(head==null) return;
        Node<Integer> temp = head;
        while(temp.next!=null && temp.next.next!=null ){
            temp.next = temp.next.next;
            temp = temp.next;
        }
        temp.next = null;
    }
}
