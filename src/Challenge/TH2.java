package Challenge;/*
 @author Myvin Barboza
 01/08/20 5:16 PM 
 */

import java.util.Arrays;

public class TH2 {

    public static void main(String[] args) {
        int ar[][]=new int[8][8];
        for(int i=1;i<8;i++){
            for(int j=1;j<8;j++){
                ar[i][j]=i&j;
            }
        }
        for(int i=0;i<8;i++){
                System.out.println(Arrays.toString(ar[i]));
        }
    }

}
