/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan5Nomor1;

/**
 *
 * @author DrogbaDidier
 */
public class Link {

    public int id;
    public String namabrg;
    public Link next;

    public Link(int Data, String namabrg) {
        this.id = Data;
        this.namabrg = namabrg;
    }

    public void displayLink() {
        System.out.print(id + " ");
        System.out.println(namabrg + "");
    }
}

class DoublyLinkedList {

    private Link first;

    public DoublyLinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int id, String namaBrg) {
        Link newLink = new Link(id, namaBrg);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public Link find(int key) {
        Link current = first;
        while (current.id != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public Link delete(int key) {
        Link current = first;
        Link previous = first;
        while (current.id != key) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }

    public void displayList() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}

class LinkStack {

    private DoublyLinkedList theList;

    public LinkStack() {
        theList = new DoublyLinkedList();
    }

    public void push(int id, String namaBrg) {
        theList.insertFirst(id, namaBrg);
    }

    public void pop() {
        theList.deleteFirst();
    }

    public boolean isEmpty() {
        return (theList.isEmpty());
    }

    public void displayStack() {
        System.out.println("Stack(top --> bottom)");
        theList.displayList();
    }
}
