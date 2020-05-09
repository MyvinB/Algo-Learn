package LeetCode.Math;

/*
 @author Myvin Barboza
 03/04/20 9:59 AM 
 */public class HappyNumberLC202 {

    static boolean isHappy(int n) {
        int a=recurnum(n);
        if(a==1)
        return true;
        else return false;

    }

    static int recurnum(int n){
        System.out.println(n);
        if(n==1)return n;
        if(n==4) return 0;
        int a;
        int sum=0;

        while(n!=0){
            a=n%10;
            n=n/10;
            sum=sum+a*a;
        }
        return recurnum(sum);
    }



    public static void main(String[] args) {
        System.out.println(isHappy(4));
    }

 }