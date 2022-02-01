package LeetCodeChallenge.JAN2022.practise;

import java.util.Arrays;

/**
 * @author mmichaelbarboza
 * on 8:08 AM 1/31/2022
 */
public class GFGFindMissingAndRepeating {

    public static void main(String[] args) {
        int[] t = new int[]{4,3,6,2,1,1};
        System.out.println(Arrays.toString(findTwoElement(t,6)));
    }


    //Expect an overflow and use BigInteger or else this will not pass testcases
    static int[]  findTwoElement(int A[], int n) {
        // code here
        //total sum on n
        long sumN = (n*(n+1))/2;
        long sumNSq = (n*(n+1)*(2*n+1))/6;
        long sum1= 0;
        long sum2= 0;
        for(int i=0;i<n;i++){
            sum1 += A[i];
            sum2 += Math.pow(A[i],2);
        }
        long res1 = sumN-sum1;
        long res2 = sumNSq-sum2;
        res2 = res2/res1;
        long x = (res1+res2)/2;
        long y = res2 - x;
        for(int i=0;i<n;i++){
            if(A[i]==x){
                return new int[]{(int)x,(int)y};
            }
        }
        return new int[]{(int)y,(int)x};
    }





}
