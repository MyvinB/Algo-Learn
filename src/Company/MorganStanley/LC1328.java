package Company.MorganStanley;

/**
 * @author mmichaelbarboza
 * on 11:09 AM 2/23/2022
 * Time Taken:
 */
public class LC1328 {

    public static void main(String[] args) {
        System.out.println(breakPalindrome("aa"));
    }

    public static String breakPalindrome(String palindrome) {
        if(palindrome.length()<=1) return "";
        char toFind = 'a' ;
        int index =0;
        for(int i=0;i<palindrome.length();i++){
            if(palindrome.charAt(i) != 'a'){
                index = i;
                toFind = palindrome.charAt(i);
                break;
            }
        }
        System.out.println(toFind);
        if(toFind == 'a'){
            toFind = (char)(toFind+1);
            index = palindrome.length()-1;
        }else{
            toFind = (char)(toFind-1);
        }
        return palindrome.substring(0,index)+toFind+palindrome.substring(index+1) ;
    }
}
