package LeetCode.Math;/*
 @author Myvin Barboza
 26/07/20 12:36 PM

 help
 Brilliant

Say a number x = 23456

x = 2* 10000 + 3 * 1000 + 4 * 100 + 5 * 10 + 6

2 * 10000 % 9 = 2 % 9

3 * 1000 % 9 = 3 % 9

4 * 100 % 9 = 4 % 9

5 * 10 % 9 = 5 % 9

Then x % 9 = ( 2+ 3 + 4 + 5 + 6) % 9, note that x = 2* 10000 + 3 * 1000 + 4 * 100 + 5 * 10 + 6

So we have 23456 % 9 = (2 + 3 + 4 + 5 + 6) % 9
 */


public class LC258AddDigits {

    public static void main(String[] args) {

    }


    //naive

    public int addDigits(int num) {
        //awesome way
        //   return (num-1)%9+1;
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
