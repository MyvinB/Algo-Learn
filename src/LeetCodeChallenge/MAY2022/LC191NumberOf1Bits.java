package LeetCodeChallenge.MAY2022;

public class LC191NumberOf1Bits {
    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        System.out.println(hammingWeight(n));
    }

    public static int hammingWeight(int n) {
        int count =0;
        while(n!=0){
            if((n&1)==1){
                count++;
            }
            n= n>>1;
        }
        return count;
    }
}
