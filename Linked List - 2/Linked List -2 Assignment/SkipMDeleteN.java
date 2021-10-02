public class SkipMDeleteN {
    public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {
        if(M==0) return null;
		LinkedListNode<Integer> temp = head, temp2 = null;
        while(temp!=null){
            int m=M, n=N;
            while(m-- > 1 && temp!=null) temp = temp.next;
            temp2 = temp;
            while(n-- > 0 && temp2!=null) temp2 = temp2.next;
                if(temp2!=null){
                    temp.next = temp2.next;
                    temp = temp.next;
                }
            else if(temp!=null) {  // important... ow it throws NPE 
                temp.next = temp2;
                break;
            }
        }
        return head;
	}
}
