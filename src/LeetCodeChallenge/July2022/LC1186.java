package LeetCodeChallenge.July2022;

public class LC1186 {

    public static void main(String[] args) {
        int t[] = new int[]{-7,6,1,2,1,4,-1};
        System.out.println(maximumSum(t));
    }

    public static int maximumSum(int[] arr) {
        int n = arr.length;
        if(n==0) return 0;
        if(n==1) return arr[0];
        int res = Integer.MIN_VALUE;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 0;
        //preSum of just subarray just working like kadane
        for(int i=1;i<n;i++){
            //automatic presum calculation happening here also the part where preSum is less than zero is handled by taking the element it seldf
            left[i] = Math.max(arr[i],left[i-1]+arr[i]);
            res = Math.max(left[i],res);
        }
        right[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(arr[i],right[i+1]+arr[i]);
        }
        //Considering exlusions ie deleting elements
        for(int i=1;i<n-1;i++){
            res = Math.max(res,left[i-1]+right[i+1]);
        }
        return res;
    }
}
