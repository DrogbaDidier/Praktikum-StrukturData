/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan6;

/**
 *
 * @author DrogbaDidier
 */
public class Nomor2 {

    static void doMenara(int n, char tiang1, char tiang2, char tiang3) {
        if (n == 1) {
            System.out.println("perpindahan cakram 1 dari tiang " + tiang1 + " ke tiang " + tiang2);
            return;
        }
        doMenara(n - 1, tiang1, tiang3, tiang2);
        System.out.println("perpindahan cakram " + n + " dari tiang " + tiang1 + " ke tiang " + tiang2);
        doMenara(n - 1, tiang3, tiang2, tiang1);
    }

    public static void main(String[] args) {
        int n = 4;
        doMenara(n, 'A', 'B', 'C');
    }
}
