package LeetCode.Math;

/*
 @author Myvin Barboza
 09/05/20 3:17 PM 
 */public class LC367ValidPerfectSquare {

    static boolean isPerfectSquare(int num) {
        if(num==1){
            return true;
        }
       long  left=1;
        long right=num/2;

        while(left<=right){
            long mid=left+(right-left)/2;
            if(mid*mid==num){
                return true;
            }
            if(mid*mid>num)
                right=mid-1;
            else
                left=mid+1;

        }


        return false;
    }


     public static void main(String[] args) {
         System.out.println(isPerfectSquare(808201));
    }
}