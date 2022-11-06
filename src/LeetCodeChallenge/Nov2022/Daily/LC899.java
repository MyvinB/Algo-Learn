package LeetCodeChallenge.Nov2022.Daily;

import java.util.Arrays;

public class LC899 {

    public static void main(String[] args) {
        System.out.println(orderlyQueue("bacdb",1));
    }

    public static String orderlyQueue(String s, int k) {
        if(k>1){
            //This is exactly like bubble sort assuming we have more then 2 then we can swap value so just return sorted string
            char[] sCh = s.toCharArray();
            Arrays.sort(sCh);
            return String.valueOf(sCh);
        }
        String res = s;
        for(int i=1;i<s.length();i++){
            String temp = s.substring(i)+s.substring(0,i);
            if(res.compareTo(temp)>0) res = temp;
        }
        return res;
    }
}
