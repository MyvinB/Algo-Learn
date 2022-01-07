package LeetCodeChallenge.JAN2022.practise;

/**
 * @author mmichaelbarboza
 * on 8:54 PM 1/7/2022
 */
public class LC2124 {
    public static void main(String[] args) {

    }

    public boolean checkString(String s) {

        int a=0,b=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a' && b==0){
                a++;
            }else if(s.charAt(i)=='b'){
                b++;
            }
            else if(s.charAt(i)=='a'){
                return false;
            }
        }
        return true;
    }
}
