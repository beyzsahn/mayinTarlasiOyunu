package com.example.Java101.mayinTarlasiOyunu;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        /*Scanner x=new Scanner(System.in);
        System.out.print("Satır giriniz: ");
        int row=x.nextInt();
        System.out.print("Sütun giriniz: ");
        int col=x.nextInt();*/
        MineSweeper mine=new MineSweeper(3,3);
        mine.run();

    }
}
