package LeetCode.Array;/*
 @author Myvin Barboza
 05/08/20 11:16 AM 
 */

public class LC396RotateFunction {

    //fastest same concept of n time but n space here but still faster no clue
    static int maxRotateFunctionDp(int[] A) {

        if (A == null || A.length == 0) return 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        int[] dp = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            dp[0] += i * A[i];
        }
        int res = dp[0];
        for (int i = 1; i < A.length; i++) {

            dp[i] = dp[i - 1] + sum - (A.length * A[A.length - i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

//naive
    static int maxRotateFunctionONTIME(int[] A) {

        int n=A.length;
        if(n==0)return 0;
        int sum=0;
        int calc=0;
        for(int i=0;i<n;i++){
            sum+=A[i];
            calc+=A[i]*i;
        }
        int max=calc;
        for(int i=1;i<n;i++){
            //formula math
            calc=calc+sum-n*A[n-i];
            System.out.println(calc);
            max=Math.max(calc,max);
        }
        return max;
    }


    static int maxRotateFunction(int[] A) {
        int max=0;
        for(int i=0;i<A.length;i++){
            int sum=0;
            int index=0;
            for(int j=i;j<A.length;j++){
                sum+=A[j]*index;
                index++;
            }
            int start=0;
            System.out.println("half sum"+sum);
            while(start<i){
                sum+=A[start]*index;
                index++;
                start++;
            }
            System.out.println(sum);
            max=Math.max(sum,max);
        }
        return max;
    }


    public static void main(String[] args) {
        int a[]={4,3,2,6};
        System.out.println(maxRotateFunction(a));
    }

}
