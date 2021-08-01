/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan3;

/**
 *
 * @author DrogbaDidier
 */
class Mahasiswa {

    private long nim;
    private String nama;
    private String asal;

    public Mahasiswa(long nim, String nama, String asal) {
        this.nim = nim;
        this.nama = nama;
        this.asal = asal;
    }

    public void displayMhs() {
        System.out.print("\tNIM: " + nim);
        System.out.print(", Nama: " + nama);
        System.out.println(", Asal: " + asal);
    }

    public long getNim() {
        return nim;
    }

    String getNama() {
        return nama;
    }
}

public class DataArray {

    private Mahasiswa[] mhs;
    private int nElemen;

    public DataArray(int max) {
        mhs = new Mahasiswa[max];
        nElemen = 0;
    }

    public Mahasiswa find(long searchNim) {
        int i;
        for (i = 0; i < nElemen; i++) {
            if (mhs[i].getNim() == searchNim) {
                break;
            }
        }
        if (i == nElemen) {
            return null;
        } else {
            return mhs[i];
        }
    }

    public void insert(long nim, String nama, String asal) {
        mhs[nElemen] = new Mahasiswa(nim, nama, asal);
        nElemen++;

    }

    public boolean delete(long searchNim) {
        int i;
        for (i = 0; i < nElemen; i++) {
            if (mhs[i].getNim() == searchNim) {
                break;
            }
        }
        if (i == nElemen) {
            return false;
        } else {
            for (int j = i; j < nElemen; j++) {
                mhs[j] = mhs[j + 1];
            }
            nElemen--;
            return true;
        }

    }

    public void BubbleSort() {
        int batas, i;
        for (batas = nElemen - 1; batas > 0; batas--) {
            for (i = 0; i < batas; i++) {
                if (mhs[i].getNim() > mhs[i + 1].getNim()) {
                    swap(i, i + 1);
                }
            }
        }
    }

    public void swap(int one, int two) {
        Mahasiswa temp = mhs[one];
        mhs[one] = mhs[two];
        mhs[two] = temp;
    }

    public void InsertionSort() {
        int i, curIn;
        for (curIn = 1; curIn < nElemen; curIn++) {
            Mahasiswa temp = mhs[curIn];
            i = curIn;
            while (i > 0 && mhs[i - 1].getNim() >= temp.getNim()) {
                mhs[i] = mhs[i - 1];
                i--;
            }
            mhs[i] = temp;
        }
        System.out.println("\n1. Sorting Mahasiswa by NIM ");
    }

    public void SelectionSortbyName() {
        int awal, i, min;
        for (awal = 0; awal < nElemen - 1; awal++) {
            min = awal;
            for (i = awal; i < nElemen; i++) {
                int compare = mhs[i].getNama().compareTo(mhs[min].getNama());
                if (compare < 0) {
                    min = i;
                }
            }
            swap(awal, min);
        }
        System.out.println("\n2. Sorting Mahasiswa by Name ");
    }

    public void displayArray() {
        for (int i = 0; i < nElemen; i++) {
            mhs[i].displayMhs();
        }
    }
}

class DataArrayApp {

    public static void main(String[] args) {
        int maxSize = 100;
        DataArray arr;
        arr = new DataArray(maxSize);
        arr.insert(16650270, "Agung", "Madiun");
        arr.insert(16650230, "Sofi", "Semarang");
        arr.insert(16650280, "Jundi", "Malang");
        arr.insert(16650260, "Arina", "Malang");
        arr.insert(16650220, "Helmi", "Madura");
        arr.insert(16650240, "Ismail", "Banyuwangi");
        arr.insert(16650250, "Dinda", "Bandung");
        arr.insert(16650200, "Rais", "Ambon");
        arr.insert(16650221, "Ahmad", "Sidoarjo");
        System.out.println("Data Mahasiswa Sebelum Diurutkan");

        arr.BubbleSort();
        arr.displayArray();
        arr.InsertionSort();
        arr.displayArray();
        arr.SelectionSortbyName();
        arr.displayArray();
    }
}
