    package CodeForce.B;/*
     @author Myvin Barboza
     01/07/20 5:06 PM
     */

    import java.util.Scanner;

    public class B230 {


        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int sieve[]=new int [1000001];
            int n=sc.nextInt();
            long a[]=new long[n];
            for (int i = 0; i <n ; i++) {
                a[i]=sc.nextLong();
            }
            //caculate primes number till n
            //Sieve of Eratosthenes | Fastest Way of Finding Prime Numbers
            //just take the multiples of prime numbers
            for (int i = 2; i <=1000 ; i++) {
                for (int j = i*2; j <=1000000 ; j=j+i) {
                    if(sieve[j]==0)sieve[j]=1;
                }
            }
            // tprime can only be perfect squares and 10^12 gives you a hint
            for (int i = 0; i <n ; i++) {
                double sqrt=Math.sqrt(a[i]);
                if(sqrt==1){
                    System.out.println("NO");
                    continue;
                }

                if((int)sqrt==sqrt && sieve[(int)sqrt]==0){
                    System.out.println("YES");
                }
                else System.out.println("NO");
            }


        }

    }
