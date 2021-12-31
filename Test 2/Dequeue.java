/*

You need to implement a class for Dequeue i.e. for double ended queue. In this queue, elements can be inserted and deleted from both the ends.
You don't need to double the capacity.
You need to implement the following functions -
1. constructor
You need to create the appropriate constructor. Size for the queue passed is 10.
2. insertFront -
This function takes an element as input and insert the element at the front of queue. Insert the element only if queue is not full. And if queue is full, print -1 and return.
3. insertRear -
This function takes an element as input and insert the element at the end of queue. Insert the element only if queue is not full. And if queue is full, print -1 and return.
4. deleteFront -
This function removes an element from the front of queue. Print -1 if queue is empty.
5. deleteRear -
This function removes an element from the end of queue. Print -1 if queue is empty.
6. getFront -
Returns the element which is at front of the queue. Return -1 if queue is empty.
7. getRear -
Returns the element which is at end of the queue. Return -1 if queue is empty.

Sample Input 1:
5
1
49
1
64
2
99
5
6
-1
Sample Output 1:
-1
64
99
Explanation:
The first choice code corresponds to getFront. Since the queue is empty, hence the output is -1. 
The following input adds 49 at the top and the resultant queue becomes: 49.
The following input adds 64 at the top and the resultant queue becomes: 64 -> 49
The following input add 99 at the end and the resultant queue becomes: 64 -> 49 -> 99
The following input corresponds to getFront. Hence the output is 64.
The following input corresponds to getRear. Hence the output is 99.

*/

public class Dequeue {
    private int data[], front, rear, size;
    
    public Dequeue(int elem){
        data = new int [elem];
    	front = -1;
        rear = -1;
        size = 0;
    }
    public void insertFront (int elem){
        if(size==0){
            rear = 0;
            front = 0;
            data[front] = elem;
            size++;
            return;
        }
        if(size == 10){
            System.out.println(-1);
            return;
        }
        for(int i=rear;i>=0;i--){
            data[i+1] = data[i];
        }
        rear++;
        data[0] = elem;
        size++;
    }
    public void insertRear (int elem){
        if(size==0) front = 0;
        if(size == 10){
            System.out.println(-1);
            return;
        }
        data[++rear] = elem;
        size++;
    }
    public void deleteFront() {
        if(size == 0){
            System.out.println(-1);
            return;
        }
        for(int i=0;i<rear;i++) data[i] = data[i+1];
        rear--;
        size--;
    }
    public void deleteRear (){
        if(size == 0){
            System.out.println(-1);
            return;
        }
        rear--;
        size--;
    }
    public int getFront (){
        if(size==0) return -1;
        return data[front];
    }
    public int getRear (){
        if(size==0) return -1;
        return data[rear];
    }
    
}