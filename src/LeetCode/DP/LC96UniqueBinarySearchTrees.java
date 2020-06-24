package LeetCode.DP;/*
 @author Myvin Barboza
 24/06/20 3:59 PM
 help :https://www.youtube.com/watch?v=YDf982Lb84o
 Tushar roy
 */

import java.util.Arrays;

public class LC96UniqueBinarySearchTrees {

    //dp
    static int numTrees(int n) {

        int T[]=new int[n+1];
        T[0]=1;
        T[1]=1;
        //Cartesian prodic
        for(int i=2;i<=n;i++){
            for (int j = 0; j <i ; j++) {
                T[i]+=T[j]*T[i-j-1];
            }
        }
        //System.out.println(Arrays.toString(T));
        return T[n];
    }


    public static void main(String[] args) {
        System.out.println(numTrees(4));
    }


}
