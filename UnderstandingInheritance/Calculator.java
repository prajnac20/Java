package com.company;
import java.util.*;

public class Calculator {
    double add(double a,double b){
        return a+b;
    }
    int add(int a,int b,int c){
        return a+b+c;
    }
    int add(int a,int b,int c,int d){
        return a+b+c+d;
    }
    double mul(double a,double b){
        return a*b;
    }
    int mul(int a,int b,int c){
        return a*b*c;
    }
    int mul(int a,int b,int c,int d){
        return a*b*c*d;
    }
    double div(double a,double b){
        return a/b;
    }
    double sub(double a,double b){
        return a-b;
    }
    int sub(int a,int b,int c){
        return a-b-c;
    }
    int sub(int a,int b,int c,int d){
        return a-b-c-d;
    }
    public static void main(String[] args){
        Calculator calc = new Calculator();
        System.out.println("Choose your operation \n1)Addition\n2)Subtraction\n3)Multiplication\n4)Division");
        Scanner sc = new Scanner(System.in);
       int choice = sc.nextInt();

           switch (choice) {
               case 1:
                   System.out.println("Enter a new choice\n1)Add two numbers\n2)Three numbers\n3)Four numbers");
                   int addchoice = sc.nextInt();
                   switch (addchoice) {
                       case 1:
                           System.out.println("Enter two number");
                           int num1 = sc.nextInt();
                           int num2 = sc.nextInt();
                           System.out.println("Addition of two number" + calc.add(num1, num2));
                           break;
                       case 2:
                           System.out.println("Enter three number");
                           num1 = sc.nextInt();
                           num2 = sc.nextInt();
                           int num3 = sc.nextInt();
                           System.out.println("Addition of three number" + calc.add(num1, num2, num3));
                           break;
                       case 3:
                           System.out.println("Enter four number");
                           num1 = sc.nextInt();
                           num2 = sc.nextInt();
                           num3 = sc.nextInt();
                           int num4 = sc.nextInt();
                           System.out.println("Addition of four number" + calc.add(num1, num2, num3, num4));
                           break;
                       default:
                           System.out.println("Wrong input");
                           break;

                   }
                   break;
               case 2:
                   System.out.println("Enter a new choice\n1)Substraction two numbers\n2)Three numbers\n3)Four numbers");
                   addchoice = sc.nextInt();
                   switch (addchoice) {
                       case 1:
                           System.out.println("Enter two number");
                           int num1 = sc.nextInt();
                           int num2 = sc.nextInt();
                           System.out.println("Substraction of two number" + calc.sub(num1, num2));
                           break;
                       case 2:
                           System.out.println("Enter three number");
                           num1 = sc.nextInt();
                           num2 = sc.nextInt();
                           int num3 = sc.nextInt();
                           System.out.println("Substraction of three number" + calc.sub(num1, num2, num3));
                           break;
                       case 3:
                           System.out.println("Enter four number");
                           num1 = sc.nextInt();
                           num2 = sc.nextInt();
                           num3 = sc.nextInt();
                           int num4 = sc.nextInt();
                           System.out.println("Substraction of four number" + calc.sub(num1, num2, num3, num4));
                           break;
                       default:
                           System.out.println("Wrong input");
                           break;

                   }
                   break;
               case 3:
                   System.out.println("Enter a new choice\n1)MUltiplication two numbers\n2)Three numbers\n3)Four numbers");
                   addchoice = sc.nextInt();
                   switch (addchoice) {
                       case 1:
                           System.out.println("Enter two number");
                           int num1 = sc.nextInt();
                           int num2 = sc.nextInt();
                           System.out.println("MUltiplication of two number" + calc.mul(num1, num2));
                           break;
                       case 2:
                           System.out.println("Enter three number");
                           num1 = sc.nextInt();
                           num2 = sc.nextInt();
                           int num3 = sc.nextInt();
                           System.out.println("MUltiplication of three number" + calc.mul(num1, num2, num3));
                           break;
                       case 3:
                           System.out.println("Enter four number");
                           num1 = sc.nextInt();
                           num2 = sc.nextInt();
                           num3 = sc.nextInt();
                           int num4 = sc.nextInt();
                           System.out.println("MUltiplication of four number" + calc.mul(num1, num2, num3, num4));
                           break;
                       default:
                           System.out.println("Wrong input");
                           break;

                   }
                   break;
               case 4:
                   System.out.println("Division");
                   System.out.println("Enter two  numbers");
                   int num1 = sc.nextInt();
                   int num2 = sc.nextInt();
                   System.out.println("Division of two number" + calc.div(num1, num2));
               default:
                   System.exit(0);
           }
       }
    }
