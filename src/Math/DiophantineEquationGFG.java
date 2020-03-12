package Math;/*
 @author Myvin Barboza
 3/12/2020 10:54 AM
 */


public class DiophantineEquationGFG {

    static int gcd(int a,int b){
        return (a%b==0)? b :gcd(b,a%b);
    }

    static boolean isPossible(int a,int b,int c){
        return c%(gcd(a,b))==0;
    }

    public static void main(String[] args) {
        System.out.println(isPossible(3,6,9));

    }
}
