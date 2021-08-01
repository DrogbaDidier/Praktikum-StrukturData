/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan10;

/**
 *
 * @author DrogbaDidier
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {

    private int data;

    public Node(int key) {
        this.data = key;

    }

    public int getKey() {
        return data;
    }

    public void setKey(int id) {
        this.data = id;
    }
}

class Heap {

    private Node[] heapArray;
    private int maxSize;
    private int currentSize;
    private int last;

    public Heap(int size) {
        maxSize = size;
        currentSize = 0;
        heapArray = new Node[size];
        last = 0;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean insert(int key) {
        if (currentSize == maxSize) {
            return false;
        }
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    public void trickleUp(int index) {
        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];

        while (index > 0 && heapArray[parent].getKey() < bottom.getKey()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    public Node remove() {
        Node root = heapArray[0];

        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    public void trickleDown(int index) {
        int largerChild;
        Node top = heapArray[index];
        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            if (rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey()) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }
            if (top.getKey() >= heapArray[largerChild].getKey()) {
                break;
            }
            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }

    public void displayHeap() {
        System.out.println("Heap Array: ");
        for (int i = 0; i < currentSize; i++) {
            if (heapArray[i] != null) {
                System.out.print(heapArray[i].getKey() + " ");
            } else {
                System.out.println("--");
            }
        }
        System.out.println("");
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "..................................";
        System.out.println(dots + dots);
        while (currentSize > 0) {
            if (column == 0) {
                for (int wow = 0; wow < nBlanks; wow++) {
                    System.out.print(' ');
                }
            }
            System.out.print(heapArray[j].getKey());
            if (++j == currentSize) {
                break;
            }
            if (++column == itemsPerRow) {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println("");
            } else {
                for (int uwu = 0; uwu < nBlanks * 2 - 2; uwu++) {
                    System.out.print(' ');
                }
            }
        }
        System.out.println("\n" + dots + dots);
    }

    public void displayArray() {
        for (int i = 0; i < last; i++) {
            System.out.print(heapArray[i].getKey() + " ");
        }
        System.out.println("");
    }

    public void insertKey(int in, int val) {
        Node node = new Node(val);
        heapArray[in] = node;
        currentSize++;
        last++;
    }

    public void heapSorting() {
        for (int i = last - 1; i >= 0; i--) {
            for (int j = last / 2 - 1; j >= 0; j--) {
                trickleDown(j);
            }
            Node remove = this.remove();
            heapArray[i] = remove;
        }
    }

    public boolean change(int index, int newValue) {
        if (index < 0 || index >= currentSize) {
            return false;
        }
        int oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);

        if (oldValue < newValue) {
            trickleUp(index);
        } else {
            trickleDown(index);
        }
        return true;
    }

    public void random() throws IOException {
        int size, j;
        System.out.print("Enter number of items: ");
        size = getInt();
        Heap theHeap = new Heap(size);
        for (j = 0; j < size; j++) {
            int random = (int) (java.lang.Math.random() * 100);
            theHeap.insertKey(j, random);
        }
        System.out.print("Random: ");
        theHeap.displayArray();
        theHeap.displayHeap();
        theHeap.heapSorting();
        theHeap.displayArray();
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

}

public class HeapAppSort {

    public static void main(String[] args) throws IOException {
        Heap h = new Heap(32);

        h.random();
        h.heapSorting();
    }

}
