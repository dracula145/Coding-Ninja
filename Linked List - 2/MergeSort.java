/*

 Given a singly linked list of integers, sort it using 'Merge Sort.'

 Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.

Time Limit: 1sec
Sample Input 1 :
1
10 9 8 7 6 5 4 3 -1
Sample Output 1 :
 3 4 5 6 7 8 9 10 
 Sample Output 2 :
2
-1
10 -5 9 90 5 67 1 89 -1
Sample Output 2 :
-5 1 5 9 10 67 89 90 

*/

public class MergeSort {
    public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
		if (head == null || head.next==null) return head;
        LinkedListNode <Integer> slow = head, fast = head, temp =null, l1=null, l2=null;
        
        while(fast.next!=null && fast.next.next !=null){
          slow = slow.next;
          fast = fast.next.next;
         }
        temp = slow.next;
        slow.next = null;
        l1 = mergeSort(head);
        l2 = mergeSort(temp);
        return mergeTwoSortedLinkedLists(l1, l2);
	}
    
    //merging
    public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        if(head1==null) return head2;
        if(head2==null) return head1;
        LinkedListNode<Integer> head = null, tail = null;
        if(head1.data < head2.data){
            head = head1;
            tail = head1;
            head1 = head1.next;
        }
        else {
            head = head2;
            tail = head2;
            head2 = head2.next;
        }
        while(head1!=null && head2!=null){
            if(head1.data < head2.data){
       	    	tail.next = head1;
                tail = tail.next;
                head1 = head1.next;
       		 }
            else{
                tail.next = head2;
                tail = tail.next;
                head2 = head2.next;
            }
        }
        if(head1==null) tail.next = head2;
        else tail.next = head1;
        return head;
    }
}
