/*

Given a singly linked list of integers and position 'i', 
delete the node present at the 'i-th' 
position in the linked list recursively.

Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.
0 <= i < M

Time Limit:  1sec
Sample Input 1 :
1
3 4 5 2 6 1 9 -1
3
Sample Output 1 :
3 4 5 6 1 9
Sample Input 2 :
2
30 -1
0
10 20 30 50 60 -1
4
Sample Output 2 :
10 20 30 50 

*/

public class DeleteRecursively {
    public static LinkedListNode<Integer> deleteNodeRec(LinkedListNode<Integer> head, int pos) {
        if(head == null && pos>=0) return head;
    	if(pos==0) return head.next;
        head.next = deleteNodeRec(head.next, pos-1);
        return head;
	}
}
