/*

For a given singly linked list of integers, arrange the elements such 
that all the even numbers are placed after the odd numbers. The relative 
order of the odd and even terms should remain unchanged.

Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.

Time Limit: 1sec
Sample Input 1 :
1
1 4 5 2 -1
Sample Output 1 :
1 5 4 2 
Sample Input 2 :
2
1 11 3 6 8 0 9 -1
10 20 30 40 -1
Sample Output 2 :
1 11 3 9 6 8 0
10 20 30 40

*/

public class EvenAfterOdd{

    public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {
		if(head == null || head.next == null) return head;
        LinkedListNode<Integer> odd_head = null, odd_tail = null, even_head = null, even_tail = null;
        while(head != null){
        if(head.data %2 !=0){
            if(odd_head == null){
                odd_head = head;
                odd_tail = head;
            }
            else{
                odd_tail.next = head;
                odd_tail = odd_tail.next;
            }
        }
        else{
            if(even_head == null){
                even_head = head;
                even_tail = head;
            }
            else{
                even_tail.next = head;
                even_tail = even_tail.next;
            }
        }
            head = head.next;
      }
        if(odd_head == null) return even_head;
        else odd_tail.next = even_head;
        if(even_head!=null) even_tail.next = null; //this case needs to be handled ow TLE.. some nodes may be there after even_tail
        return odd_head;
	}
}
