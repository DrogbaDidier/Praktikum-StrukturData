package Pertemuan6;

import java.io.IOException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DrogbaDidier
 */
public class Nomor1 {

    public static int nilaiPangkat(int nilai, int pangkat) {
        if (pangkat == 0) {
            return 1;
        } else {
            return nilai * nilaiPangkat(nilai, pangkat - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("2^10 = " + nilaiPangkat(2, 10));
        System.out.println("3^5 = " + nilaiPangkat(3, 5));
        System.out.println("3^16 = " + nilaiPangkat(3, 16));
    }
}
