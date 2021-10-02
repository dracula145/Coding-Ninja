public class BubbleSort {
    public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> i = head, j = null;
        while(i !=null){
            j = head;
            while(j.next !=null){
                if(j.data > j.next.data) swap(j, j.next);
                j = j.next;
            }
            i = i.next;
        }
        return head;
	}
    public static void swap(LinkedListNode<Integer> a, LinkedListNode<Integer> b){
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }
}
