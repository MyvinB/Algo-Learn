package CodeForce.B;
/*
 @author Myvin Barboza
 20/05/20 12:46 PM 
 */

import java.util.Scanner;

public class BeautifulPaintings651 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n= scan.nextInt();
        int count[]=new int[1001];
        int max=-1;
        for (int i = 0; i <n ; i++) {
            max=Math.max(max, ++count[scan.nextInt()]);
        }
        System.out.println(n-max);
    }
}