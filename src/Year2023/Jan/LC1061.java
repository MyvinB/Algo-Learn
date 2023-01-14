package Year2023.Jan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LC1061 {

    public static void main(String[] args) {

    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        HashMap<Character, List<Character>> map = new HashMap<>();
        int n = s2.length();
        //Building adj list
        for(int i=0;i<n;i++){
            char u = s1.charAt(i);
            char v = s2.charAt(i);
            if(!map.containsKey(u)) map.put(u,new ArrayList<>());
            if(!map.containsKey(v)) map.put(v,new ArrayList<>());
            map.get(u).add(v);
            map.get(v).add(u);
        }
        // System.out.println(map+" "+s1+" "+s2);
        StringBuilder sb = new StringBuilder();
        //Dfs on adj list
        for(int i=0;i<baseStr.length();i++){
            int[] visited = new int[26];
            char ch = dfs(map, baseStr.charAt(i),visited);
            // System.out.println("MIN CHAR "+ch);
            sb.append(ch);
        }
        return sb.toString();
    }

    public char dfs(HashMap<Character,List<Character>> map, Character cur, int[] visited){
        char minChar = cur;
        visited[cur-'a']=1;
        if(!map.containsKey(minChar)) return minChar;
        for(char ch:map.get(cur)){
            if(visited[ch-'a']==1) continue;
            visited[ch-'a']=1;
            minChar = (char) Math.min(minChar,dfs(map,ch,visited));
        }
        return minChar;
    }

}
