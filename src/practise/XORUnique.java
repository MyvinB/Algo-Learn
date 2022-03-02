package practise;/*
 @author Myvin Barboza
 12/05/20 4:07 PM 
 */

public class XORUnique {

    public static void main(String[] args) {
        int nums[]={1,1,2,3,3,4,4};
        int a=nums[0];
        //2^2=0 find unique elements
        for (int i = 1; i <nums.length ; i++) {
            a^=nums[i];
        }
        System.out.println(a);
    }
}