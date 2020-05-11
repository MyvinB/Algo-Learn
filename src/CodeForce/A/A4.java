package CodeForce.A;

import java.util.Scanner;

/*
 @author Myvin Barboza
 09/05/20 9:40 AM 
 */public class A4 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

            if(n>2 && n%2==0) System.out.println("YES");
            else System.out.println("NO");
    }
}