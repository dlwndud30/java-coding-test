package interface_form.DoublyLinkedList;

import interface_form.ArrayList.List;
import interface_form.DoublyLinkedList.Node;

import java.util.NoSuchElementException;

public class DLinkedList<E> implements List<E> {
    private Node<E> head;   //노드의 첫 부분
    private Node<E> tail;   //노드의 마지막 부분
    private int size;       //요소의 개수

    public DLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(E value){
        Node<E> newNode = new Node<>(value);
        newNode.next = head;
        /**
         * head가 null이 아닐 경우에만 기존 head노드의 prev 변수가
         * 새 노드를 가리키도록 한다.
         * 이유는 기존 head노드가 없는 경우(null)는 데이터가
         * 아무 것도 없던 상태였으므로 head.prev를 하면 잘못된 참조가 된다.
         */
        if(head != null){
            head.prev = newNode;
        }
        head = newNode;
        size++;
        /**
         * 다음에 가리킬 노드가 없는 경우(=데이터가 새 노드밖에 없는 경우)
         * 데이터가 한 개(새 노드)밖에 없으므로 새 노드는 처음 시작노드이자
         * 마지막 노드다. 즉 tail = head 다.
         */
        if (head.next == null) {
            tail = head;
        }
    }

    public void addLast(E value){
        Node<E> newNode = new Node<>(value);

        if(size == 0){
            addFirst(value);
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    @Override
    public boolean add(E value) {
        addLast(value);
        return true;
    }

    @Override
    public void add(int index, E value) {
        if (index>size || index<0){
            throw new IndexOutOfBoundsException();
        }
        if (size==0){
            addFirst(value);
            return;
        }
        if(size==index) {
            addLast(value);
            return;
        }

        //추가하려는 위치의 이전 노드
        Node<E> prev_node = search(index-1);

        //추가하려는 위치의 노드
        Node<E> next_node = prev_node.next;

        //추가하려는 노드
        Node<E> newNode = new Node<>(value);

        //링크 끊기
        prev_node.next = null;
        next_node.prev = null;

        //링크 연결하기
        prev_node.next = newNode;
        newNode.prev = prev_node;
        newNode.next = next_node;
        next_node.prev = newNode;
        size++;
    }

    public E remove() {
        Node<E> headNode = head;

        if (headNode == null){
            throw new NoSuchElementException();
        }

        E element = headNode.data;

        Node<E> nextNode = headNode.next;

        head.data = null;
        head.next = null;

        /**
         * head의 다음노드(=nextNode)가 null이 아닐 경우에만 prev 변수를 null로 업데이트 해주어야 한다.
         * 이유: nextNode가 없는 경우(null)는 데이터가 아무 것도 없던 상태였으므로 nextNode.prev를 하면 잘못된 참조가 된다.
         */
        if(nextNode != null){
            nextNode.prev = null;
        }

        head = nextNode;
        size--;

        /**
         * 삭제된 요소가 리스트의 유일한 요소였을 경우 그 요소는 head 이자 tail이었으므로
         * 삭제되면서 tail도 가리킬 요소가 없기 때문에 size가 0일경우 tail도 null로 변환
         */
        if(size == 0) {
            tail = null;
        }

        return element;
    }

    @Override
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            E element = head.data;
            remove();
            return element;
        }

        //삭제할 노드의 이전 노드
        Node<E> prevNode = search(index-1);

        //삭제할 노드
        Node<E> removeNode = prevNode.next;

        //삭제할 노드의 다음 노드
        Node<E> nextNode = removeNode.next;

        E element = removeNode.data;

        /**
         * index == 0 일 때의 조건에서 이미 head노드의 삭제에 대한 분기가 있기 때문에 prevNode는 항상 존재한다.
         *
         * 그러나 nextNode의 경우는 null일 수 있기 때문에 (= 마지막 노드를 삭제하려는 경우) 반드시 검사를 해준 뒤, nextNode.prev에 접근해야 한다.
         */
        prevNode.next = null;
        removeNode.next = null;
        removeNode.prev = null;
        removeNode.data = null;

        if(nextNode != null){
            nextNode.prev = prevNode;
            prevNode.next = nextNode;
        }else {
            tail = prevNode;
        }
        size--;

        return element;
    }

    @Override
    public boolean remove(Object value) {
        Node<E> prevNode = head;
        Node<E> x = head;

        for(; x!=null; x=x.next){
            if(value.equals(x.data)){
                break;
            }
            prevNode = x;
        }

        if(x == null){
            return false;
        }

        if(x.equals(head)){
            remove();
            return true;
        }else{
            Node<E> nextNode = x.next;

            prevNode.next = null;
            x.data = null;
            x.next = null;
            x.prev = null;

            if(nextNode != null){
                nextNode.prev = prevNode;
                prevNode.next = nextNode;
            }else {
                tail = prevNode;
            }

            size--;
            return true;
        }

    }

    @Override
    public E get(int index) {
        return search(index).data;
    }

    @Override
    public void set(int index, E value) {
        Node<E> replaceNode = search(index);
        replaceNode.data = value;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) >=0;
    }

    @Override
    public int indexOf(Object value) {
        int index = 0;
        for(Node<E> x = head; x!=null; x=x.next){
            if(value.equals(x.data)){
                return index;
            }
            index++;
        }
        return -1;
    }

    public int lastIndexOf(Object value){
        int index = size;
        for(Node<E> x = tail; x!=null; x=x.prev){
            index--;
            if(value.equals(x.data)){
                return index;
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
        for (Node<E> x = head; x!=null;){
            Node<E> nextNode = x.next;
            x.data = null;
            x.next = null;
            x.prev = null;
            x=nextNode;
        }
        head=tail=null;
        size=0;
    }

    public Node<E> search(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }

        if(index+1 >size/2){
            Node<E> x =tail;
            for(int i=size-1; i>index; i--){
                x=x.prev;
            }
            return x;
        }else {
            Node<E> x = head;
            for(int i=0; i<index; i++){
                x=x.next;
            }
            return x;
        }
    }

}
