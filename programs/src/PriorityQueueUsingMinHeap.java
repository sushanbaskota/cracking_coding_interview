public class PriorityQueueUsingMinHeap {

    private int[] heap;
    private int size;
    private int capacity;

    public PriorityQueueUsingMinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    public void insert(int element) {
        if (size == capacity) {
            System.out.println("Priority Queue is full. Cannot insert element: " + element);
            return;
        }

        heap[size] = element;
        size++;
        heapifyUp();
    }

    public int extractMin() {
        if (isEmpty()) {
            System.out.println("Priority Queue is empty.");
            return -1; // Assuming -1 represents an empty value
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return min;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void heapifyUp() {
        int currentIndex = size - 1;
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (heap[currentIndex] < heap[parentIndex]) {
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown() {
        int currentIndex = 0;
        while (true) {
            int leftChild = 2 * currentIndex + 1;
            int rightChild = 2 * currentIndex + 2;
            int smallest = currentIndex;

            if (leftChild < size && heap[leftChild] < heap[smallest]) {
                smallest = leftChild;
            }

            if (rightChild < size && heap[rightChild] < heap[smallest]) {
                smallest = rightChild;
            }

            if (currentIndex != smallest) {
                swap(currentIndex, smallest);
                currentIndex = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        PriorityQueueUsingMinHeap priorityQueueUsingMinHeap = new PriorityQueueUsingMinHeap(10);

        priorityQueueUsingMinHeap.insert(3);
        priorityQueueUsingMinHeap.insert(1);
        priorityQueueUsingMinHeap.insert(4);
        priorityQueueUsingMinHeap.insert(1);
        priorityQueueUsingMinHeap.insert(5);

        while (!priorityQueueUsingMinHeap.isEmpty()) {
            System.out.println("Min Element: " + priorityQueueUsingMinHeap.extractMin());
        }
    }
}
