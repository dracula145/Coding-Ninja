/*

You have been given a head to a singly linked list of integers. 
Write a function check to whether the list given is a 'Palindrome' or not.

Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Time Limit: 1sec

Where 'M' is the size of the singly linked list.
Sample Input 1 :
1
9 2 3 3 2 9 -1
Sample Output 1 :
true
Sample Input 2 :
2
0 2 3 2 5 -1
-1
Sample Output 2 :
false
true
Explanation for the Sample Input 2 :
For the first query, it is pretty intuitive that the the given list is not a 
palindrome, hence the output is 'false'.

For the second query, the list is empty. An empty list is always a palindrome , 
hence the output is 'true'.

*/

import java.io.*;

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;
    
    public LinkedListNode(T data) {
        this.data = data;
    }
}

public class Palindrome {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static LinkedListNode<Integer> takeInput() throws IOException {
        LinkedListNode<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
            if(head == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }
            i += 1;
        }

        return head;
    }
    
    public static void print(LinkedListNode<Integer> head){
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {

            LinkedListNode<Integer> head = takeInput(); 

            boolean ans = isPalindrome(head);
            System.out.println(ans);

            t -= 1;
        }  
    }
    static LinkedListNode<Integer> first_half = null, second_half = null;

    public static boolean isPalindrome(LinkedListNode<Integer> head) {
		if(head==null || head.next ==null) return true;
        LinkedListNode<Integer> slow = head, fast = head;
        first_half = head; second_half = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast == null) second_half = slow; // even number of nodes
        else second_half = slow.next;  // odd number of nodes

        reverse();

        while(second_half !=null){
            if(first_half.data.equals(second_half.data)){
                second_half = second_half.next;
                first_half = first_half.next;
            }
            else return false;
        }
        return true;
	}

    // reversing second half of the linked list
    public static void reverse(){
        LinkedListNode<Integer> prev =null, curr = second_half, next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        second_half = prev;
    }

}
