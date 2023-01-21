package interface_form;

import java.util.Arrays;

public class ArrayList<E> implements List<E>, Cloneable{

    private static final int DEFAULT_CAPACITY = 10;  //최소(기본) 용적 크기
    private static final Object[] EMPTY_ARRAY = {};  //빈 배열

    private  int size;  //배열에 담긴 요소 개수
    Object[] array;     //요소를 담은 배열

    //생성자1 (초기 공간 할당 X)
    public ArrayList(){
        this.array = EMPTY_ARRAY;
        this.size = 0;
    }

    //생성자2 (초기 공간 할당 O)
    public ArrayList(int capacity){
        this.array = new Object[capacity];
        this.size = 0;
    }

    //동적 할당을 위한 resize 메소드
    //데이터는 적은데 용적이 크면 메모리가 낭비되고, 반대로 용적은 적은데 데이터가 많으면 넘치는 데이터들은 보관할 수 없음
    //size(요소의 개수)가 용적(capacity)에 얼마만큼 차있는지를 확인하고, 적절한 크기에 맞게 배열의 용적을 변경해야 함
    //용적은 외부에서 마음대로 접근하면 데이터의 손상을 야기할 수 있기 때문에 private로 접근을 제한
    private void resize(){
        int array_capacity = array.length;

        //if array's capacity is 0
        if(Arrays.equals(array, EMPTY_ARRAY)){
            array = new Object[DEFAULT_CAPACITY];
            return;
        }

        //용량이 꽉 찰 경우
        if(size == array_capacity){
            int new_capacity = array_capacity *2;

            //copy
            array = Arrays.copyOf(array, new_capacity);
            return;
        }

        //용적의 절반 미만으로 요소가 차지하고 있을 경우
        if(size < (array_capacity/2)){
            int new_capacity = array_capacity / 2;

            //copy
            array = Arrays.copyOf(array,Math.max(new_capacity, DEFAULT_CAPACITY));
            return;
        }
    }

    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    public void addLast(E value){
        //꽉 차있으면 용적 재할당
        if(size== array.length){
            resize();
        }
        array[size] = value;    //마지막 위치에 요소 추가
        size++;                 //사이즈 1 증가
    }

    @Override
    public void add(int index, E value) {
        //영역을 벗어날 경우 에외 발생
        if(index>size || index<0){
            throw new IndexOutOfBoundsException();
        }

        //index가 마지막 위치라면
        if(index == size){
            addLast(value);
        }else{
            //꽉 차있다면 용적 재할당
            if (size == array.length){
                resize();
            }

            // index 기준 후자에 있는 모든 요소들 한 칸씩 뒤로 밀기
            for(int i=size; i>index; i--){
                array[i] = array[i-1];
            }

            array[index] = value;
            size++;
        }
    }
    public void addFirst(E value){
        add(0, value);
    }

    @SuppressWarnings("unchecked")  // type safe(타입 안정성)에 대해 경고를 보내지 않음
    @Override
    public E remove(int index) {
        //범위 벗어나면 예외 발생
        if(index>=size || index<0){
            throw new IndexOutOfBoundsException();
        }

        //삭제될 요소를 반환하기 위해 임시 저장
        E element = (E) array[index];
        array[index] = null;  // null로 처리해주어야 가비지컬렉터에 의해 더이상 쓰지 않는 데이터의 메모리를 수거(반환)해주기 때문에 최대한 null 처리를 하는 것이 좋음

        //삭제한 요소의 뒤에 있는 모든 요소를 한칸씩 당겨옴
        for(int i=index; i<size-1; i++){
            array[i] = array[i+1];
            array[i+1]=null;
        }
        size--;
        resize();
        return element;
    }

    @Override
    public boolean remove(Object value) {
        int index = indexOf(value);

        if(index == -1){
            return false;
        }
        remove(index);
        return true;
    }

    @SuppressWarnings("unchecked")  // type safe(타입 안정성)에 대해 경고를 보내지 않음
    @Override
    public E get(int index) {
        //범위 벗어나면 예외 발생
        if(index>=size || index<0){
            throw new IndexOutOfBoundsException();
        }
        // Object 타입에서 E 타입으로 캐스팅 후 반환
        return (E) array[index];
    }

    @Override
    public void set(int index, E value) {
        //범위 벗어나면 예외 발생
        if(index>=size || index<0){
            throw new IndexOutOfBoundsException();
        }else{
            //해당 위치의 요소를 교체
            array[index] = value;
        }
    }

    @Override
    public boolean contains(Object value) {
        if(indexOf(value) >= 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int indexOf(Object value) {
        int i = 0;

        //value와 같은 객체(요소 값)일 경우 i(위치)를 반환
        for(i=0; i<size; i++){
            if(array[i].equals(value)){
                return i;
            }
        }
        //일치하는 것이 없을 경우 -1 반환
        return -1;
    }

    public int lastIndexOf(Object value){
        for(int i= size; i>=0; i--){
            if (array[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        //모든 공간을 null 처리
        for(int i=0; i<size; i++){
            array[i]=null;
        }
        size=0;
        resize();
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        //새로운 객체 생성
        ArrayList<?> cloneList = (ArrayList<?>)super.clone();

        //새로운 객체 배열 생성
        cloneList.array = new Object[size];

        //배열의 값을 복사
        System.arraycopy(array, 0, cloneList.array, 0, size);

        return cloneList;
    }

    public Object[] toArray(){
        return Arrays.copyOf(array,size);
    }

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a){
        if (a.length < size) {
            // copyOf(원본 배열, 복사할 길이, Class<? extends T[]> 타입)
            return (T[]) Arrays.copyOf(array, size, a.getClass());
        }
        // 원본배열, 원본배열 시작위치, 복사할 배열, 복사할배열 시작위치, 복사할 요소 수
        System.arraycopy(array, 0, a, 0, size);
        return a;
    }
}
