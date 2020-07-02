package CodeForce.A;/*
 @author Myvin Barboza
 02/07/20 6:13 PM 
 */

import java.util.Scanner;

public class A1374 {
/*
CONCEPT:
we get a remainder with the number n
Just remove the remainder and add the remainder given to you that is y you will get the number
if the number is greater than n then reduce by one multiple that is x in our case
* */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0){
            int x=sc.nextInt();
            int y=sc.nextInt();
            int n=sc.nextInt();

            if(n-n%x+y<=n){
                System.out.println(n-n%x+y);
            }
            else System.out.println(n-n%x+y -x);
        }
    }


}
