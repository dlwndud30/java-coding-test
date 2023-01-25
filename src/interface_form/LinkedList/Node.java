package interface_form.LinkedList;

public class Node<E> {
    E data;
    Node<E> next;  //다음 노드 객체를 가리키는 래퍼런스 변수

    public Node(E data) {
        this.data = data;
        this.next = null;
    }
}