package com.company;
import java.lang.*;

public class extendedcal extends Calculator{
    void oddOreven(int a) {
        if (a % 2 == 0)
            System.out.println("Even");
        else {
            System.out.println("Odd");
        }
    }
    void isPrime(int n)
    {
        // Corner case
        boolean flag = true;
        if (n <= 1)
            //return false;
            //System.out.println("Not Prime");
            flag = false;

        // Check from 2 to square root of n
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                //System.out.println("Not Prime");
                flag = false;

        if(flag)
        System.out.println("Prime");
        else
        System.out.println("Not Prime");

    }
    void sqroot(int value) {
        double result = Math.sqrt(value);
        System.out.println(result);

    }

}
