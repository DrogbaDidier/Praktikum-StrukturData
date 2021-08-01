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

    public void ShellSort() {
        int in, out;
        int h = nElemen / 2;
        while (h > 0) {
            for (out = (int) h; out < nElemen; out++) {
                Mahasiswa temp = mhs[out];
                in = out;
                while (in > h - 1 && mhs[in - h].getNim() >= temp.getNim()) {
                    mhs[in] = mhs[in - h];
                    in -= h;
                }
                mhs[in] = temp;
            }
            h /= 2;
        }
    }

    public void Shell() {
        System.out.println("Menggunakan Shell Sort Data diurutkan berdasarkan Nama : ");
        int in, out;
        int h = nElemen / 2;
        while (h > 0) {
            for (out = (int) h; out < nElemen; out++) {
                Mahasiswa temp = mhs[out];
                in = out;
                while (in > h - 1 && mhs[in - h].getNama().compareTo(temp.getNama()) >= 0) {
                    mhs[in] = mhs[in - h];
                    in -= h;
                }
                mhs[in] = temp;
            }
            h /= 2;
        }
    }

    public void QuickSort() {
        System.out.println("Menggunakan Quick Sort Data diurutkan berdasarkan NIM : ");
        recQuickSort(0, nElemen - 1);
    }

    public void recQuickSort(int batasKiri, int batasKanan) {
        if (batasKanan - batasKiri <= 0) {
            return;
        } else {
            int pivot = (int) mhs[batasKanan].getNim();
            int partisi = partitionIt(batasKiri, batasKanan, pivot);
            recQuickSort(batasKiri, partisi - 1);
            recQuickSort(partisi + 1, batasKanan);
        }
    }

    public int partitionIt(int batasKiri, int batasKanan, int pivot) {
        int indexKiri = batasKiri - 1;
        int indexKanan = batasKanan + 1;
        while (true) {
            while (indexKiri < batasKanan && mhs[++indexKiri].getNim() < pivot) ;
            while (indexKanan > batasKiri && mhs[--indexKanan].getNim() > pivot);
            if (indexKiri >= indexKanan) {
                break;
            } else {
                swap(indexKiri, indexKanan);
            }
        }
        return indexKiri;
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
        System.out.println("\n1. Sorting Mahasiswa Dari NIM ");
    }

    public void mergeSort() {
        System.out.println("Menggunakan Merge Sort Data diurutkan berdasarkan NIM : ");
        Mahasiswa[] workSpace = new Mahasiswa[nElemen];
        recMergeSort(workSpace, 0, nElemen - 1);
    }

    public void recMergeSort(Mahasiswa[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(workSpace, lowerBound, mid);
            recMergeSort(workSpace, mid + 1, upperBound);
            merge(workSpace, lowerBound, mid + 1, upperBound);
        }
    }

    public void merge(Mahasiswa[] workSpace, int lowIndex, int highIndex, int upperBound) {
        int j = 0;
        int lowerBound = lowIndex;
        int mid = highIndex - 1;
        int nItem = upperBound - lowerBound + 1;
        while (lowIndex <= mid && highIndex <= upperBound) {
            if (mhs[lowIndex].getNim() < mhs[highIndex].getNim()) {
                workSpace[j++] = mhs[lowIndex++];
            } else {
                workSpace[j++] = mhs[highIndex++];
            }
        }
        while (lowIndex <= mid) {
            workSpace[j++] = mhs[lowIndex++];
        }
        while (highIndex <= upperBound) {
            workSpace[j++] = mhs[highIndex++];
        }
        for (j = 0; j < nItem; j++) {
            mhs[lowerBound + j] = workSpace[j];
        }
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
        System.out.println("\n2. Sorting Mahasiswa Dari Nama ");
    }

    public void displayArray() {
        System.out.println();
        for (int i = 0; i < nElemen; i++) {
            mhs[i].displayMhs();
        }
        System.out.println("");
    }
}
