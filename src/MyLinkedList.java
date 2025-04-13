import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T>{
    public class MyNode<T>{
        private T data;
        private MyNode<T> next;
        private MyNode<T> prev;
        public MyNode(MyNode<T> prev, T data, MyNode<T> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(tail, item, null);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        MyNode<T> current = head;
        for(int i= 0;i<index;i++){
            current = current.next;
        }
        current.data = item;
    }
    private void checkIndex(int index) {
        if(index < 0 || index >=size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
    @Override
    public void add(int index, T item) {
        // Allow inserting at index 0 (head), in the middle, or at the end (size)
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        // Case 1: Adding at the beginning (index == 0)
        if (index == 0) {
            MyNode<T> newNode = new MyNode<>(null, item, head); // new node points to old head
            if (head != null) {
                head.prev = newNode; // old head's prev points back to new node
            }
            head = newNode; // new node becomes head
            if (tail == null) {
                tail = newNode; // if list was empty, also set tail
            }
        }
        // Case 2: Adding at the end (index == size)
        else if (index == size) {
            MyNode<T> newNode = new MyNode<>(tail, item, null); // new node after current tail
            if (tail != null) {
                tail.next = newNode; // old tail points to new node
            }
            tail = newNode; // new node becomes tail
            if (head == null) {
                head = newNode; // if list was empty, also set head
            }
        }
        // Case 3: Adding somewhere in the middle (0 < index < size)
        else {
            MyNode<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next; // move to the node at given index
            }
            // current now points to the node that will come AFTER the new node
            MyNode<T> newNode = new MyNode<>(current.prev, item, current);
            current.prev.next = newNode; // previous node's next points to new node
            current.prev = newNode;      // current node's prev points to new node
        }

        size++; // increment list size
    }


    @Override
    public void addFirst(T item) {
        add(0,item);
    }

    @Override
    public void addLast(T item) {
        add(size,item);
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        MyNode<T> current = head;
        for(int i=0;i<index;i++){
            current = current.next;
        }
        return current.data;
    }

    public MyNode<T> getNode(int index) {
        checkIndex(index);
        MyNode<T> current = head;
        for(int i=0;i<index;i++){
            current = current.next;
        }
        return current;
    }

    @Override
    public T getFirst() {
        return head.data;
    }

    @Override
    public T getLast() {
        return tail.data;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);  // Ensure the index is valid

        MyNode<T> current = head;

        // Traver to the node at the specified index
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        if (current.prev == null) {
            head = current.next;  // Set head to the next node
            if (head != null) {
                head.prev = null;  // If head is not null, set its previous to null
            }
        }
        else if (current.next == null) {
            tail = current.prev;  // Set tail to the previous node
            if (tail != null) {
                tail.next = null;  // If tail is not null, set its next to null
            }
        }
        else {
            current.prev.next = current.next;  // Link previous node to the next node
            current.next.prev = current.prev;  // Link next node to the previous node
        }

        size--;  // Decrement size
    }


    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size-1);
    }

    @Override
    public void sort() {
        for(int i = 0;i<size;i++){
            for (int j = 0;j<size-i-1;j++){
                if(((Comparable<T>) get(j)).compareTo((T) get(j+1))>0){
                    T temp = getNode(j).data;
                    getNode(j).data = getNode(j+1).data;
                    getNode(j+1).data = temp;
                }
            }
        }
    }

    @Override
    public int indexof(Object object) {
        MyNode<T> current = head;
        int currentIndex = 0;
        while(current!=null){
            if(current.data.equals(object)){
                return currentIndex;
            }
            current = current.next;
            currentIndex++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode<T> current = tail;
        int currentIndex = size-1;
        while(current!=null){
            if(current.data.equals(object)){
                return currentIndex;
            }
            current = current.prev;
            currentIndex--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        if(indexof(object)>=0){
            return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        MyNode<T> current = head;
        int i =0;
        while (current!=null){
            newArray[i++] = current.data;
            current = current.next;
        }
        return newArray;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size=0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode<T> current = head;
            public boolean hasNext() {
                return current != null;
            }
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
