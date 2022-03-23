package Company.Amazon;

import java.util.*;

/**
 * @author mmichaelbarboza
 * on 10:46 AM 3/22/2022
 * Time Taken:
 */
public class LC819 {
    public static void main(String[] args) {

    }

    public String mostCommonWord(String paragraph, String[] banned) {
        String[] t = paragraph.replaceAll("\\W+"," ").toLowerCase().split("\\s+");
        HashMap<String,Integer> map = new HashMap<>();
        HashSet<String> ban = new HashSet<String>(Arrays.asList(banned));
        for(String s:t){
            if(!ban.contains(s)) {
                int count = map.getOrDefault(s, 0) + 1;
                map.put(s, count);
            }
        }
        return Collections.max(map.entrySet(),Map.Entry.comparingByValue()).getKey();
    }
}
