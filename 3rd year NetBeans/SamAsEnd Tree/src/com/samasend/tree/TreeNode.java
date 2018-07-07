/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samasend.tree;

/**
 *
 * @author SamAsEnd
 */
public class TreeNode {

    Integer data;
    
    TreeNode left;
    TreeNode right;

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    public TreeNode(int data) {
        this(data,null,null);
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
    
}
