package heap;

/**
 * https://www.geeksforgeeks.org/min-heap-in-java/
 */
public class MinHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[maxSize];
    }

    private int parent(int position) { return (position-1) / 2; }
    private int leftChild(int position) { return (position * 2) + 1; }
    private int rightChild(int position) { return (position * 2) + 2; }

    private boolean isLeaf(int position) {
        if (position > (size /2) && position <= size ) { return true; }
        return false;
    }

    private void swap(int fpos, int spos) {
        int temp;
        temp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = temp;
    }

    private void minHeapify(int position) {
        if (!isLeaf(position)) {
            int swapPosition = position;
            if (rightChild(position) <= size) {
                swapPosition = heap[leftChild(position)] < heap[rightChild(position)] ? leftChild(position) : rightChild(position);
            } else {
                swapPosition = heap[leftChild(position)];
            }

            if (heap[position] > heap[leftChild(position)] || heap[position] > heap[rightChild(position)]) {
                swap(position, swapPosition);
                minHeapify(swapPosition);
            }
        }
    }

    public void insert(int element) {
        if (size >= maxSize) {
            return;
        }
        heap[size] = element;
        int current = size;
        while (heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    public void print() {
        for (int i = 0; i < (size/2); i++) {
            System.out.print("Parent: " + heap[i]);
            if (leftChild(i) < size) { System.out.print(" Left Child: " + heap[leftChild(i)] );}
            if (rightChild(i) < size) { System.out.print(" Right Child: " + heap[rightChild(i)]);}
            System.out.println();
        }
    }

    public int extractMin() {
        int popped = heap[0];
        heap[0] = heap[size--];
        minHeapify(0);
        return popped;
    }

    public static void main(String[] arg) {
        System.out.println("The Min Heap is ");
        MinHeap minHeap = new MinHeap(15);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        minHeap.print();

        System.out.println("The Min val is " + minHeap.extractMin());
    }


}
