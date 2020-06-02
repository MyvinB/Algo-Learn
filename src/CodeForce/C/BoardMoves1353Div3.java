package CodeForce.C;
/*
 @author Myvin Barboza
 22/05/20 9:42 AM 
 */

import java.util.Scanner;

public class BoardMoves1353Div3 {
    public static void main(String[] args) {
        Scanner s1=new Scanner(System.in);
        int t=s1.nextInt();
        while(t--!=0){
            long n=s1.nextLong();
            int i=1;
            //to find the number of odd elements
            n=(n-1)/2;

            // 1+2^2+3^2+ ... formula
            long res=(n*(n+1)*(2*n+1))/6;
            System.out.println(res*8);

        }
    }
}