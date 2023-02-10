package interface_form.Heap;

import java.util.Comparator;

public class Heap<E> {
    private final Comparator<? super E> comparator;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] array;

    public Heap(){
        this(null);
    }

    public Heap(Comparator<? super E> comparator){
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.comparator = comparator;
    }

    public Heap(int capacity){
        this(capacity, null);
    }

    public Heap(int capacity, Comparator<? super E> comparator){
        this.array = new Object[capacity];
        this.size = 0;
        this.comparator = comparator;
    }

    private int getParent(int index){
        return index/2;
    }

    private int getLeftChild(int index){
        return index*2;
    }

    private int getRightChild(int index){
        return index*2+1;
    }

    /**
     * @param newCapacity 새로운 용적 크기
     */
    private void resize(int newCapacity) {

        // 새로 만들 배열
        Object[] newArray = new Object[newCapacity];

        // 새 배열에 기존에 있던 배열의 요소들을 모두 복사해준다.
        for(int i = 1; i <= size; i++) {
            newArray[i] = array[i];
        }

        /*
         *  현재 배열은 GC 처리를 위해 null로 처리한 뒤,
         *  새 배열을 연결해준다.
         */
        this.array = null;
        this.array = newArray;
    }

    public void add(E value){
        if(size+1 == array.length){
            resize(array.length*2);
        }

        siftUp(size+1, value);
        size++;
    }

    private void siftUp(int idx, E target) {
        if(comparator != null){
            siftUpComparator(idx, target, comparator);
        }else {
            siftUpComparable(idx, target);
        }
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparable(int idx, E target) {
        Comparable<? super E> comp = (Comparable<? super E>) target;

        while (idx>1){
            int parent = getParent(idx);
            Object parentVal = array[parent];

            if(comp.compareTo((E)parentVal)>=0){
                break;
            }
            array[idx] = parentVal;
            idx=parent;
        }
        array[idx]=comp;
    }

    @SuppressWarnings("unchecked")
    private void siftUpComparator(int idx, E target, Comparator<? super E> comp) {
        while (idx>1){
            int parent = getParent(idx);
            Object parentVal = array[parent];

            if(comp.compare(target, (E)parentVal) >= 0){
                break;
            }

            array[idx] = parentVal;
            idx=parent;
        }

        array[idx] = target;
    }
}
