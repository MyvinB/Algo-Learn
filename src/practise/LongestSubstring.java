package practise;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    static void MyvinlengthOfLongestSubstring(String str) {
    int l=str.length();
    String s="";
    String p="";

        for (int i = 0; i < l; i++) {
            if(s.contains(Character.toString(str.charAt(i)))){
                p=p+s+"\0";
               // System.out.println(i+" "+"check");
                int index=s.indexOf(str.charAt(i));
               // System.out.println(index);
                //System.out.println(s.substring(index+1,s.length()));
                s=s.substring(index+1,s.length());



            }
            if(!s.contains(Character.toString(str.charAt(i))))
            s=s+str.charAt(i);
            else{
                p=p+s+"\0";
                s="";
            }
        }
        p=p+s+"\0";
        int count=0;
        int max=0;
        for (int i = 0; i <p.length() ; i++) {
            if(p.charAt(i)=='\0'){
                if(count>max){
                    //System.out.println(count +" "+ i);
                    max=count;
                }
                count=0;
            }
            else
            count++;
        }

       System.out.println(p);
       System.out.println(max);
   
    }

    static void lengthOfLongestSubstring(String s) {
        int n=s.length();
        Map<Character,Integer> map=new HashMap<Character, Integer>();
        int start=0;
        int length=0;
        for (int i = 0; i <n ; i++) {
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                if(map.get(ch)>=start)
                start=map.get(ch)+1;
            }
            length=Math.max(length,i-start+1);
            map.put(ch,i);
        }
        System.out.println(length);
    }

    public static void main(String[] args) {

        String s="abba";
        lengthOfLongestSubstring(s);
        MyvinlengthOfLongestSubstring(s);

    }
}
