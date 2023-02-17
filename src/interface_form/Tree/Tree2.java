package interface_form.Tree;

public class Tree2 {
    private TreeNode newNode;

    public TreeNode makeNode(int data, TreeNode left, TreeNode right){
        newNode = new TreeNode(data, left, right);
        return newNode;
    }
}
