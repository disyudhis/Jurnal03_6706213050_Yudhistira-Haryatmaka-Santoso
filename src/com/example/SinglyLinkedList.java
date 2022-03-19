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
        if (isEmpty()){ // firstNode and lastNode refer to same object
            firstNode = lastNode = new listNode<E>(insertItem);
        }else { // firstNode refers to new node
            newNode.next = firstNode;
            firstNode = newNode;
        }
    }
    public void insertAtBack(E insertItem) {
        listNode newNode = new listNode(insertItem);
        if (isEmpty()) { //firstNode and lastNode refer to same object
            firstNode = lastNode = new listNode<E>(insertItem);
        } else { //lastNode referes to new node
            lastNode.next = newNode;
            lastNode = newNode;
        }
    }
    public E removeFromFront() throws NoSuchElementException{
        if (isEmpty()){ //throw references firstNode and lastNode
            throw new NoSuchElementException(name + " is empty");
        }
        E removedItem = firstNode.data; // retrieve data being removed

//        update references firstNode and lastNode
        listNode current = firstNode;
        firstNode = firstNode.next;
        current = null;

        return removedItem;
    }

    public E removeFromBack() throws NoSuchElementException {
        if (isEmpty()) { //throw exception if list is empty
            throw new NoSuchElementException(name + " is empty");
        }
        E removedItem = lastNode.data; //retrieve data being removed

//        update references firstNode and lastNode
        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        }else { //locate new last node;
            listNode<E> current = firstNode;

//            loop while current node does not refer to lastNode
            while (current.next != lastNode){
                current = current.next;
            }
            lastNode = current; //current is new lastNode
            current.next = null;
        }
        return removedItem; //return removed node data
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
//        while not at end of list, output current node's data
        while (current != null) {
            System.out.printf("%s ", current.data);
            current = current.next;
        }
        System.out.println();
    }

}
