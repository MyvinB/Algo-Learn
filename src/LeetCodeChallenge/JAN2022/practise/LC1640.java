package LeetCodeChallenge.JAN2022.practise;

import java.util.HashMap;

/**
 * @author mmichaelbarboza
 * on 12:57 AM 1/26/2022
 */
public class LC1640 {

    public static void main(String[] args) {
        int[] ar = new int[]{97,80,56,85,60,33,26,23,99,98,19,34,30,66};
        int[][] pieces = new int[][]{{98,19},{23,99},{97,80,56,85,60},{33,26},{34},{30,66}};
        System.out.println(canFormArray(ar,pieces));
    }

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer,int[]> map = new HashMap<>();
        for(int[] piece:pieces){
            map.put(piece[0],piece);
        }
        int i=0;
        while(i<arr.length){
            if(map.containsKey(arr[i])){
                int[] temp = map.get(arr[i]);
                    int j=0;
                    while(j<temp.length && arr[i]==temp[j]){
                        i++;
                        j++;
                    };
                    if(j!=temp.length) return false;

            } else return false;
        }
        return true;
    }
}
