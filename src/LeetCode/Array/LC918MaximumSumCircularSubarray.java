package LeetCode.Array;
/*
 @author Myvin Barboza
 15/05/20 4:35 PM 
 */

public class LC918MaximumSumCircularSubarray {


    static int maxSubarraySumCircular(int[] A) {
        int n=A.length;
        int minTillHere=A[0];
        int minInTotal=A[0];
        int maxTillHere=A[0];
        int maxInTotal=A[0];
        int totalSum=A[0];

        for (int i = 1; i <n ; i++) {
            maxTillHere=Math.max(A[i],maxTillHere+A[i]);
            maxInTotal=Math.max(maxInTotal,maxTillHere);
            minTillHere=Math.min(A[i],minTillHere+A[i]);
            minInTotal=Math.min(minInTotal,minTillHere);
            totalSum+=A[i];
        }

        if(totalSum==minInTotal) return maxInTotal;
        return Math.max(totalSum-minInTotal,maxInTotal);
    }

    public static void main(String[] args) {
    int a[]= {5,-3,5};

        System.out.println(maxSubarraySumCircular(a));
    }

}


