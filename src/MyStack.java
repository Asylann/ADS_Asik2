public class MyStack<T> {
    MyLinkedList<T> stack;

    public MyStack(){
        stack = new MyLinkedList<>();
    }

    //adding element to the last position in the stack
    public void enter(T item){
        stack.addLast(item);
    }

    //removing last element and returning it
    public T exist(){
        if(isEmpty()){
            throw new IllegalStateException("stack is Empty");
        }
        T temp = stack.getLast();
        stack.removeLast();
        return temp;
    }

    //checking if the stack is empty
    public boolean isEmpty() {
        return size() == 0;
    }

    //returning the stack`s size
    public int size(){
        return stack.size();
    }
}