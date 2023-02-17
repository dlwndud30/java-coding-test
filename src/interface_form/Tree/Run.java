package interface_form.Tree;

public class Run {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Tree.Node node1 = tree.addNode(1);
        Tree.Node node2 = tree.addNode(2);
        Tree.Node node3 = tree.addNode(3);
        Tree.Node node4 = tree.addNode(4);
        Tree.Node node5 = tree.addNode(5);
        Tree.Node node6 = tree.addNode(6);
        Tree.Node node7 = tree.addNode(7);

        node1.addLeft(node2);
        node1.addRight(node3);
        node2.addLeft(node4);
        node2.addRight(node5);
        node3.addLeft(node6);
        node3.addRight(node7);

        tree.preOrder(node1);
        System.out.println(node1);
        tree.inOrder(node1);
        System.out.println(node1);
        tree.postOrder(node1);
        System.out.println(node1);

        node2.deleteLeft();
        node3.deleteRight();

        tree.preOrder(node1);
        System.out.println(node1);
        tree.inOrder(node1);
        System.out.println(node1);
        tree.postOrder(node1);
        System.out.println(node1);
    }
}
