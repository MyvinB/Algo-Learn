import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 @author Myvin Barboza
 14/04/20 7:58 PM 
 */public class SubsetsLC78 {

    static List<List<Integer>> subsets(int[] nums) {
     List<List<Integer>> list=new ArrayList<>();
     return recurSub(list,new ArrayList<>(),nums,0);
    }

    static List<List<Integer>> recurSub(List<List<Integer>> list,List temp,int[] nums,int start){
        list.add(new ArrayList<>(temp));
        for (int i = start; i <nums.length ; i++) {
            temp.add(nums[i]);
            recurSub(list,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
        return list;
    }





    public static void main(String[] args) {
        int num[]={1,2,3};
        System.out.println(subsets(num));
    }
}