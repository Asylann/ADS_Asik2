import java.util.Iterator;

public class MyArrayList<T> implements MyList<T>{
    Object[] arr;
    int size;

    public MyArrayList(){
        arr = new Object[10];
        size = 0;
    }
    @Override
    public void add(T item) {
        if (size == arr.length){
            increaseBuffer();
        }
        arr[size++] = item;
    }

    private void increaseBuffer() {
        Object[] newArr = new Object[arr.length*2];
        for (int i=0;i< arr.length;i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        arr[index] = item;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size == arr.length) {
            increaseBuffer();
        }
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = item;
        size++;
    }




    @Override
    public void addFirst(T item) {
        add(0,item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) arr[index];
    }

    @Override
    public T getFirst() {
        return (T) arr[0];
    }

    @Override
    public T getLast() {
        return (T) arr[size-1];
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(arr, index+1, arr, index, size - index-1);
        arr[size-1] = null;
        size--;
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
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (((Comparable<T>) arr[j]).compareTo((T) arr[j + 1]) > 0) {
                    Object temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int indexof(Object object) {
        for (int i =0;i<size;i++){
            if(arr[i]==object){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int res = -1;
        for (int i =0;i<size;i++){
            if(arr[i]==object){
                res=i;
            }
        }
        return res;
    }

    @Override
    public boolean exists(Object object) {
        return indexof(object)>=0;
    }

    @Override
    public Object[] toArray() {
        return arr;
    }

    @Override
    public void clear() {
        arr = new Object[10];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return (T) arr[index++];
            }
        };
    }
}
