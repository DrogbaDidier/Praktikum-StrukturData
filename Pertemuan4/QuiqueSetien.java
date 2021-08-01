/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan4;

/**
 *
 * @author DrogbaDidier
 */
class Queue {

    private int maxSize;
    private String[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int size) {
        this.maxSize = size;
        queArray = new String[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(String value) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = value;
        nItems++;
    }

    public String remove() {
        String temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return temp;

    }

    public String peekFront() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public int size() {
        return nItems;
    }

    public void display() {
        int nampung = this.front;
        for (int i = 0; i < queArray.length; i++) {
            System.out.print(queArray[front++] + "");
            if (front == maxSize) {
                front++;
            }
        }
    }
}

public class QuiqueSetien {

    public static void main(String[] args) {
        Queue theQueue = new Queue(5);
        System.out.println(">> beberapa mulai mengantri");
        theQueue.insert("Andi");
        theQueue.insert("Ahmad");
        theQueue.insert("Satrio");
        theQueue.insert("Sukran");
        theQueue.insert("Mahmud");

        while (!theQueue.isEmpty()) {
            String n = theQueue.remove();
            System.out.print(n);
            System.out.print(" ");
        }
        System.out.println("");
    }
}
