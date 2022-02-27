package LeetCodeChallenge.Feb2022;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mmichaelbarboza
 * on 5:54 PM 2/25/2022
 * Time Taken:
 */
public class LC165 {

    public static void main(String[] args) {
        compareVersion("1.01","1.001");
    }

    public static int compareVersion(String s1, String s2) {
       int temp1 = 0;
       int temp2 = 0;
       int n1 = s1.length();
       int n2 = s2.length();
       int i=0,j=0;

       while(i<n1 || j<n2){
           temp1 = 0;
           temp2 = 0;
           while(i<n1 && s1.charAt(i) != '.'){
               temp1 = temp1*10 + s1.charAt(i++)-'0';
           }
           while(j<n2 && s2.charAt(j) != '.'){
               temp2 = temp2*10 + s2.charAt(j++)-'0';
           }
           if(temp1<temp2) return -1;
           else if(temp1>temp2) return 1;
           else {
               //Getting rid of the point
               i++;
               j++;
           }
       }
       return 0;
    }
}
