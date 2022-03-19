package com.example;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {
    private listNode<E> firstNode;
    private listNode<E> lastNode;
    private String name;
    public SinglyLinkedList() {
        this("linked list");
    }
    public SinglyLinkedList(String listName){
        name = listName;
        firstNode = lastNode = null;
    }
    public void insertAtFront(E insertItem) {
        listNode newNode = new listNode(insertItem);
        if (isEmpty()){
            firstNode = lastNode = new listNode<E>(insertItem);
        }else {
            newNode.next = firstNode;
            firstNode = newNode;
        }
    }
    public void insertAtBack(E insertItem) {
        listNode newNode = new listNode(insertItem);
        if (isEmpty()) {
            firstNode = lastNode = new listNode<E>(insertItem);
        } else {
            lastNode.next = newNode;
            lastNode = newNode;
        }
    }
    public E removeFromFront() throws NoSuchElementException{
        if (isEmpty()){
            throw new NoSuchElementException(name + " is empty");
        }
        E removedItem = firstNode.data;

        listNode current = firstNode;
        firstNode = firstNode.next;
        current = null;

        return removedItem;
    }

    public E removeFromBack() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException(name + " is empty");
        }
        E removedItem = lastNode.data;

        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        }else {
            listNode<E> current = firstNode;
            while (current.next != lastNode){
                current = current.next;
            }
            lastNode = current;
            current.next = null;
        }
        return removedItem;
    }

    private boolean isEmpty(){
        return firstNode == null;
    }
    public void print() {
        if (isEmpty()) {
            System.out.printf("Empty %s%n", name);
            return;
        }
        System.out.printf("List %s adalah : %n", name);
        listNode<E> current = firstNode;
        while (current != null) {
            System.out.printf("%s ", current.data);
            current = current.next;
        }
        System.out.println();
    }

}
