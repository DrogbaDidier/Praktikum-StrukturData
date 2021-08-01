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
public class LinkedListApp {

    public static void main(String[] args) {
        LinkQueue theList = new LinkQueue();

        theList.insert(1665100, "Deaja");
        theList.insert(1665200, "Dee");

        theList.displayQueue();
        theList.insert(1665300, "Ami");
        theList.insert(1665400, "Haya");
        theList.insert(1665500, "Yati");

        theList.displayQueue();

        theList.remove();
        theList.remove();
        theList.remove();
        theList.displayQueue();

    }
}
