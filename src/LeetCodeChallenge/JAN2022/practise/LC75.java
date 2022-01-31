package LeetCodeChallenge.JAN2022.practise;

import java.util.Arrays;

/**
 * @author mmichaelbarboza
 * on 7:13 AM 1/31/2022
 */
public class LC75 {
    public static void main(String[] args) {
        int t[] = new int[]{2,0,2,1,1,0};
        // 0,0,1,1,2,2
        sortColors(t);
        System.out.println(Arrays.toString(t));
    }

    public static void sortColors(int[] A) {
    //Making assumpition that everything to left pointer is zero high is 2 and mid is 1
        int low = 0;
        int high = A.length-1;
        int mid =0;
        while(mid<=high){
            if(A[mid]==0){
               swap(A,low++,mid++);
            }else if(A[mid]==1){
                mid++;
            }
            else{
               swap(A,high--,mid);
            }
        }
        //If the variable after excahnge from high is not one and zero needs to be compared again with low and it moves forward
        //if its 1 it will increment
        
    }

    private static void swap(int[] A,int i,int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
