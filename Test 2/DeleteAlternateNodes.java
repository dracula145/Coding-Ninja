/*

Given a Singly Linked List of integers, delete all the alternate nodes in the list.
Example:
List: 10 -> 20 -> 30 -> 40 -> 50 -> 60 -> null
Alternate nodes will be:  20, 40, and 60.

Hence after deleting, the list will be:
Output: 10 -> 30 -> 50 -> null

Input Constraints:
1 <= N <= 10 ^ 6.
Where N is the size of the Singly Linked List

Time Limit: 1 sec
Sample Input 1:
1 2 3 4 5 -1
Sample Output 1:
1 3 5
Explanation of Sample Input 1:
2, 4 are alternate nodes so we need to delete them 
Sample Input 2:
10 20 30 40 50 60 70 -1
Sample Output 2:
10 30 50 70 

*/

public class DeleteAlternateNodes {
    public static void deleteAlternateNodes(Node<Integer> head) {
        if(head==null) return;
        Node<Integer> temp = head;
        while(temp.next!=null && temp.next.next!=null ){
            temp.next = temp.next.next;
            temp = temp.next;
        }
        temp.next = null;
    }
}
