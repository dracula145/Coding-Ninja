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
