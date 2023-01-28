package LinkedList;

import interface_form.DoublyLinkedList.DLinkedList;

import java.util.Comparator;

public class TestSort {
    public static void main(String[] args){
        DLinkedList<Student> list = new DLinkedList<>();

        list.add(new Student("김자바", 92));
        list.add(new Student("이시플", 72));
        list.add(new Student("조시샵", 98));
        list.add(new Student("파이손", 51));

//        list.sort();  //class ArrayList.Student cannot be cast to class java.lang.Comparable
        list.sort(customComp);

        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    static Comparator<Student> customComp = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o2.score - o1.score;
        }
    };
}

class Student {
    String name;
    int score;

    Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String toString() {
        return "이름 : " + name + "\t성적 : " + score;
    }
}