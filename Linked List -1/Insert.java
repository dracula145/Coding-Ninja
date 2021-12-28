/*

You have been given a singly linked list of integers, an integer value 
called 'data' and a position with the name 'pos.'
 Write a function to add a node to the list with the 'data' at the specified position, 'pos.'
Note :
Assume that the Indexing for the singly linked list always starts from 0.

If the position is greater than the length of the singly linked list, 
you should return the same linked list without any change.

 Constraints :
1 <= t <= 10^2
0 <= N <= 10^5
pos >= 0
Time Limit: 1sec
Sample Input 1 :
1
3 4 5 2 6 1 9 -1
3 100
Sample Output 1 :
3 4 5 100 2 6 1 9
Sample Input 2 :
2
3 4 5 2 6 1 9 -1
0 20
10 98 7 66 8 -1
5 99
Sample Output 2 :
20 3 4 5 2 6 1 9
10 98 7 66 8 99 

*/

public class Insert {
    public static LinkedListNode<Integer> insert(LinkedListNode<Integer> head, int pos, int data){
		LinkedListNode<Integer> newNode = new LinkedListNode<>(data), temp = head;
        if(pos ==0){
        	newNode.next = head;
            head = newNode;
            return head;
        }
        while(pos-- >1 && temp!=null) temp = temp.next;
        if(temp!=null){
            newNode.next = temp.next;
            temp.next = newNode;
        }
        return head;
	}
}
