package ArrayList;

import interface_form.DoublyLinkedList.DLinkedList;

import java.util.Comparator;

public class TestSort2 {
    public static void main(String[] args){
        DLinkedList<Student2> list = new DLinkedList<>();

        list.add(new Student2("김자바", 92));
        list.add(new Student2("이시플", 72));
        list.add(new Student2("조시샵", 98));
        list.add(new Student2("파이손", 51));

        list.sort();

        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

class Student2 implements Comparable<Student2>{
    String name;
    int score;

    Student2(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String toString() {
        return "이름 : " + name + "\t성적 : " + score;
    }

    @Override
    public int compareTo(Student2 o){
        return o.score - this.score;
    }
}