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
class mahasiswa {

    private long nim;
    private String nama;
    private String asal;

    public mahasiswa(long nim, String nama, String asal) {
        this.nim = nim;
        this.nama = nama;
        this.asal = asal;
    }

    public void display() {
        System.out.print("\tNIM: " + nim);
        System.out.print("Nama: " + nama);
        System.out.println(", Asal: " + asal);
    }

    public long getNim() {
        return nim;
    }
}

public class Nomor3 {

    private mahasiswa[] mhs;
    private int nElemen;

    public Nomor3(int max) {
        mhs = new mahasiswa[max];
        nElemen = 0;
    }

    public mahasiswa find(long searchNim) {
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
        mhs[nElemen] = new mahasiswa(nim, nama, asal);
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

    public void display() {
        for (int i = 0; i < nElemen; i++) {
            mhs[i].display();
        }
    }
}

class nomer3App {

    public static void main(String[] args) {
        int maxSize = 100;
        Nomor3 arr;
        arr = new Nomor3(maxSize);

        arr.insert(16650200, "Jundi", "Malang");
        arr.insert(16650210, "Ahmad", "Sidoarjo");
        arr.insert(16650220, "Ismail", "Banyuwangi");
        arr.insert(16650230, "Sofi", "Semarang");
        arr.insert(16650240, "Dinda", "Bandung");
        arr.insert(16650250, "Rais", "Ambon");
        arr.insert(16650260, "Helmi", "Madura");
        arr.insert(16650270, "Agung", "Madiun");
        arr.insert(16650280, "Arina", "Malang");

        arr.display();

        long searchKey = 16650270;
        mahasiswa mhs = arr.find(searchKey);
        if (mhs != null) {
            System.out.print("\nKetemu");
            mhs.display();
        } else {
            System.out.print("Ga ketemu " + searchKey);
        }

        searchKey = 16650240;
        System.out.println("\nHapus nim: " + searchKey);
        arr.delete(searchKey);

        arr.display();
    }
}
