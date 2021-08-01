/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan5Nomor2;

/**
 *
 * @author DrogbaDidier
 */
public class Link {

    public long nim;
    public String nama;
    public Link next;

    public Link(long Data, String nama) {
        this.nim = Data;
        this.nama = nama;
    }

    public void displayLink() {
        System.out.print(nim + " ");
        System.out.println(nama + "");
    }
}

class FirstLastList {

    private Link first;
    private Link last;

    public FirstLastList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertLast(long nim, String nama) {
        Link newLink = new Link(nim, nama);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;

    }

    public long deleteFirst() {
        long temp = first.nim;
        if (first.next == null) {
            last = null;
        }
        first = first.next;
        return temp;
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

class LinkQueue {

    private FirstLastList theList;

    public LinkQueue() {
        theList = new FirstLastList();
    }

    public boolean isEmpty() {
        return theList.isEmpty();
    }

    public void insert(long nim, String nama) {
        theList.insertLast(nim, nama);
    }

    public long remove() {
        return theList.deleteFirst();
    }

    public void displayQueue() {
        System.out.println("Queue(front --> rear): ");
        theList.displayList();
    }
}
