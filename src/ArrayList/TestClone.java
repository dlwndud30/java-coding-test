package ArrayList;

import interface_form.ArrayList.ArrayList;

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
        System.out.println("clone list reference : " + clone +"\n\n");

        ArrayList<Integer> list = new ArrayList<>();

        // get list to array (using toArray())
        Object[] array1 = list.toArray();   //ArrayList에 있는 요소의 수만큼 정확하게 배열의 크기가 할당되어 반환됨

        // get list to array (using toArray(T[] a)
        Integer[] array2 = new Integer[10];  //객체 클래스로 상속관계에 있는 타입이거나 Wrapper(Integer -> int) 같이 데이터 타입을 유연하게 캐스팅할 여지가 있음
        array2 = list.toArray(array2);

    }
}
