package ArrayList;

import interface_form.ArrayList;

public class TestClone {
    // clone(): 사용자가 사용하고 있던 ArrayList를 새로 하나 복제하고 싶을 때 쓰는 메소드
    // 단순히 = 연산자로 객체를 복사 -> '주소'를 복사하므로 복사한 객체에서 데이터를 조작할 경우 원본 객체까지 영향을 미침
    // => 얕은 복사(shallow copy)
    public static void main(String[] args){
        ArrayList<Integer> original = new ArrayList<>();
        original.add(10);

        ArrayList<Integer> copy = original;
        copy.add(20);

        ArrayList<Integer> clone = null;
        try {
            clone = (ArrayList<Integer>)original.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        clone.add(30);

        System.out.println("original");
        for (int i=0; i<original.size(); i++){
            System.out.println("index " + i + " data = " + original.get(i));
        }
        System.out.println();

        System.out.println("copy");
        for (int i=0; i<copy.size(); i++){
            System.out.println("index " + i + " data = " + copy.get(i));
        }
        System.out.println();

        System.out.println("clone");
        for (int i=0; i<clone.size(); i++){
            System.out.println("index " + i + " data = " + clone.get(i));
        }
        System.out.println();

        System.out.println("original list reference : " + original);
        System.out.println("copy list reference : " + copy);
        System.out.println("clone list reference : " + clone);

    }
}
