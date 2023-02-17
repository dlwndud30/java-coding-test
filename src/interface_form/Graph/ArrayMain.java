package interface_form.Graph;

public class ArrayMain {
    public static void main(String[] args) {
        int initSize = 6;
        ArrGraph graph = new ArrGraph(6);

        graph.put(1,2);
        graph.put(1,3);
        graph.put(2,3);
        graph.put(2,4);
        graph.put(3,4);
        graph.put(3,5);
        graph.put(4,5);
        graph.put(4,6);

        graph.printGraphToAdjArr();
    }
}
