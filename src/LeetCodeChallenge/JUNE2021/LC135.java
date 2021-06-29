package LeetCodeChallenge.JUNE2021;

import java.util.Arrays;

public class LC135 {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] distribution = new int[n];
        Arrays.fill(distribution,1);
        for(int i=1;i<n;i++){
            if(ratings[i] >ratings[i-1])
                distribution[i] = distribution[i-1]+1;
        }
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1] && distribution[i] <= distribution[i+1]){
                distribution[i] = distribution[i+1]+1;

            }
        }
        int sum = 0;
        for(int i:distribution){
            sum+=i;
        }
        return sum;

    }

    public static void main(String[] args) {

    }
}
