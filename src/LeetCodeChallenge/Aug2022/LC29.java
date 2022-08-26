package LeetCodeChallenge.Aug2022;

public class LC29 {

    public static void main(String[] args) {

    }

    public int divide(int divident, int divisor) {
        if(divident == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean sign = (divident>0)==(divisor>0);
        divident = Math.abs(divident); divisor = Math.abs(divisor);
        int res = 0;
        while(divident-divisor>=0){
            int count = 0;
            while(divident-(divisor<<1<<count)>=0) count++;
            res += 1<<count;
            divident = divident-(divisor<<count);
        }
        return sign?res:-res;
    }
}
