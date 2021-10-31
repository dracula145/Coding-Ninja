import java.util.*;

public class MaxPriorityQueue {

    private ArrayList<Integer> heap = new ArrayList<>();

    boolean isEmpty() {
		return heap.size() == 0;
	}

	int getSize() {
		return heap.size();
	}

	int getMax()throws PriorityQueueException {
		if (isEmpty()) {
			// Throw an exception
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}

	void insert(int element) { // O(log n)
		heap.add(element);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;

		while (childIndex > 0) {
			if (heap.get(childIndex) > heap.get(parentIndex)) {
				//swap if child > parent
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			} else return;
		}
	}

	int removeMax() throws PriorityQueueException {
		if (isEmpty()) {
			// Throw an exception
			throw new PriorityQueueException();
		}
		int res=getMax();
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        
        //Traverse from root to leaf, and swap values if needed to maintain min. heap order property
        int parentIndex=0;
        int leftChildIndex = 2*parentIndex+1, rightChildIndex = 2*parentIndex+2;
        while(leftChildIndex < heap.size())
        {
            int maxIndex = parentIndex;
            
            if(heap.get(maxIndex) < heap.get(leftChildIndex)) maxIndex = leftChildIndex;
            
            if(rightChildIndex < heap.size() && heap.get(maxIndex) < heap.get(rightChildIndex))
            maxIndex = rightChildIndex;
            
            if(maxIndex == parentIndex) return res; //if no swapping was done then parent in the minimum so return
            
            int temp=heap.get(parentIndex);
            heap.set(parentIndex,heap.get(maxIndex));
            heap.set(maxIndex,temp);
            
            parentIndex = maxIndex;
            leftChildIndex = 2*parentIndex+1;
            rightChildIndex = 2*parentIndex+2;
        }
        return res;
	}
}