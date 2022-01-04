package LeetCodeChallenge.JAN2022;

/**
 * @author mmichaelbarboza
 * on 7:16 AM 1/4/2022
 */
public class LC1009 {

    public static void main(String[] args) {
        System.out.println(bitwiseComplement(0));
    }

    public static int bitwiseComplement(int n) {
        int i=0;
        int result =0;
        do{
            if((n&1)==0){
                result += 1<<i;
            }
            i++;
            n=n>>1;
        }while(n!=0);
        return result;
    }
}
