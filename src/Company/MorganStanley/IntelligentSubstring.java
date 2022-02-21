package Company.MorganStanley;

/**
 * @author mmichaelbarboza
 * on 7:52 AM 2/21/2022
 * Time Taken:
 */
public class IntelligentSubstring {
    public static void main(String[] args) {
        String s = "girrafe";
        int k = 2;
        String charValue = "01111001111111111011111111";
        System.out.println(getSpecialSubstring(s,k,charValue));
    }

    public static int getSpecialSubstring(String s,int k,String charValue){
        char[] alp = charValue.toCharArray();
        int start =0, end= 0,maxLength = 0,flippedCount =0;

        while(end<s.length()){
            if(alp[s.charAt(end)-'a']=='1'){
                end++;
            }else{
                if(flippedCount<k){
                    flippedCount++;
                    end++;
                }
                else{
                    while(flippedCount>=k){
                        if(alp[s.charAt(start)-'a'] == '0'){
                            flippedCount--;
                        }
                        start++;
                    }
                }
            }
            maxLength = Math.max(maxLength,end-start);
        }
        return maxLength;
    }
}
