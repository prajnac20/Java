package com.company;
//import java.util.Random;

import java.util.Scanner;

public class RandomNumber {
    static String[] names = new String[1001];
    static int n;
    public static void input(){
        System.out.println("Enter the number of elements that you want to input");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i<n;i++){
            names[i] = sc.next();
        }
        System.out.println("Insertion Successful");

    }
    public static void output(){
        if(n==0){
            System.out.println("ARRAY is Empty");
        }
        else{
            for(int i =0;i<n;i++){
                System.out.println(names[i]);
            }
        }
    }
    public static void search(){
        System.out.println("Enter the key");
        Scanner sc  = new Scanner(System.in);
        String key = sc.nextLine();
        int i = 0;
        for(i = 0;i< n;i++){
            //System.out.println(names[i].equals(key));
            if(names[i].equals(key)){
                System.out.println("The name you're searching is found at "+i+1+"th position");
            }
        }


    }
    public static void update(){
        System.out.println("Enter the name you want to update");
        Scanner sc  = new Scanner(System.in);
        String key = sc.next();
        int i = 0;
        for(i = 0;i< n;i++){
            if(names[i].equals(key)){
                System.out.println("Enter the new name");
                String newname = sc.nextLine();
                names[i] = newname;
                System.out.println("Updation successful");
            }
        }

    }
    public static void main(String[] args){
      /*  int min = 200;
        int max = 400;
//Generate random double value from 200 to 400
        System.out.println("Random value of type double between "+min+" to "+max+ ":");
        double a = Math.random()*(max-min+1)+min;
        System.out.println(a);
        min = 100;
        max = 500;
        int ab = (int)(Math.random()*(max-min+1)+min);
        System.out.println(ab); */
        /*int[] array1 = new int[1000000];
        System.out.println("Executed");*/
        while(true){
            System.out.println("Enter the options. We are trying array operations");
            System.out.println("1)Input\n2)Output\n3)Search\n4)Update\n5)Exit");
            Scanner sc = new Scanner(System.in);
            int c = sc.nextInt();
            switch(c){
                case 1: input();
                break;
                case 2: output();
                break;
                case 3: search();
                break;
                case 4:update();
                break;
                case 5:System.exit(0);
                default:System.out.println("Wrong input");
            }


        }
    }
}
