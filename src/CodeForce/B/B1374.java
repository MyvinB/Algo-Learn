package CodeForce.B;/*
 @author Myvin Barboza
 03/07/20 7:13 AM 
 */

import java.util.Scanner;

public class B1374 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();
        while(t--!=0){
            int n=sc.nextInt();
            int count2=0;
            int count3=0;
            boolean flag=true;
            while(n!=1){
                if(n%2==0){
                    count2++;
                    n=n/2;
                }
                else if(n%3==0){
                    count3++;
                    n=n/3;
                }
                else {
                    System.out.println("-1");
                    flag=false;
                    break;
                };
            }

            if(!flag) continue;
            else if(count2>count3 ) System.out.println("-1");
            else System.out.println((count3-count2)*2+count2);
        }
    }


}
