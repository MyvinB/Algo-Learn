package Challenge;/*
 @author Myvin Barboza
 24/06/20 4:31 PM 
 */

import java.util.Scanner;

public class DigitalRootAndIterations {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long t=sc.nextLong();

        while(t--!=0){
            long num=sc.nextLong();

            int count=0;
            while(num>=10){
                long num1=num;
                long sum=0;
                while(num1!=0) {
                    sum += num1 % 10;
                    num1 = num1/ 10;
                }
                count++;
                num=sum;
            }
            System.out.print(num+" "+count);



        }

    }


}
