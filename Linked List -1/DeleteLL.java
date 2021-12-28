/*

You have been given a linked list of integers. Your task is to write a 
function that deletes a node from a given position, 'POS'.
Note :
Assume that the Indexing for the linked list always starts from 0.

If the position is greater than or equal to the length of the linked 
list, you should return the same linked list without any change.

Constraints :
1 <= T <= 10^2
0 <= N <= 10^5
POS >= 0

Time Limit: 1sec
Sample Input 1 :
1 
3 4 5 2 6 1 9 -1
3
Sample Output 1 :
3 4 5 6 1 9
Sample Input 2 :
2
3 4 5 2 6 1 9 -1
0
10 20 30 40 50 60 -1
7
Sample Output 2 :
4 5 2 6 1 9
10 20 30 40 50 60

*/

public class DeleteLL {
    public static LinkedListNode<Integer> deleteNode(LinkedListNode<Integer> head, int pos) {
		if(head == null) return head;
        LinkedListNode<Integer> temp = head;
        if(pos == 0) return head.next;
        while(pos-- > 1 && temp!=null) temp = temp.next;
        if(temp!=null && temp.next != null) temp.next = temp.next.next;
        return head;
	}
}
