package LeetCodeChallenge.JULY2021;

import java.util.HashMap;

public class LC205 {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Character> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character sChar = s.charAt(i);
            Character tChar = t.charAt(i);
            if (mapS.containsKey(sChar)) {
                if (mapS.get(sChar) != tChar) {
                    return false;
                }
            }
            if (mapT.containsKey(tChar)) {
                if (mapT.get(tChar) != sChar) {
                    return false;
                }
            }
            mapS.put(sChar,tChar);
            mapT.put(tChar,sChar);
        }

        return true;
    }

    public boolean isIsomorphicA(String s, String t) {
    int[] m1 = new int[256];
    int[] m2 = new int[256];
    for(int i=0;i<s.length();i++){
        if(m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
        m1[s.charAt(i)] = i+1;
        m2[t.charAt(i)] = i+1;
    }
    return true;
    }
}
