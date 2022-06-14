package LeetCodeChallenge.JUNE2022;

public class LC14 {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if(strs.length==0) return "";
        int n = strs.length;
        for(int i=0;i<strs[0].length();i++){
            for(String s:strs){
                if(i==s.length() || s.charAt(i)!=strs[0].charAt(i)){
                  return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}
