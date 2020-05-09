package CodeForce;

import java.util.Scanner;

/*
 @author Myvin Barboza
 09/05/20 3:36 PM 
 */public class A71 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t--!=0){
            String s=sc.next();
            if(s.length()>10){
                System.out.println(String.valueOf(s.charAt(0))+(s.length()-2)+String.valueOf(s.charAt(s.length()-1)));
            }
            else System.out.println(s);

        }
    }
}