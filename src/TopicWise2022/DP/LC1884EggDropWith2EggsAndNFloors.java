package TopicWise2022.DP;

import java.util.Arrays;

public class LC1884EggDropWith2EggsAndNFloors {

    public static void main(String[] args) {
        System.out.println(twoEggDrop(6));
    }

    //Have to implement binary search to solve this problem and pass TLE
    public static int twoEggDrop(int n) {
        int e = 2;
        int T[][] = new int[e+1][n+1];

        for(int i=0;i<=n;i++){
            T[1][i] = i;
        }
        for(int i=2;i<=e;i++){
            for(int j=1;j<=n;j++){
                if(i>j) T[i][j] = T[i-1][j];
                else {
                    //Initially zero that would always trump
                    T[i][j] = Integer.MAX_VALUE;
                    for(int k=1;k<=j;k++){
                        //remaing floor from k below with one less egg
                        int eggBreak = T[i-1][k-1];
                        //remaining floors from k above egg remains the same as it did not break
                        int eggNoBreak = T[i][j-k];
                        //plus 1 for trial
                        int kthBreakPossibility = 1+ Math.max(eggNoBreak,eggBreak);
                        //since we are finding the maximum
                        T[i][j] = Math.min(T[i][j],kthBreakPossibility);
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(T));
        return T[e][n];

    }
}
