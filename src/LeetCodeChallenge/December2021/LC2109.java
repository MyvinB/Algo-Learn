package LeetCodeChallenge.December2021;

/**
 * @author mmichaelbarboza
 * on 7:03 PM 12/19/2021
 */
public class LC2109 {
    public static void main(String[] args) {
        String s= "LeetcodeHelpsMeLearn";
        int[] spaces = {8,13,15};
        System.out.println(addSpaces(s,spaces));
    }

    public static String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(int i=0;i<s.length();i++){
            if( idx<spaces.length && i == spaces[idx]){
                sb.append(" ");
                idx++;
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
