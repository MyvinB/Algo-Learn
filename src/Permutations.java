/*Recursion Method to print all the permutations of the string
* HOwever lacks the method to find the rank of the string cause of the complexity involved for a big string*/

import java.util.Arrays;

public class Permutations {
    static String res="";
    static void stringStore(String s){
        res=res+" "+s;

    }
    static void printPermu(String str,String ans){
        if(str.length()==0){
            System.out.print(ans+" ");
            stringStore(ans);
            return;
        }
        for (int i = 0; i <str.length() ; i++) {
            char ch=str.charAt(i);
            String ros=str.substring(0,i)+str.substring(i+1);
            printPermu(ros,ans+ch);
        }
    }


    public static void main(String[] args) {
        String a="DTNGJPURFHYEW";
       printPermu(a,"");
        System.out.println(res);
        String[] s=res.split(" ");
        Arrays.sort(s);
        for (int i = 0; i <s.length ; i++) {
            if(a.equals(s[i])){
                System.out.println(a+"  "+s[i]+" "+i);
                System.out.println(i);
                break;
            }
        }
    }
}
