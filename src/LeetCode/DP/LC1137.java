package LeetCode.DP;

/**
 * @author mmichaelbarboza
 * on 4:50 AM 12/16/2021
 */
public class LC1137 {

    public static void main(String[] args) {

    }

    public int tribonacci(int n) {
        if(n<2) return n;
        int a=0,b=1,c=1;
        while(n-->2){
            int d = a+b+c;
            a = b;
            b = c;
            c=d;
        }
        return c;
    }
}
