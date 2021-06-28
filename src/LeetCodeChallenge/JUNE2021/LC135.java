package LeetCodeChallenge.JUNE2021;

public class LC135 {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i=1;i<n;i++){
            left[i] = left[i-1]+1;
        }

    }

    public static void main(String[] args) {

    }
}
