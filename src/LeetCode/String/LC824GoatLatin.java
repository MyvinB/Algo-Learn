package LeetCode.String;/*
 @author Myvin Barboza
 19/08/20 1:01 PM 
 */

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LC824GoatLatin {


    public String toGoatLatin(String S) {
        String ar[]=S.split(" ");
        Set<Character> set= Stream.of('a','e','i','o','u','A','E','I','O','U').collect(Collectors.toSet());
        StringBuilder sb=new StringBuilder();
        StringBuilder res=new StringBuilder();
        for(int i=0;i<ar.length;i++){
            sb.append(ar[i]);
            if(!set.contains(ar[i].charAt(0))){
                sb.deleteCharAt(sb.length() - ar[i].length());
                sb.append(ar[i].charAt(0));
            }

            sb.append("ma");
            for(int j=0;j<=i;j++){
                sb.append("a");
            }
            res.append(sb);
            if(i+1!=ar.length){
                res.append(" ");
            }
            sb.setLength(0);
        }
        return res.toString();
    }
}
