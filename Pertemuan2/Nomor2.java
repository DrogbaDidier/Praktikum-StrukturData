/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan2;

/**
 *
 * @author DrogbaDidier
 */
class BinarySearch {

    public int arr[];
    public int nElemen;

    public BinarySearch(int max) {
        arr = new int[max];
        nElemen = 0;
    }

    public void urutan(int value) {

        int i;
        for (i = nElemen - 1; (i >= 0 && arr[i] >= value); i--) {
            arr[i + 1] = arr[i];
        }
        arr[i + 1] = value;
        nElemen++;
    }

    public boolean find(int key) {
        int i;
        int atas = arr.length - 1;
        int bawah = 0;
        int curIn;
        while (bawah <= atas) {
            int tengah = bawah + ((atas - bawah) / 2);

            if (arr[tengah] <= key) {
                return true;
            } else if (key < arr[tengah]) {
                atas = tengah - 1;
            } else {
                bawah = tengah + 1;
            }
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < nElemen; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}

public class Nomor2 {

    public static void main(String[] args) {
        int maxSize = 100;
        BinarySearch arr;
        arr = new BinarySearch(maxSize);

        arr.urutan(maxSize);

        arr.urutan(30);
        arr.urutan(40);
        arr.urutan(20);
        arr.urutan(50);
        arr.urutan(10);
        arr.urutan(60);

        arr.display();

        int key = 20;
        if (arr.find(key)) {
            System.out.println(key + " ditemukan");
        } else {
            System.out.println(key + " tidak ditemukan");
        }
    }
}
