package LeetCodeChallenge.December2021;

/**
 * @author mmichaelbarboza
 * on 2:48 PM 12/27/2021
 */
public class LC476 {

    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }

    public static int findComplement(int num) {
        //https://www.youtube.com/watch?v=LA1BnKiarEQ
        int i=0;
        int result=0;
        while(num!=0){
            if((num&1)==0){
                result += 1<<i;
            }
            i++;
            num>>=1;
        }
        return result;
    }
}
