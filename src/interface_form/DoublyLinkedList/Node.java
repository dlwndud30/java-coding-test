package interface_form.DoublyLinkedList;

public class Node<E> {
    E data;
    Node<E> next;  //다음 노드 객체를 가리키는 래퍼런스 변수
    Node<E> prev;  //이전 노드 객체를 가리키는 래퍼런스 변수

    public Node(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
