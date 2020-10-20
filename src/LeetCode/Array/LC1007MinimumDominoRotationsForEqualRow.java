package LeetCode.Array;/*
 @author Myvin Barboza
 20/10/20 11:32 AM 
 */

public class LC1007MinimumDominoRotationsForEqualRow {

    public static void main(String[] args) {

    }

    public int minDominoRotations(int[] A, int[] B) {
        int countA[]=new int[7],countB[]=new int[7],countS[]=new int[7];
        int n=A.length;
        for(int i=0;i<A.length;i++){
            int a=A[i],b=B[i];
            countA[a]++;
            countB[b]++;
            if(a==b)
                countS[a]++;
        }
        for(int i=1;i<7;i++){
            if(countA[i]+countB[i]-countS[i] == n)
                return n - Math.max(countA[i],countB[i]);
        }
        return -1;
    }

}
