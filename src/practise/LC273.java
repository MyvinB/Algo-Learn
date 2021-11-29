package practise;

/**
 * @author mmichaelbarboza
 * on 7:32 PM 11/29/2021
 */
public class LC273 {

    public static void main(String[] args) {
        System.out.println(numberToWords(12345));
    }
    private final static String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final static String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final static String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};


    public static String numberToWords(int num) {
        if(num==0) return "Zero";
        int i=0;
        String words ="";
        while(num!=0){
            if(num%1000!=0){
                words = helper(num%1000) + THOUSANDS[i] +" "+words;
            }
            i++;
            num = num/1000;
        }
        return  words.trim();
    }

    public static String helper(int num) {
        if(num==0) return "";
        if(num<20) return LESS_THAN_20[num] +" ";
        if(num<100) return TENS[num/10] +" "+ helper(num%10);
        return LESS_THAN_20[num/100] +" Hundred " + helper(num%100);
    }


}
