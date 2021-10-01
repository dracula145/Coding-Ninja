import javax.print.attribute.standard.QueuedJobCount;

public class QueueUse {
    public static void main(String args[]) throws QueueEmptyException{
        Queue_implement_array queue = new Queue_implement_array();
        // queue.enqueue(10);
        // queue.enqueue(20);
        // queue.enqueue(30);
        // queue.enqueue(40);
        // queue.dequeue();
        // queue.enqueue(10);
        // queue.dequeue();
        // queue.enqueue(50);  
        // queue.enqueue(60);
        // queue.enqueue(60);
        // queue.enqueue(60);
        // queue.dequeue();
        // queue.dequeue();
        // queue.enqueue(20);
        // queue.enqueue(90);
        // queue.enqueue(10);
        // queue.enqueue(10);
        // queue.enqueue(20);
        // queue.enqueue(30);
        // queue.enqueue(40);
        // queue.dequeue();
        // queue.enqueue(10);
        // queue.dequeue();
        // queue.enqueue(50);  
        // queue.enqueue(60);
        // queue.enqueue(60);
        // queue.enqueue(60);
        // queue.dequeue();
        // queue.dequeue();
        // queue.enqueue(20);
        // queue.enqueue(90);
        // queue.enqueue(10);

        for(int i=1;i<=10;i++) queue.enqueue(i);
        for(int i=1;i<=5;i++) queue.dequeue();
        for(int i=1;i<=10;i++) queue.enqueue(i);

        while(!queue.isEmpty()) System.out.print(queue.dequeue() + " ");
    }
}
