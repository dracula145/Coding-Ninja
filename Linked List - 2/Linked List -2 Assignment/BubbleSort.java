/*

Given a singly linked list of integers, sort it using 'Bubble Sort.'

Constraints :
0 <= M <= 10^3
Where M is the size of the singly linked list.

Time Limit: 1sec
Sample Input 1 :
10 9 8 7 6 5 4 3 -1
Sample Output 1 :
 3 4 5 6 7 8 9 10 
 Sample Output 2 :
10 -5 9 90 5 67 1 89 -1
Sample Output 2 :
-5 1 5 9 10 67 89 90 

*/

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


/*

public class Solution {
    public static int LengthLL(LinkedListNode<Integer> head) {
		int count=1;
		while(head.next!=null) {
			head=head.next;
			count++;
		}
		return count;
	}

	public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {
		//Your code goes here
        	if(head == null || head.next == null) {
			return head;
		}
		for(int i=0;i<LengthLL(head)-1;i++) {
			LinkedListNode<Integer> prev=null,curr=head,next=curr.next;
			while(curr.next!=null) {
				if(curr.data>curr.next.data) {
					if(prev == null) {
						curr.next=next.next;
						next.next=curr;
						prev=next;
						head=prev;
					}else {
						next=curr.next;
						curr.next=next.next;
						prev.next=next;
						next.next=curr;
						prev=next;
					
					}
				}else {
					prev=curr;
					curr=curr.next;
				}
			}
		}
		return head;
	}
}
*/