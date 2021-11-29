package practise;

import java.util.Arrays;

/**
 * @author mmichaelbarboza
 * on 9:51 AM 11/29/2021
 */
public class LC937 {

    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        System.out.println(Arrays.toString(new LC937().reorderLogFiles(logs)));
    }


    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
         String s1[] = a.split(" ",2);
         String s2[] = b.split(" ",2);
             if(s1[1].charAt(0)<='9'){
                 if(s2[1].charAt(0)<='9') return 0;
                 else return 1;
             }
             if(s2[1].charAt(0)<='9') return -1;
             int cmp = s1[1].compareTo(s2[1]);
             if(cmp==0) return s1[0].compareTo(s2[0]);
             return cmp;
        });
        return logs;

    }
}
