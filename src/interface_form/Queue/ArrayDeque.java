package interface_form.Queue;

import java.util.NoSuchElementException;

public class ArrayDeque<E> implements Queue<E> {
    private static final  int DEFAULT_CAPACITY = 64;

    private Object[] array;
    private int size;

    private int front;
    private int rear;

    public ArrayDeque() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    public ArrayDeque(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    private void resize(int newCapacity) {

        int arrayCapacity = array.length; // 현재 용적 크기

        Object[] newArray = new Object[newCapacity]; // 용적을 변경한 배열

        /*
         * i = new array index
         * j = original array
         * index 요소 개수(size)만큼 새 배열에 값 복사
         */
        for (int i = 1, j = front + 1; i <= size; i++, j++) {
            newArray[i] = array[j % arrayCapacity];
        }

        this.array = null;
        this.array = newArray; // 새 배열을 기존 array의 배열로 덮어씌움

        front = 0;
        rear = size;

    }

    @Override
    public boolean offer(E item) {
        return offerLast(item);
    }

    public boolean offerLast(E item){
        if((rear+1)%array.length == front){
            resize(array.length*2);
        }

        rear = (rear+1)%array.length;
        array[rear] = item;
        size++;

        return true;
    }

    public boolean offerFirst(E item){
        if((front-1 +array.length)%array.length == rear){
            resize(array.length*2);
        }

        array[front] = item;
        front = (front-1+array.length)%array.length;
        size++;

        return true;
    }

    @Override
    public E poll() {
        return pollFirst();
    }

    public E pollFirst(){
        if(size == 0){
            return null;
        }
        front = (front+1)%array.length;

        @SuppressWarnings("unchecked")
                E item = (E)array[front];
        array[front] = null;
        size--;

        if(array.length > DEFAULT_CAPACITY && size < (array.length / 4)) {
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }

        return item;
    }

    public E remove() {
        return removeFirst();	// 예외는 removeFirst()에서 던져준다.
    }

    public E removeFirst() {
        E item = pollFirst();	// pollFirst()을 호출한다.

        if(item == null) {
            throw new NoSuchElementException();
        }

        return item;
    }

    public E pollLast(){
        if (size == 0){
            return null;
        }

        @SuppressWarnings("unchecked")
                E item = (E)array[rear];
        array[rear] = null;
        rear = (rear-1 +array.length) % array.length;
        size--;

        if(array.length > DEFAULT_CAPACITY && size < (array.length / 4)) {
            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }

        return item;
    }

    public E removeLast() {
        E item = pollLast();

        if(item == null) {
            throw new NoSuchElementException();
        }

        return item;
    }

    @Override
    public E peek() {
        return peekFirst();
    }

    public E peekFirst(){
        if(size == 0){
            return null;
        }

        @SuppressWarnings("unchecked")
                E item = (E)array[(front+1)%array.length];
        return item;
    }

    public E peekLast() {
        // 요소가 없을 경우 null 반환
        if(size == 0) {
            return null;
        }

        @SuppressWarnings("unchecked")
        E item = (E) array[(rear)];
        return item;
    }

    public E element() {
        return getFirst();
    }

    public E getFirst() {
        E item = peek();

        // 앞의 원소가 null 이라면(size = 0) 예외를 던진다.
        if(item == null) {
            throw new NoSuchElementException();
        }
        return item;
    }

    public E getLast() {
        E item = peekLast();

        // 앞의 원소가 null 이라면(size = 0) 예외를 던진다.
        if(item == null) {
            throw new NoSuchElementException();
        }
        return item;
    }
}
