/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan1;

/**
 *
 * @author DrogbaDidier
 */
public class LatihanArray {

    public static void main(String[] args) {

        // DEKLARASI INT DATA YANG DIINGINKAN
        int[] bil = {2, 4, 5, 11, 16, 39};
        // PRINT "BILANGAN GENAP = "
        System.out.println("Bilangan Genap = ");
        // PERULANGAN FOR BILANGAN GENAP
        for (int i = 0; i < bil.length; i++) {
        // PERCABANGAN IF BILANGAN GENAP
            if (bil[i] % 2 == 0) {
        // PRINT OUTPUT BILANGAN GENAP
                System.out.println(bil[i] + "");

            }
        }
//        // PRINT BARIS KOSONG
//        System.out.println("");
//        // PRINT "BILANGAN GANJIL = "
//        System.out.println("Bilangan Ganjil = ");
//        // PERULANGAN FOR BILANGAN GANJIL
//        for (int i = 0; i < bil.length; i++) {
//        // PERCABANGAN IF BILANGAN GANJIL
//            if (bil[i] % 2 != 0) {
//        // PRINT OUTPUT BILANGAN GANJIL
//                System.out.println(bil[i] + "");
//
//            }
//        }
//        System.out.println("");
    }
}
