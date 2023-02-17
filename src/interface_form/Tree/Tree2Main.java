package interface_form.Tree;

public class Tree2Main {
    public static void main(String[] args) {
        Tree2 tree = new Tree2();

        TreeNode node5 = tree.makeNode(5, null, null);
        TreeNode node6 = tree.makeNode(6, null, null);
        TreeNode node2 = tree.makeNode(2,  node5, node6);
        TreeNode node3 = tree.makeNode(3, null, null);
        TreeNode node1 = tree.makeNode(1, node2, node3);

    }
}
