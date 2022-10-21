package heap;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[maxSize];
    }

    private int parent(int position) { return (position - 1) / 2; }
    private int leftChild(int position) { return position * 2 + 1; }
    private int rightChild(int position) { return position * 2 + 2; }

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

    private void maxHeapify(int position) {
        if (isLeaf(position)) return;
        if (heap[position] < heap[leftChild(position)] || heap[position] < heap[rightChild(position)]) {
            if (heap[leftChild(position)] > heap[rightChild(position)]) {
                swap(position, leftChild(position));
                maxHeapify(leftChild(position));
            } else {
                swap(position, rightChild(position));
                maxHeapify(rightChild(position));
            }
        }
    }

    public void insert(int element) {
        heap[size] = element;
        int current = size;
        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    public void print() {
        for (int i = 0; i < (size/2); i++) {
            System.out.println("Parent Node: " + heap[i]);
            if (leftChild(i) < size) { System.out.println("Left Child Node: " + heap[leftChild(i)] );}
            if (rightChild(i) < size) { System.out.println("Right Child Node: " + heap[rightChild(i)]);}
            System.out.println();
        }
    }

    public int extractMax() {
        int popped = heap[0];
        heap[0] = heap[--size];
        maxHeapify(0);
        return popped;
    }

    public static void main(String[] args) {
        System.out.println("The Max Heap is: ");
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.print();

        System.out.println("The max val is: " + maxHeap.extractMax());
    }

}
