package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 2:37 PM 11/24/2021
 */
public class LC986 {

    public static void main(String[] args) {
        int[][] A = {{0,2},{5,10},{13,23},{24,25}};
        int[][] B = {{1,5},{8,12},{15,24},{25,26}};
        int[][] res = intervalIntersection(A,B);
        for(int[] r:res){
            System.out.println(Arrays.toString(r));
        }
    }

    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList();

        for(int i=0, j=0;i<A.length && j<B.length;){
            //if interval do on paper will get it
            if(A[i][1] >= B[j][0] && B[j][1]>=A[i][0]){
                int start = Math.max(A[i][0],B[j][0]);
                int end = Math.min(A[i][1],B[j][1]);
                res.add(new int[]{start,end});
            }
            if(A[i][1]<=B[j][1]){
                i++;
            }
            else j++;
        }
        return res.toArray(new int[0][]);
    }
}
