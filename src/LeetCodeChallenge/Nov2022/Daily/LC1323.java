package LeetCodeChallenge.Nov2022.Daily;

public class LC1323 {

    public static void main(String[] args) {

    }

    public int maximum69Number (int num) {
        char[] s = String.valueOf(num).toCharArray();
        for(int i=0;i<s.length;i++){
            if(s[i]=='6'){
                s[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(s));
    }
}
