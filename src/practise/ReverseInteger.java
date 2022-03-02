package practise;

public class ReverseInteger {
    public static void main(String[] args) {
        int a=1534236469;
        long rev=0;
        int max=Integer.MAX_VALUE;
        //System.out.println(max);
        int min=Integer.MIN_VALUE;

        while(a!=0){
            System.out.println(rev);
                rev=rev*10+a%10;
                a=a/10;
        }
        if(rev>max){
            System.out.println("brwk");
            System.exit(0);
        }
        System.out.println(rev);

    }
}
