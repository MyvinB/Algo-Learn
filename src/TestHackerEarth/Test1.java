package TestHackerEarth;/*
 @author Myvin Barboza
 21/03/20 4:25 PM 
 */

public class Test1 {
    public static void main(String[] args) {
        int a[][] ={{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
       int k =2;
       int no1=0;
       int max1 =Integer.MIN_VALUE;
        for (int n = 0; n <=a.length-k ; n++) {


            for (int l = 0; l <= a.length - k; l++) {
                no1 = 0;

                for (int i = n,q=0; q < k; i++,q++) {
                    for (int j = l,b=0; b < k; j++,b++) {
                        if(a[i][j]==1){
                            no1++;
                        }
                    }

                }

                if (no1 > max1) max1 = no1;

            }
        }
        System.out.println(max1);
    }
}