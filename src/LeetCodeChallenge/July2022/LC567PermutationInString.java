package LeetCodeChallenge.July2022;

import java.util.HashMap;

public class LC567PermutationInString {

    public static void main(String[] args) {

    }

    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ch = s1.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int start = 0,end = 0,counter = map.size();
        while(end<s2.length()){
            char ch = s2.charAt(end);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0) counter--;
            }
            end++;
            while(counter==0){
                char chS = s2.charAt(start);
                if(map.containsKey(chS)){
                    map.put(chS,map.get(chS)+1);
                    counter++;
                }
                if(end-start==s1.length()){
                    return true;
                }
                start++;
            }
        }
        return false;
    }
}
