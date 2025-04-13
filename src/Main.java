public class Main {
    public static void main(String[] args) {
        MyMinHeap minHeap = new MyMinHeap();

        // Adding elements
        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(30);
        minHeap.add(2);
        minHeap.add(8);

        // The minimum element
        System.out.println("Minimum element: " + minHeap.getMin());

        // Extracting all elements
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.extractMin() + " ");
        }
    }
}
