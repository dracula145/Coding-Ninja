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