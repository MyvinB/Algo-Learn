package practise;
/*You are given two positive numbers practise.A and B. You need to find the maximum valued integer X such that:

X divides practise.A i.e. practise.A % X = 0
X and B are co-prime i.e. gcd(X, B) = 1
For example,

practise.A = 30
B = 12
We return
X = 5
 */

public class LargestCoprimeDivisor {
    static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }

     public static void main(String[] args) {

       int n=30;
       int m=12;
       int r=gcd(m,n);
     while(gcd(m,n)!=1){
         n=n/gcd(m,n);
     }
         System.out.println(n);

    }
}
