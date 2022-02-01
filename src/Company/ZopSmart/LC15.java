package Company.ZopSmart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mmichaelbarboza
 * on 10:25 AM 2/1/2022
 * Time Taken:00 : 24 : 02
 */
public class LC15 {

    public static void main(String[] args) {
        int[] t = new int[]{-2,0,1,1,2};
        System.out.println(threeSum(t));
    }

    public static List<List<Integer>> threeSum(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        List<List<Integer>> res = new ArrayList<>();
        //a pointer
        for(int i=0;i+2<n;i++){
            if(i>0 && A[i]==A[i-1]){
                continue;
            }
            int target = -A[i];
            int low = i+1;
            int high = n-1;
            while(low<high){
                if(A[low]+A[high]==target){
                    res.add(Arrays.asList(A[i],A[low],A[high]));
                    low++;
                    high--;
                    while(low<high && A[low]==A[low-1])low++;
                    while(low<high && A[high]==A[high+1])high--;

                }
                else if(A[low]+A[high]<target){
                    low++;
                }
                else high--;
            }
        }
        return res;

    }
}
