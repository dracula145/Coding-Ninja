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