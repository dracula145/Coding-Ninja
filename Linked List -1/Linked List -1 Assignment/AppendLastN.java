/*

You have been given a singly linked list of integers along with an 
integer 'N'. Write a function to append the last 'N' nodes towards 
the front of the singly linked list and returns the new head to the list.

Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
0 <= N < M
Time Limit: 1sec

Where 'M' is the size of the singly linked list.
Sample Input 1 :
2
1 2 3 4 5 -1
3
10 20 30 40 50 60 -1
5
Sample Output 1 :
3 4 5 1 2
20 30 40 50 60 10
Sample Input 2 :
1
10 6 77 90 61 67 100  -1
4
Sample Output 2 :
90 61 67 100 10 6 77 

 Explanation to Sample Input 2 :
We have been required to move the last 4 nodes to the front of the list. Here, 
"90->61->67->100" is the list which represents the last 4 nodes. When we move 
this list to the front then the remaining part of the initial list which is, 
"10->6->77" is attached after 100. Hence, the new list formed with an updated 
head pointing to 90.

*/

public class AppendLastN {
    public static LinkedListNode<Integer> appendLastNToFirst(LinkedListNode<Integer> head, int n) {
        if(head==null || n==0) return head;
		LinkedListNode<Integer> temp = head, new_head = head, tail = head, new_tail =head;
        int l =0, c=0;
        while(temp!=null){
            l++;
            temp = temp.next;
        }
        temp = head;
        c=l+1;
        while(c-- > 2){
            if(c==n+1){
                new_tail = temp;
                new_head = temp.next;
            }
            if(c==1) tail= temp;
            temp = temp.next;            
        }
        tail = temp;
        tail.next = head;
        new_tail.next = null;
        return new_head;
	}
}
