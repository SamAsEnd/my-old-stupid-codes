/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samasend.tree;

/**
 *
 * @author SamAsEnd
 */
public class Tree {

    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;
    private TreeNode rootNodePointer;

    public Tree(TreeNode rootNodePointer) {
        this.rootNodePointer = rootNodePointer;
    }

    public Tree() {
        this(null);
    }

    public void add(TreeNode newNode) {
        if (rootNodePointer == null) {
            rootNodePointer = (TreeNode) newNode;
        } else {
            insertBST((TreeNode) rootNodePointer, newNode);
        }
    }

    private void insertBST(TreeNode root, TreeNode node) {
        if (root.getData() > node.getData()) {
            if (root.getLeft() == null) {
                root.setLeft(node);
            } else {
                insertBST(root.getLeft(), node);
            }
        } else {
            if (root.getRight() == null) {
                root.setRight(node);
            } else {
                insertBST(root.getRight(), node);
            }
        }
    }

    public String order(TreeNode node, int order) {
        if (node != null) {
            if (order == Tree.PRE_ORDER) {
                return (String.valueOf(node.getData()) + " " + order(node.getLeft(), order) + " " + order(node.getRight(), order) + " ");
            } else if (order == Tree.IN_ORDER) {
                return (order(node.getLeft(), order) + " " + String.valueOf(node.getData()) + " " + order(node.getRight(), order) + " ");
            } else {
                return (order(node.getLeft(), order) + " " + order(node.getRight(), order) + " " + String.valueOf(node.getData()) + " ");
            }
        }
        else {
            return "";
        }
    }

    public TreeNode getRootNodePointer() {
        return rootNodePointer;
    }
    
    
}
