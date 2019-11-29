
/*m : 6
n : 9

GCD(m, n) : 3 */

public class GCD {
    static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }

     public static void main(String[] args) {

       int n=270;
       int m=144;
         System.out.println(gcd(m,n));


    }
}
