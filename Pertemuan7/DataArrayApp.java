/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan7;

/**
 *
 * @author DrogbaDidier
 */
public class DataArrayApp {

    public static void main(String[] args) {
        int maxSize = 100;
        DataArray arr;
        arr = new DataArray(maxSize);
        arr.insert(16650200, "Zulfadli", "Medan");
        arr.insert(16650220, "Zulfan", "Papua Nugini");
        arr.insert(16650250, "Balotelli", "Timor Timur");
        arr.insert(16650270, "Lely", "Neraka");
        arr.insert(16650240, "Zhaclin", "Palembang");
        arr.insert(16650210, "Fajriadi", "Padang");
        arr.insert(16650260, "Andi", "Pacitan");
        arr.insert(16650280, "Keno", "Jakarta Timur");
        arr.insert(16650230, "Syarifudin", "Sidoarjo");

        arr.displayArray();

        long searchKey = 16650270;
        Mahasiswa mhs = arr.find(searchKey);
        if (mhs != null) {
            System.out.print("        Ketemu");
            mhs.displayMhs();

        } else {
            System.out.println("        NIM : " + searchKey + " Tidak Ketemu");
        }
        searchKey = 16650240;
        System.out.println("");
        System.out.println("        Hapus NIM : " + searchKey);
//        System.out.println("");
        arr.delete(searchKey);
        arr.BubbleSort();
        arr.displayArray();
        arr.InsertionSort();
        arr.displayArray();
        arr.SelectionSortbyName();
        arr.displayArray();
        arr.QuickSort();
        arr.displayArray();
        arr.Shell();
        arr.displayArray();
        arr.mergeSort();
        arr.displayArray();
    }

}
