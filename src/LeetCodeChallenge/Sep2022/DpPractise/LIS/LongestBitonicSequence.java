package LeetCodeChallenge.Sep2022.DpPractise.LIS;

public class LongestBitonicSequence {

    public static void main(String[] args) {
        int[] t = new int[]{1, 2, 1, 2, 1};
        System.out.println(longestBitonicSequence(t,t.length));
    }

    public static int longestBitonicSequence(int[] arr, int n) {
        // Write your code here.

        int[] dpF = new int[n];
        int[] dpB = new int[n];
        for(int i=0;i<n;i++){
            dpF[i] = 1;
            for(int j=0;j<i;j++){
               if(arr[i]>arr[j]){
                   dpF[i] = Math.max(dpF[i],1+dpF[j]);
               }

            }
        }
        for(int i=n-1;i>=0;i--){
            dpB[i] = 1;
            for(int j=n-1;j>i;j--){
                if(arr[i]>arr[j]){
                    dpB[i] = Math.max(dpB[i],1+dpB[j]);
                }
            }
        }
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(dpF[i]+dpB[i]-1,max);
        }
        return max;
    }
}
