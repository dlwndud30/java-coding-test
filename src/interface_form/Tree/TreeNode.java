package interface_form.Tree;

import interface_form.Set.Node;

public class TreeNode {
    public Object data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Object data, TreeNode left, TreeNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void setLeft(TreeNode node){
        this.left = node;
    }

    public void setRight(TreeNode node){
        this.right = node;
    }

    public TreeNode getLeft(){
        return this.left;
    }

    public TreeNode getRight(){
        return this.right;
    }
}
