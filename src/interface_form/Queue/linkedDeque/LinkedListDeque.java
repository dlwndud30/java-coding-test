package interface_form.Queue.linkedDeque;

import interface_form.Queue.Queue;

import java.util.NoSuchElementException;

public class LinkedListDeque<E> implements Queue<E> {
    private Node<E> head;	// 가장 앞에 있는 노드를 가리키는 변수
    private Node<E> tail;	// 가장 뒤에 있는 노드를 가리키는 변수
    private int size;	// 요소(노드)의 개수

    public LinkedListDeque() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean offerFirst(E value){
        Node<E> newNode = new Node<>(value);
        newNode.next = head;

        if(head != null){
            head.prev = newNode;
        }

        head = newNode;
        size++;

        if (head.next == null){
            tail = head;
        }

        return true;
    }

    public boolean offerLast(E value){
        if(size == 0){
            return offerFirst(value);
        }
        Node<E> newNode = new Node<>(value);
        tail.next = newNode;
        newNode.prev = tail;
        tail=newNode;
        size++;

        return true;
    }

    @Override
    public boolean offer(E item) {
        return offerLast(item);
    }

    @Override
    public E poll() {
        return pollFirst();
    }

    public E pollFirst(){
        if(size==0){
            return null;
        }
        E element = head.data;
        Node<E> nextNode = head.next;
        head.data=null;
        head.next=null;

        if(nextNode != null){
            head.prev = null;
        }
        head = null;
        head = nextNode;
        size--;

        if(size == 0){
            tail = null;
        }

        return element;
    }

    public E pollLast() {
        if(size == 0){
            return null;
        }

        E element = tail.data;
        Node<E> prevNode = tail.prev;
        tail.data=null;
        tail.prev=null;

        if(prevNode != null){
            prevNode.next = null;
        }

        tail=null;
        tail=prevNode;
        size--;

        if(size == 0){
            head = null;
        }

        return element;
    }

    public E removeLast() {
        E element = pollLast();

        if(element == null) {
            throw new NoSuchElementException();
        }
        return element;
    }

    public E remove() {
        return removeFirst();
    }

    public E removeFirst() {
        E element = poll();

        if(element == null) {
            throw new NoSuchElementException();
        }
        return element;
    }

    @Override
    public E peek() {
        return peekFirst();
    }

    public  E peekFirst(){
        if (size==0){
            return null;
        }
        return head.data;
    }

    public E peekLast() {
        // 요소가 없을 경우 null 반환
        if(size == 0) {
            return null;
        }

        return tail.data;
    }

    public E element() {
        return getFirst();
    }

    public E getFirst() {
        E item = peek();

        // 앞의 원소 null 이라면(size = 0) 예외를 던진다.
        if(item == null) {
            throw new NoSuchElementException();
        }
        return item;
    }

    public E getLast() {
        E item = peekLast();

        // 앞의 원소 null 이라면(size = 0) 예외를 던진다.
        if(item == null) {
            throw new NoSuchElementException();
        }
        return item;
    }
}
