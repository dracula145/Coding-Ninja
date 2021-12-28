/*

You have been given a singly linked list of integers along 
with two integers, 'i,' and 'j.' Swap the nodes that are present at the 'i-th' and 'j-th' positions.

Note :
Remember, the nodes themselves must be swapped and not the datas.

Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.
0 <= i < M
0 <= j < M

Time Limit: 1sec
Sample Input 1 :
1
3 4 5 2 6 1 9 -1
3 4
Sample Output 1 :
3 4 5 6 2 1 9 
 Sample Input 2 :
2
10 20 30 40 -1
1 2
70 80 90 25 65 85 90 -1
0 6
 Sample Output 2 :
10 30 20 40 
90 80 90 25 65 85 70 

*/

public class SwapNodes {
    public static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int i, int j) {
		if(head==null || head.next == null || i==j) return head;
        LinkedListNode<Integer> dummy_head = new LinkedListNode<>(1), h1=dummy_head, 
        h2=null, t1=dummy_head, t2=null, temp=null;
        dummy_head.next = head;
        int f = (j-i == 1)? 0 : 1 ;
        if(j<i){
            int t = i;
            i=j;
            j=t;
        }
        i++;j++;
        while(i-- > 1) h1 = h1.next;
        h2 = h1.next;
        while(j-- > 1) t1 = t1.next;
        t2 = t1.next;
        
        // swapping
        if(f == 1){
        h1.next = t2;
        temp = t2.next;
        t2.next = h2.next;
        t1.next = h2;
        h2.next = temp;
        }
        else {		// to handle those cases where nodes are adjacent
            h1.next = t2;
            h2.next = t2.next;
            t2.next = h2;
        }
        
        return dummy_head.next;
	}
}
