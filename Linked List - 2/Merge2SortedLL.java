/*

You have been given two sorted(in ascending order) singly linked lists of integers.
Write a function to merge them in such a way that the resulting singly 
linked list is also sorted(in ascending order) and return the new head to the list.

Note :
Try solving this in O(1) auxiliary space.

Constraints :
1 <= t = 10^2
0 <= N <= 10 ^ 4
0 <= M <= 10 ^ 4
Where N and M denote the sizes of the singly linked lists. 

Time Limit: 1sec
Sample Input 1 :
1
2 5 8 12 -1
3 6 9 -1
Sample Output 1 :
2 3 5 6 8 9 12 
Sample Input 2 :
2
2 5 8 12 -1
3 6 9 -1
10 40 60 60 80 -1
10 20 30 40 50 60 90 100 -1
Sample Output 2 :
2 3 5 6 8 9 12 
10 10 20 30 40 40 50 60 60 60 80 90 100

*/

public class Merge2SortedLL {
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
