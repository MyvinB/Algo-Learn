package CodeForce.A;/*
 @author Myvin Barboza
 01/07/20 5:52 PM 
 */

import java.util.Arrays;
import java.util.Scanner;

public class A405GravityFlip {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for (int i = 0; i <n ; i++) {
            a[i]=sc.nextInt();
        }
        Arrays.sort(a);
        for (int i = 0; i <n ; i++) {
            System.out.print(a[i]+" ");
        }
    }

}
