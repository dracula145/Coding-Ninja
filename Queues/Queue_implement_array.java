public class Queue_implement_array {
    private int data[], front, rear, size;
    public Queue_implement_array(){
        data = new int[3];
        front = -1;
        rear = -1;
    }
    public Queue_implement_array(int element){
        data = new int[element];
        front = -1;
        rear = -1;
        size =0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void enqueue(int element){
        if(size ==0) {
            front = 0;
        }
        if((rear == data.length-1 && front==0) || rear == front-1) expand();
        else if((rear == data.length-1 && front!=0) || rear == front-1) rear = -1;

        data[++rear] = element;
        size++;
    }
    public int dequeue()throws QueueEmptyException{
        if(size==0) throw new QueueEmptyException();
        int temp = data[front];
        if(rear==front){
            front = -1;
            rear = -1;
        }
        if(front == size-1  && rear < front) front = 0;
        front++;
        size--;
        return temp;
    }
    private void expand(){
        int temp[] = new int[data.length * 2], c=0;
        for(int i=front;i<data.length;i++) temp[c++] = data[i];
        for(int i=0;i<front;i++) temp[c++] = data[i];
        data = temp;
        front = 0;
        rear = size-1;
    }
}
