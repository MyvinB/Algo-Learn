package LeetCode.Math;/*
 @author Myvin Barboza
 26/07/20 12:36 PM 
 */

public class LC258AddDigits {

    public static void main(String[] args) {

    }

    public int addDigits(int num) {
        if(num<10)
            return num;
        int n=num;
        int res=0;
        while(n!=0){
            res+=n%10;
            n=n/10;
        }
        return addDigits(res);
    }

}
