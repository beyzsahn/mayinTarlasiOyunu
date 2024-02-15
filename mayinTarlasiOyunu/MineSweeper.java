package com.example.Java101.mayinTarlasiOyunu;

import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int row;
    int col;
    int mine;
    String[][] MineMap;
    String[][] GameMap;
    int count;
    int a,b;
    boolean isTrue;


    MineSweeper(int row, int col){
        this.row=row;
        this.col=col;
        this.GameMap=new String[row][col];
        this.MineMap=new String[row][col];
        this.mine=(row*col)/4;
    }
    void MineMap(){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                this.MineMap[i][j]="-";
                this.GameMap[i][j]="-";

            }
        }
    }
    void MinesRandom(){
        Random rand=new Random();
        int minesPlace=0;
        int randRow=rand.nextInt(this.row);
        int randCol=rand.nextInt(this.col);
        if(!this.MineMap[randRow][randCol].equals("*")){
            this.MineMap[randRow][randCol]="*";
            minesPlace++;
        }
    }
    void printMineMap(){
        MinesRandom();
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.col;j++){
                if (!this.MineMap[i][j].equals("*")) {
                    this.MineMap[i][j] = "-";
                }
                System.out.print(this.MineMap[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println("===================");
        System.out.println("Oyuna Hoşgeldiniz!!!");
    }
    void printGameMap(){
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.col;j++){
                this.GameMap[i][j]="-";
                System.out.print(this.GameMap[i][j]+ " ");
            }
            System.out.println();
        }
    }
    void control(){
        count=0;
        for(int i=(a-1);i<=(a+1);i++){
            for(int j=(b-1);j<=(b+1);j++){
                if(i<0 || j<0 || i>=this.row || j>=this.col){
                    continue;
                }
                if(this.MineMap[i][j].equals("*")){
                    count++;
                }
            }
        }
        this.GameMap[a][b]=String.valueOf(count);
        this.MineMap[a][b]=String.valueOf(count);
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.col;j++){
                System.out.print(this.GameMap[i][j]+" ");
                }
            System.out.println();
            }
        }
    boolean finish(){
        for(int i=0;i<this.row;i++) {
            for (int j = 0; j < this.col; j++) {
                if (this.MineMap[i][j].equals("-")) {
                    return false;
                }
            }
        }
        return true;
    }
    void ChooseIndex(){
        Scanner x=new Scanner(System.in);
        isTrue=false;
        while(!isTrue){
            System.out.print("Satır: ");
            a=x.nextInt();
            System.out.print("Sütun: ");
            b=x.nextInt();

            a-=1;
            b-=1;

            if(a>row || b>col){
                System.out.println("Yanlış değerler girdiniz.");
                continue;
            }
            if(MineMap[a][b].equals("*")){
                System.out.println("Game Over!");
                break;
            }
            control();
            if(finish()){
                System.out.println("You win.");
                break;
            }
        }
    }
    void run(){
        MineMap();
        printMineMap();
        ChooseIndex();
    }
}

