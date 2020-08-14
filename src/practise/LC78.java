package practise;/*
 @author Myvin Barboza
 14/08/20 11:45 AM 
 */

import java.util.ArrayList;
import java.util.List;

public class LC78 {

    static public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        generate(nums,new ArrayList<>(),list,0);
        return list;
    }


    static void generate(int[] nums, List<Integer> temp,List<List<Integer>> list,int start){
        list.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++){
            temp.add(nums[i]);
            generate(nums,temp,list,i+1);
            temp.remove(temp.size()-1);
        }

    }

    public static void main(String[] args) {
        int a[]={1,2,3};
        System.out.println(subsets(a));
    }
}
