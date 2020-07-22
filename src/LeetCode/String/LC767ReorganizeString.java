package LeetCode.String;/*
 @author Myvin Barboza
 22/07/20 4:56 PM 
 */

public class LC767ReorganizeString {

    static String reorganizeString(String s) {
    int hash[]=new int[26];

    for (int i = 0; i <s.length(); i++) {
            hash[s.charAt(i)-'a']++;
    }
    int max=Integer.MIN_VALUE;
    int maxL = 0;
    for(int i=0;i<hash.length;i++){
        if(hash[i]>max){
            max=hash[i];
            maxL=i;
        }
    }
    if(max>(s.length()+1)/2) return "";
    char word[]=new char[s.length()];
    int idx=0;
    while(hash[maxL]>0){
        word[idx]=(char) (maxL+'a');
        idx=idx+2;
        hash[maxL]--;
    }

    for(int i=0;i<hash.length;i++){
        while(hash[i]>0){
            if(idx>=word.length){
                idx=1;
            }
            word[idx]=(char) (i+'a');
            idx+=2;
            hash[i]--;
        }
    }


    return String.valueOf(word);


    }


    public static void main(String[] args) {
        System.out.println(reorganizeString("vvvlo"));
    }



}
