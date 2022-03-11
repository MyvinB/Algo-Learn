package Company.Amazon;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author mmichaelbarboza
 * on 10:41 AM 3/11/2022
 * Time Taken:
 */
public class LC937 {

    public static void main(String[] args) {
        String s = "dig1 8 1 5 1";
        System.out.println(Arrays.toString(s.split(" ",2)));

        Arrays.sort(a);
    }

    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] a = o1.split(" ",2);
                String[] b = o2.split(" ",2);
                if(a[1].charAt(0)<= '9'){
                    if(b[1].charAt(0)<='9') return 0;
                    else return 1;
                }
                if(b[1].charAt(0)<='9') return -1;
                int cmp = a[1].compareTo(b[1]);
                if(cmp == 0) cmp = a[0].compareTo(b[0]);
                return cmp;
            }
        };
        Arrays.sort(logs,comparator);
        return logs;
    }


}
