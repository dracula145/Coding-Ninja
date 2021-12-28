/*

Given a singly linked list of integers, reverse the nodes of 
the linked list 'k' at a time and return its modified list.
 'k' is a positive integer and is less than or equal to the 
 length of the linked list. If the number of nodes is not a 
 multiple of 'k,' then left-out nodes, in the end, should be reversed as well.

Example :
Given this linked list: 1 -> 2 -> 3 -> 4 -> 5

For k = 2, you should return: 2 -> 1 -> 4 -> 3 -> 5

For k = 3, you should return: 3 -> 2 -> 1 -> 5 -> 4


Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.
0 <= k <= M

Time Limit:  1sec
Sample Input 1 :
1
1 2 3 4 5 6 7 8 9 10 -1
4
Sample Output 1 :
4 3 2 1 8 7 6 5 10 9
Sample Input 2 :
2
1 2 3 4 5 -1
0
10 20 30 40 -1
4
Sample Output 2 :
1 2 3 4 5 
40 30 20 10 

*/

public class ReverseKNodes{

    public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
		if(head==null || head.next == null || k==0 || k==1) return head;
        LinkedListNode<Integer> dummy_head = new LinkedListNode<>(0), temp = head, curr_head = head, next_head = null, prev_head = dummy_head;
        dummy_head.next = head;
        while(temp!=null){
            int t = k;
            while(t-- > 1 && temp.next !=null) temp = temp.next;
            next_head = temp.next;
            temp.next = null;
            prev_head.next = reverseLinkedListRec(curr_head);
            curr_head.next = next_head;
            temp = next_head;
            prev_head = curr_head;
            curr_head = prev_head.next;
        }
         return dummy_head.next;
	}

    public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {

        // actual nodes are reversed and not the values...
        
		if(head ==null || head.next == null) return head;
        LinkedListNode<Integer> temp = reverseLinkedListRec(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
}