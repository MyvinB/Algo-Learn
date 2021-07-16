package LeetCodeChallenge.JULY2021;

public class LC791 {

    public static void main(String[] args) {
        customSortString("cba", "abcd");
    }
    //If there is another way do not use .contains it is expensive.
    public static String customSortString(String order, String str) {
        StringBuilder sb = new StringBuilder();
        int[] ar = new int[26];
        for (int i = 0; i < str.length(); i++) {
            ar[str.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < order.length(); i++) {
            char cur = order.charAt(i);
            while (ar[cur - 'a'] > 0) {
                sb.append(cur);
                ar[cur - 'a']--;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            while (ar[cur - 'a'] > 0) {
                sb.append(cur);
                ar[cur - 'a']--;
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
