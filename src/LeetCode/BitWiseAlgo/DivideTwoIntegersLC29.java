package LeetCode.BitWiseAlgo;

/*
 @author Myvin Barboza
 18/03/20 10:44 AM 
 */public class DivideTwoIntegersLC29 {
///TIME LIMIT EXCEEDED
    static int divide(int dividend, int divisor) {
        int sign=1;
        if(dividend<0||divisor<0){
            if(!(dividend<0&&divisor<0))
                sign=-1;
            dividend=Math.abs(dividend);
            divisor=Math.abs(divisor);

        }

        if(divisor ==1){
            if(dividend==Integer.MIN_VALUE&& sign==1) return Integer.MAX_VALUE;
            if(sign==-1)
            return -dividend;
            return dividend;
        }
        int target=divisor;
        int quo=0;
        for(int i=2;i<=dividend;i++){
            if(i==target){
                quo++;
                target=target+divisor;
            }
        }
        if(sign==-1) return -quo;
        return quo;
    }

    static int bitdivide(int divident,int divisor){
        int sign=1;
        if(divident<=0 &&divisor>=0 ||divident>=0 &&divisor<=0)
        sign=-1;

        int a=Math.abs(divident);
        int b=Math.abs(divisor);
        int res = 0;
        while ((a-b)>=0){
            int x=0;
            while((a-(b<<1<<x))>=0)x++;
            res=res+(1<<x);
            a=a-(b<<x);
        }
        if(divident==Integer.MIN_VALUE && divisor==-1 ) return Integer.MAX_VALUE;

        if(sign==-1)
        return -res;
        return res;
    }



    public static void main(String[] args) {
        //System.out.println(divide(-2147483648,1));
       // System.out.println(Math.abs(-2147483648));
        System.out.println(bitdivide(-2147483648,-1));
        //System.out.println(40-(5<<1<<1));
        //System.out.println(Integer.MAX_VALUE+"  "+Integer.MIN_VALUE);

    }
}