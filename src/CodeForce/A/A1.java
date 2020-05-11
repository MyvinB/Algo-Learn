package CodeForce.A;

import java.util.Scanner;

/*
 @author Myvin Barboza
 09/05/20 12:25 PM 
 */public class A1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double n=sc.nextDouble();
        double m=sc.nextDouble();
        double a=sc.nextDouble();
       // System.out.println(Math.ceil(m/a));
        double product=Math.ceil(m/a)*Math.ceil(n/a);
        System.out.println((long)product);
    }
}