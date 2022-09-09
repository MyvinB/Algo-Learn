package LeetCodeChallenge.Sep2022.DailyChallenege;

import java.util.Arrays;

public class LC1996 {

    public static void main(String[] args) {
        int[][] t = new int[][]
                {{7,7},{1,2},{9,7},{7,3},{3,10},{9,8},{8,10},{4,3},{1,5},{1,5}};
        System.out.println(numberOfWeakCharacters(t));
    }

    public static int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,(a,b)->{return a[0]==b[0]?(a[1]-b[1]):(b[0]-a[0]);});
//        System.out.println(Arrays.deepToString(properties));
        int weakCount = 0;
        int max = 0;
        for(int[] p:properties){
            if(p[1]<max) weakCount++;
            max = Math.max(max,p[1]);
        }
        return weakCount;
    }
}
