/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sam;

import java.util.Iterator;

/**
 *
 * @author SamAsEnd
 */
public class Node<T> implements Iterable<T> {

    private static Node head = null;
    private T data;
    private Node<T> next;

    public Node() {
        this(null);
    }

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public boolean isEmpty() {
        return (data == null);
    }

    public boolean hasNext() {
        return (data == null);
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public Iterator<T> iterator() {
        return null;

    }

    public void addToList() {
        if (head == null) {
            head = this;
            setNext(null);
        } else {
            Node<T> tmp = head;

            while (tmp.hasNext()) {
                tmp = tmp.getNext();
            }

            tmp.setNext(this);
        }
    }

    public void viewAll() {
        Node<T> tmp = head;
        System.out.println("=============================================");
        while (tmp.hasNext()) {
            System.out.println(tmp.toString());
            tmp = tmp.getNext();
        }
        System.out.println("=============================================");
    }

    @Override
    public String toString() {
        return data.toString();
    }
    
    
    public static void main(String[] args) {
        Node<String> node = new Node<>();
        node.setData("Samson");
        node.addToList();
        node.viewAll();
        node = new Node<>();
        node.setData("Zeko");
        node.addToList();
        node.viewAll();
        node = new Node<>();
        node.setData("Biruk");
        node.addToList();
        node.viewAll();
    }
}
