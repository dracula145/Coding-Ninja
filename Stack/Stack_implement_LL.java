/*

Implement a Stack Data Structure specifically to store integer data using a Singly Linked List.
The data members should be private.
You need to implement the following public functions :
1. Constructor:
It initialises the data members as required.
2. push(data) :
This function should take one argument of type integer. It pushes the element into the stack and returns nothing.
3. pop() :
It pops the element from the top of the stack and in turn, returns the element being popped or deleted. In case the stack is empty, it returns -1.
4. top :
It returns the element being kept at the top of the stack. In case the stack is empty, it returns -1.
5. size() :
It returns the size of the stack at any given instance of time.
6. isEmpty() :
It returns a boolean value indicating whether the stack is empty or not.

*/

public class Stack_implement_LL {

    Node head;
    int size;

    public Stack() {
        
    }

    public int getSize() { 
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void push(int element) {
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        size ++;
    }

    public int pop() {
        if(size == 0) return -1;
        Node temp = head;
        head = head.next;
        size--;
        return temp.data;
    }

    public int top() {
        if(size == 0) return -1;
        return head.data;
    }
}