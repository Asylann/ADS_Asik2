# Algorithms-and-Data-Structures_2 Assignment

This project implements custom versions of core data structures in Java, without using `java.util.*` (except `Iterator`).  
The goal is to understand the internal workings of **ArrayList**, **LinkedList**, **Stack**, **Queue**, and **MinHeap** by building them from scratch using only low-level constructs.

---

## MyArrayList<T extends Comparable<T>>

A dynamic array similar to Java’s `ArrayList`.  
Implements the `MyList<T>` interface using a plain `Object[]` array.

### Features
- **Dynamic resizing** when capacity is exceeded
- **Index-based access and updates**: `get(index)`, `set(index, value)`
- **Insertion**:  
  - `add(item)`, `add(index, item)`
  - `addFirst(item)`, `addLast(item)`
- **Removal**:  
  - `remove(index)`, `removeFirst()`, `removeLast()`
- **Searching**:  
  - `indexOf(object)`, `lastIndexOf(object)`, `exists(object)`
- **Sorting**:
  - `sort()` using natural order (`Comparable<T>`)
  - `sort(Comparator<T>)` for custom order
- **Utilities**:  
  - `toArray()`, `clear()`, `size()`, `iterator()`

---

## MyLinkedList<T extends Comparable<T>>

Custom doubly linked list implementation (non-circular).  
Implements the `MyList<T>` interface using internal `Node` class.

### Features
- **Doubly linked structure**: `prev` and `next` pointers
- **Bidirectional traversal** from head and tail
- **Insertion & Removal**:  
  - `add(item)`, `add(index, item)`
  - `addFirst(item)`, `addLast(item)`
  - `remove(index)`, `removeFirst()`, `removeLast()`
- **Element access**:  
  - `get(index)`, `getFirst()`, `getLast()`, `set(index, value)`
- **Searching**:  
  - `indexOf(object)`, `lastIndexOf(object)`, `exists(object)`
- **Sorting**:
  - `sort()` using `Comparable<T>`
  - `sort(Comparator<T>)` for custom comparison
- **Utilities**:  
  - `toArray()`, `clear()`, `size()`, `iterator()`

---

## MyStack<T>

Custom **LIFO** stack using `MyLinkedList<T>` as its internal storage.

## MyQueue<T>

Custom **FIFO** queue using `MyLinkedList<T>` internally.

## MyMinHeap<T extends Comparable<T>>

A custom **min-heap** (priority queue) using `MyArrayList<T>` internally.  
Maintains the heap property: **the minimum element is always at the root**.

### Features
- `insert(item)` — adds and re-heapifies up  
- `extractMin()` — removes and re-heapifies down  
- `getMin()` — returns the smallest item  
- `isEmpty()`, `size()` — utility methods  
- Internally uses `heapifyUp()` and `heapifyDown()` to maintain structure

## Notes

- All classes are **generic** and support **natural or custom ordering** through `Comparable` or `Comparator`.
- No external Java collection classes are used—this is a full manual implementation.
- Code is written for **educational purposes** to understand low-level data structure behavior.
