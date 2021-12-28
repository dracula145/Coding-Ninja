/*

For a given a singly linked list of integers and a position 'i', 
print the node data at the 'i-th' position.
 Note :
Assume that the Indexing for the singly linked list always starts from 0.

If the given position 'i',  is greater than the length of the given 
singly linked list, then don't print anything.

Remember/Consider :
While specifying the list elements for input, -1 indicates the end of 
the singly linked list and hence, would never be a list element.

Constraints :
1 <= t <= 10^2
0 <= N <= 10^5
i  >= 0
Time Limit: 1sec
Sample Input 1 :
1
3 4 5 2 6 1 9 -1
3
Sample Output 1 :
2
Sample Input 2 :
2
3 4 5 2 6 1 9 -1
0
9 8 4 0 7 8 -1
3
Sample Output 2 :
3
0

*/

public class printIth {
    public static void printIthNode(LinkedListNode<Integer> head, int i){
        LinkedListNode<Integer> temp = head;
        if(temp==null) return;
		while(i-- > 0 && temp!=null)  temp = temp.next;
        if(temp!=null) System.out.println(temp.data);
	}
}
