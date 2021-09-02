public class DynamicArray {
    private int data[];
    private int nextElemIndex;

    public DynamicArray(){
        data = new int[5];
        nextElemIndex = 0;
    }

    public int size(){
        return nextElemIndex;
    }

    public boolean isEmpty(){
        if(nextElemIndex == 0) return true;
        else return false;
    }

    public int get(int i){
        if(i>=nextElemIndex || nextElemIndex==0) return 0;
        return data[i];
    }

    public void add(int elem){
        if(nextElemIndex == data.length) expandArray();
        data[nextElemIndex++] = elem;
    }

    private void expandArray() {
        int temp[] = data;
        data = new int[data.length * 2];
        for(int i=0;i<temp.length;i++) data[i] = temp[i] ;
        for(int i=temp.length; i<data.length; i++) data[i]=0;
        temp = null;
    }

    public int removeLast (){
        return data[nextElemIndex--];
    }

    public void set (int i, int elem){
        if(i>=nextElemIndex) {
        while(i>=data.length) expandArray();
        nextElemIndex = i+1;
        }

        data[i] = elem;
    }    

    public void print(){
        for(int i=0;i<nextElemIndex;i++) System.out.print(data[i] + " ");
        System.out.println();
    }
}
