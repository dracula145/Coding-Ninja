/*

Given a singly linked list of integers, reverse it using 
recursion and return the head to the modified list. You have 
to do this in O(N) time complexity where N is the size of the linked list.

Constraints :
1 <= t <= 10^2
0 <= M <= 10^4
Where M is the size of the singly linked list.

Time Limit: 1sec
Sample Input 1 :
1
1 2 3 4 5 6 7 8 -1
Sample Output 1 :
8 7 6 5 4 3 2 1
Sample Input 2 :
2
10 -1
10 20 30 40 50 -1
Sample Output 2 :
10 
50 40 30 20 10 

*/

public class ReverseRecursively {
    public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {

        // actual nodes are reversed and not the values...
        
		if(head ==null || head.next == null) return head;
        LinkedListNode<Integer> temp = reverseLinkedListRec(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
	}
}
