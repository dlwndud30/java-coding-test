package ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class NameSearch {
    public static void main(String[] args){
        NameSearch ms = new NameSearch();
        ms.printNames();
    }

    public void printNames(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();

        for(int i=0; i<5; i++){
            names.add(scanner.next());
        }
          //ConcurrentModificationException 발생
//        Iterator<String> iterator = names.iterator();
//        while(iterator.hasNext()){
//            String name = iterator.next();
//            if(name.substring(0,1).equals("박")){
//                names.remove(name);
//            }
//        }

//        for(int i=0; i<names.size(); i++){
//            String firstName = names.get(i).substring(0,1);
//            System.out.println(firstName);
//            if(!firstName.equals("김")){
//                names.remove(i);
//            }
//        }

        ArrayList<String> kim = new ArrayList<>();
        for(String name:names){
            if(name.substring(0,1).equals("김")){
                kim.add(name);
            }
        }
        System.out.println(kim);
    }
}
