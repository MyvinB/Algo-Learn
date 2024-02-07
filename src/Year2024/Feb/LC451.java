package Year2024.Feb;

import java.util.*;

public class LC451 {

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }

    public static String frequencySort(String s) {
        int[] t= new int[128];
        List<Character> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(t[s.charAt(i)]==0) list.add(s.charAt(i));
            t[s.charAt(i)]++;
        }
        Collections.sort(list,(a,b)->{return t[b]-t[a];});
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<list.size();i++){
            int count = t[list.get(i)];
            while(count--!=0){
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }
}
