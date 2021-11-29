package practise;

/**
 * @author mmichaelbarboza
 * on 8:42 AM 11/29/2021
 */
public class LC696 {

    public static void main(String[] args) {
        String s = "''[001]''10011";
    }


    public int countBinarySubstrings(String s) {
        int res = 0;
        int prev=0;int current = 1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1)!=s.charAt(i)){
                res += Math.min(prev,current);
                prev = current;
                current = 1;
            }
            else current++;
        }

        return res+Math.min(current,prev);

    }
}
