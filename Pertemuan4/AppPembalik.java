/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 *
 * @author DrogbaDidier
 */
class stack {

    private int maxSize;
    private Character stackArray[];
    private int top;

    public stack(int size) {
        maxSize = size;
        stackArray = new Character[maxSize];
        top = -1;
    }

    public void push(Character item) {
        stackArray[++top] = item;
    }

    public Character pop() {
        return stackArray[top--];
    }

    public Character peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

}

class pembalik {

    public String reverseWord(int size, String word) {
        stack theStack = new stack(size);

        for (int i = 0; i < word.length(); i++) {
            theStack.push(word.charAt(i));
        }

        String out = "";
        while (!theStack.isEmpty()) {
            out += theStack.pop();
        }
        return out;
    }
}

public class AppPembalik {

    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

//        System.out.println("==============A==============");
        System.out.println(">> katanya...");
        String word = "kasur";
        int size = word.length();
        System.out.println(word);
        pembalik pb = new pembalik();
        System.out.println("dibalik jadi...");
        System.out.println(pb.reverseWord(size, word));

//        System.out.println("==============B==============");
        try {
            while (true) {
                System.out.println("Masukkan kata: ");
                word = input.readLine();
                size = word.length();

                System.out.println("kebalikan: ");
                System.out.println(pb.reverseWord(size, word));
            }

        } catch (IOException e) {
        };

    }

}
