package UTS;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author KEVIN NAUFAL FAHREZI
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Link { //DEKLARASI CLASS LINK

    public Character Data; //DEKLARASI PUBLIC CHARACTER DATA
    public Link next; //DEKLARASI PUBLIC LINK NEXT

    public Link(Character Data) { //Deklarasi METHOD LINK DENGAN NILAI DATA CHARACTER
        this.Data = Data;
    }

    public Character getData() { //DEKLARASI METHOD GETDATA
        return Data;
    }

    public void displayLink() { // DEKLARASI METHOD DISPLAYLINK
        System.out.print(Data + " "); // TAMPILKAN DATA PADA LINKEDLIST
    }
}

class LinkedList { //DEKLARASI CLASS LINKEDLIST

    private Link first; //DEKLARASI VARIABEL FIRST
    private Link sorted; //DEKLARASI VARIABEL SORTED
    public LinkedList() { // DEKLARASI METHOD LINKEDLIST
        first = null; //VARIABEL FIRST SAMA DENGAN NULL
    }

    public boolean isEmpty() { //DEKLARASI METHOD ISEMPTY
        return (first == null); //RETURN NILAI FIRST
    }

    public void insertFirst(Character Data) { //DEKLARASI METHOD INSERTFIRST
        Link newLink = new Link(Data); //MEMBERI NILAI METHOD LINK PADA NILAI NODE & MENGGESERNYA
        newLink.next = first;
        first = newLink;
    }

    public void displayList() { //DEKLARASI METHOD DISPLAYLIST
        Link current = first;  //FIRST SAMA DENGAN LINK CURRENT
        while (current != null) { //PERULANGAN KETIKA TIDAK SAMA DENGAN NULL
            current.displayLink();
            current = current.next; //CURRENT ADALAH CURRENT SELANJUTNYA

        }
        System.out.println("");
    }

    void insertionSort() {

        sorted = null;
        Link current = first;
        while (current != null) {
            Link next = current.next;
            sortedInsert(current);
            current = next;
        }
        first = sorted;
    }

    void sortedInsert(Link newnode) {
        if (sorted == null || sorted.Data.compareTo(newnode.Data) >= 0) {
            newnode.next = sorted;
            sorted = newnode;
        } else {
            Link current = sorted;
            while (current.next != null && current.next.Data < newnode.Data) {
                current = current.next;
            }
            newnode.next = current.next;
            current.next = newnode;
        }
    }

    void find(char[] drogba) {
        int i;
        int jumlahHuruf = 1;
        for (i = 0; i < jumlahHuruf; i++) {
            for (int j = 0; j < jumlahHuruf; j++) {
                if (drogba[i] != ' ') {
                    if (i != j && (drogba[i] == drogba[j])) { //JIKA TERDAPAT HURUF YANG SAMA KECUALI MEMBANDINGKAN HURUF YANG LETAKNYA (i!=j), MAKA:
                        jumlahHuruf++; //JUMLAH HURUF BERTAMBAH
                        drogba[j] = ' ';
                    }
                    if (j == jumlahHuruf - 1) {  //JIKA HURUF SELESAI DIBANDINGKAN DENGAN HURUF LAIN MAKA :
                        System.out.println("Jumlah huruf '" + drogba[i] + "' = " + jumlahHuruf); //PRINT HURUF & JUMLAH
                        jumlahHuruf = 1;

                    }
                }
            }
        }
    }
}


class MainApp { //DEKLARASI METHOD MAINAPP

    public static void main(String[] args) throws IOException {//MAIN METHOD CLASS
        LinkedList list = new LinkedList(); //MEMANGGIL METHOD CLASS SEBELUMNYA
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); //UNTUK INPUTAN KEYBOARD

        System.out.print("Masukkan kata : "); //OUTPUT "MASUKKAN DATA"
        String kata = input.readLine(); //MEMBACA OUTPUT YANG DIMASUKKAN
        int size = kata.length(); //PANJANG KATA YANG DIMASUKKAN
        for (int i = 0; i < size; i++) //LOOPING i ADALAH LEBIH KECIL DARI PANJANG DATA
        {
            list.insertFirst(kata.charAt(i)); //MEMASUKKAN DATA PERTAMA
        }

        list.insertionSort(); //MEMANGGIL METHOD INSERTSORT
        System.out.print("Alfagram : "); //OUTPUT "ALFAGRAM"
        list.displayList(); //MEMANGGIL METHOD DISPLAYLIST
    }
}
