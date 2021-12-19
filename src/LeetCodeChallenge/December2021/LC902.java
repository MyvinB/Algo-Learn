package LeetCodeChallenge.December2021;

/**
 * @author mmichaelbarboza
 * on 12:22 PM 12/19/2021
 */
public class LC902 {

    public static void main(String[] args) {
       String digits[] = {"1","3","5","7"};
       String digits1[] = {"3","4","8"};
       String digits2[] = {"5","6"};
       String digits3[] = {"3","5","4"};

       int n= 100;
        System.out.println(atMostNGivenDigitSet(digits3,376));
    }

    public static int atMostNGivenDigitSet(String[] digits, int n) {
        //Calculating the first combinations
        String s = n + "";
        int nLen = s.length();
        int noOfDigits = digits.length;
        int total = 0;
        for(int i=1;i<nLen;i++){
            total += Math.pow(noOfDigits,i);
        }
        //["5","6"]
        //Ans = 19

        for(int i=0;i<nLen;i++){
            boolean hasSame = false;
            for(String str: digits){
                if(str.charAt(0)<s.charAt(i)){
                    total += Math.pow(noOfDigits,nLen-i-1);
                }else if(str.charAt(0) == s.charAt(i)){
                    hasSame = true;
                    if(i ==nLen-1){
                        total++;
                    }
                }
            }

            if(!hasSame)
                return total;
        }
        return total;

    }
}
