public class MyMinHeap<T extends Comparable<T>> { // T extends Comparable<T>
    MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    // Add an element to the heap
    public void add(T item) {
        heap.add(item);
        heapifyUp(heap.size() - 1);
    }

    // Remove and return the minimum element
    public T extractMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        // Get the minimum element (root)
        T min = heap.get(0);

        // Replace root with last element
        T lastItem = heap.getLast();
        heap.set(0, lastItem);

        // Remove the last element
        heap.removeLast();

        // Heapify down if there are still elements
        if (!isEmpty()) {
            heapifyDown(0);
        }

        return min;
    }

    // Get the minimum element without removing
    public T getMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    // Helper method to maintain heap property going up
    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;

        // If not at root and parent is greater than current
        while (index > 0 && heap.get(parent).compareTo(heap.get(index)) > 0) {
            // Swap with parent
            T temp = heap.get(index);
            heap.set(index, heap.get(parent));
            heap.set(parent, temp);

            // Move up
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    // Helper method to maintain heap property going down
    private void heapifyDown(int index) {
        int smallest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        // Find the smallest among root, left child, and right child
        if (leftChild < heap.size() && heap.get(leftChild).compareTo(heap.get(smallest)) < 0) {
            smallest = leftChild;
        }

        if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(smallest)) < 0) {
            smallest = rightChild;
        }

        // If smallest is not root
        if (smallest != index) {
            // Swap
            T temp = heap.get(index);
            heap.set(index, heap.get(smallest));
            heap.set(smallest, temp);

            // Recursively heapify the affected subtree
            heapifyDown(smallest);
        }
    }

    // Check if heap is empty
    public boolean isEmpty() {
        return size() == 0;
    }

    // Return the size of the heap
    public int size() {
        return heap.size();
    }
}
