public class MyQueue<T> {
    MyLinkedList<T> queue;

    public MyQueue(){
        queue = new MyLinkedList<>();
    }

    //adding element to the last position in the queue
    public void enter(T item){
        queue.addLast(item);
    }

    //removing first element and returning it
    public T exist(){
        if(isEmpty()){
            throw new IllegalStateException("Queue is Empty");
        }
        T temp = queue.getFirst();
        queue.removeFirst();
        return temp;
    }

    //checking if the queue is empty
    public boolean isEmpty() {
        return size() == 0;
    }

    //returning the queue`s size
    public int size(){
        return queue.size();
    }
}
