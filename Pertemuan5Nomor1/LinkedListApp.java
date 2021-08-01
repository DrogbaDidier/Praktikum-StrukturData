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
public class LinkedListApp {

    public static void main(String[] args) {
        LinkStack theList = new LinkStack();

        theList.push(1, "vcd");
        theList.push(2, "tv");

        theList.displayStack();
        theList.push(3, "kulkas");
        theList.push(4, "pc");
        theList.push(5, "rice cooker");
        theList.push(6, "dispenser");
        theList.displayStack();

        theList.pop();
        theList.pop();
        theList.displayStack();

    }
}
