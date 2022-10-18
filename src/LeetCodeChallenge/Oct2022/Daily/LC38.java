package LeetCodeChallenge.Oct2022.Daily;

public class LC38 {

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        if(n==1) return "1";
        String prev = countAndSay(n-1);
        StringBuilder res = new StringBuilder();
        int count=1;
        for(int i=1;i<prev.length();i++){
            if(prev.charAt(i)==prev.charAt(i-1)){
                count++;
            }else{
                res.append(count).append(prev.charAt(i-1));
                count=1;
            }
        }
        res.append(count).append(prev.charAt(prev.length()-1));
        return res.toString();
    }

}
