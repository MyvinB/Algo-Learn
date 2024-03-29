package practise;

import java.util.Arrays;
import java.util.HashMap;

public class LC1 {

    public static int[] twoSum(int[] a, int target) {
        int low=0,high=a.length-1;
        int [] copy=Arrays.copyOf(a, a.length);
        int res[] =new int[2];
        Arrays.sort(copy);
        while(low<high){
            if(copy[low]+copy[high]==target) break;
            else if(copy[low]+copy[high]>target)high--;
            else low++;
        }
        for(int i=0;i<a.length;i++){
            if(a[i]==copy[low])res[1]=i;
        }
        for(int i=a.length-1;i>=0;i--){
            if(a[i]==copy[high])res[0]=i;
        }
        return res;
    }


    public static int[] twoSumHashMap(int[] a, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++){
            if(map.containsKey(target-a[i])){
                return new int[]{map.get(target-a[i]),i};
            }
            map.put(a[i],i);
        }
        return new int[]{-1,-1};
    }


    public static void main(String[] args) {
         int a[] = new int[]{2,7,11,15}; //target = 9
         int b[]= new int[]{3,3};//target = 6;
        System.out.println(Arrays.toString(twoSum(b,6)));
    }


}
