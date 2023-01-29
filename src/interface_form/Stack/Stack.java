package interface_form.Stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.EmptyStackException;

public class Stack<E> implements StackInterface<E>,Cloneable {

    private static final int DEFAULT_CAPACITY = 10;	// 최소(기본) 용적 크기
    private static final Object[] EMPTY_ARRAY = {};	// 빈 배열

    private Object[] array;	// 요소를 담을 배열
    private int size;	// 요소 개수


    // 생성자1 (초기 공간 할당 X)
    public Stack() {
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    // 생성자2 (초기 공간 할당 O)
    public Stack(int capacity) {
        this.array = new Object[capacity];
        this.size = 0;
    }

    private void resize() {

        // 빈 배열일 경우 (capacity is 0)
        if(Arrays.equals(array, EMPTY_ARRAY)) {
            array = new Object[DEFAULT_CAPACITY];
            return;
        }

        int arrayCapacity = array.length;	// 현재 용적 크기

        // 용적이 가득 찰 경우
        if(size == arrayCapacity) {
            int newSize = arrayCapacity * 2;

            // 배열 복사
            array = Arrays.copyOf(array, newSize);
            return;
        }

        // 용적의 절반 미만으로 요소가 차지하고 있을 경우
        if(size < (arrayCapacity / 2)) {

            int newCapacity = (arrayCapacity / 2);

            // 배열 복사
            array = Arrays.copyOf(array, Math.max(DEFAULT_CAPACITY, newCapacity));
            return;
        }
    }

    @Override
    public E push(E item) {
        // 용적이 꽉 차있을 경우 용적 재할당
        if(size == array.length){
            resize();
        }
        array[size] = item;
        size++;
        return item;
    }

    @Override
    public E pop() {
        if(size == 0){
            throw new EmptyStackException();
        }
        @SuppressWarnings("unchecked")
        E obj = (E) array[size-1];
        array[size-1] = null;
        size--;
        resize();
        return obj;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E peek() {
        if(size == 0){
            throw new EmptyStackException();
        }
        return (E) array[size-1];
    }

    @Override
    public int search(Object value) {
        if(value == null){
            for (int idx = size-1; idx>=0; idx--){
                if(array[idx] == null){
                    return size-idx;
                }
            }
        }else {
            for(int idx = size-1; idx>=0; idx--){
                if(array[idx].equals(value)){
                    return size-idx;
                }
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for(int i =0; i<size; i++){
            array[i] = null;
        }
        size=0;
        resize();
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        // 새로운 스택 객체 생성
        Stack<?> cloneStack = (Stack<?>) super.clone();

        // 새로운 스택의 배열도 생성해주어야 함(내부 객체는 깊은 복사가 되지 않기 때문)
        cloneStack.array = new Object[size];

        // 현재 배열을 새로운 스택의 배열에 값을 복사함
        System.arraycopy(array, 0, cloneStack.array, 0, size);
        return cloneStack;
    }

    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            return (T[]) Arrays.copyOf(array, size, a.getClass());

        System.arraycopy(array, 0, a, 0, size);

        return a;
    }

    public void sort() {
        /**
         *  Comparator를 넘겨주지 않는 경우 해당 객체의 Comparable에 구현된
         *  정렬 방식을 사용한다.
         *  만약 구현되어있지 않으면 cannot be cast to class java.lang.Comparable
         *  에러가 발생한다.
         *  만약 구현되어있을 경우 null로 파라미터를 넘기면
         *  Arrays.sort()가 객체의 compareTo 메소드에 정의된 방식대로 정렬한다.
         */
        sort(null);
    }

    @SuppressWarnings("unchecked")
    public void sort(Comparator<? super E> c) {
        Arrays.sort((E[]) array, 0, size, c);
    }
}
