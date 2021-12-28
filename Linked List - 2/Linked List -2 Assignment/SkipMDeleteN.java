/*

You have been given a singly linked list of integers along with two 
integers, 'M,' and 'N.' Traverse the linked list such that you retain 
the 'M' nodes, then delete the next 'N' nodes. Continue the same until the end of the linked list.
To put it in other words, in the given linked list, you need to delete N nodes after every M nodes.

Constraints :
1 <= t <= 10^2
0 <= P <= 10^5
Where P is the size of the singly linked list.
0 <= M <= 10^5
0 <= N <= 10^5 

Time Limit: 1sec
Sample Input 1 :
1
1 2 3 4 5 6 7 8 -1
2 2
Sample Output 1 :
1 2 5 6
Sample Input 2 :
2
10 20 30 40 50 60 -1
0 1
1 2 3 4 5 6 7 8 -1
2 3
Sample Output 2 :
1 2 6 7
Explanation of Sample Input 2 :
For the first query, we delete one node after every zero 
elements hence removing all the items of the list. Therefore, nothing got printed.

For the second query, we delete three nodes after every two nodes, 
resulting in the final list, 1 -> 2 -> 6 -> 7.

*/

public class SkipMDeleteN {
    public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {
        if(M==0) return null;
		LinkedListNode<Integer> temp = head, temp2 = null;
        while(temp!=null){
            int m=M, n=N;
            while(m-- > 1 && temp!=null) temp = temp.next;
            temp2 = temp;
            while(n-- > 0 && temp2!=null) temp2 = temp2.next;
                if(temp2!=null){
                    temp.next = temp2.next;
                    temp = temp.next;
                }
            else if(temp!=null) {  // important... ow it throws NPE 
                temp.next = temp2;
                break;
            }
        }
        return head;
	}
}
