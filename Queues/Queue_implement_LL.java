/*

Implement a Queue Data Structure specifically to store integer data using a Singly Linked List.
The data members should be private.
You need to implement the following public functions :
1. Constructor:
It initialises the data members as required.
2. enqueue(data) :
This function should take one argument of type integer. It enqueues the element into the queue and returns nothing.
3. dequeue() :
It dequeues/removes the element from the front of the queue and in turn, returns the element being dequeued or removed. In case the queue is empty, it returns -1.
4. front() :
It returns the element being kept at the front of the queue. In case the queue is empty, it returns -1.
5. getSize() :
It returns the size of the queue at any given instance of time.
6. isEmpty() :
It returns a boolean value indicating whether the queue is empty or not.

*/

public class Queue_implement_LL {

    class Node{
        int data;
        Node next;
    }
    
    private Node front, rear;
    int size;


	public Queue_implement_LL() {
		front = null;
        rear = null;
        size = 0;
	}
	


	/*----------------- Public Functions of Stack -----------------*/


	public int getSize() { 
		return size;
    }


    public boolean isEmpty() { 
    	return size==0;
    }


    public void enqueue(int data) {
        Node temp = new Node(data);
    	if(size==0){
            front = temp;
            rear = temp;
        }
        else {
        	rear.next = temp;
        	rear = rear.next;
             }
        size++;
    }


    public int dequeue() {
    	if(size==0) return -1;
        int temp = front.data;
        front = front.next;
        size--;
        return temp;
    }


    public int front() {
        if(size==0) return -1;
    	return front.data;
    }
}
