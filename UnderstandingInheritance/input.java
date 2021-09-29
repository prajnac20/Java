package com.company;
import com.company.*;
import java.util.*;

public class input extends extendedcal {



    public static void main(String[] args) {
        input ip = new input();
        while (true) {
            System.out.print("Choose the options\n 1)Add \n2)Subtract\n3)Multiply\n4)Divide\n5)Prime\n6)Odd or Even\n7)Squareroot\n Press 9 to exit");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter two numbers");
                    double num1 = sc.nextDouble();
                    double num2 = sc.nextDouble();
                    System.out.println(ip.add(num1, num2));
                    break;
                case 2:
                    System.out.println("Enter two numbers");
                    num1 = sc.nextDouble();
                    num2 = sc.nextDouble();
                    System.out.println(ip.sub(num1, num2));
                    break;
                case 3:
                    System.out.println("Enter two numbers");
                    num1 = sc.nextDouble();
                    num2 = sc.nextDouble();
                    System.out.println(ip.mul(num1, num2));
                    break;
                case 4:
                    System.out.println("Enter two numbers");
                    num1 = sc.nextDouble();
                    num2 = sc.nextDouble();
                    System.out.println(ip.div(num1, num2));
                    break;
                case 5:
                    System.out.println("Enter a numbers");
                    num1 = sc.nextInt();
                    //num2 = sc.nextDouble();
                    ip.isPrime((int)num1);
                    break;
                case 6:
                    System.out.println("Enter a numbers");
                    num1 = sc.nextInt();
                    //num2 = sc.nextDouble();
                    ip.oddOreven((int)num1);
                    break;
                case 7:
                    System.out.println("Enter a numbers");
                    num1 = sc.nextInt();
                    //num2 = sc.nextDouble();
                    ip.sqroot((int)num1);
                    break;
                case 9:System.exit(0);
                    break;
                default:System.out.println("Wrong Input");
                         break;


            }

        }
    }

}
