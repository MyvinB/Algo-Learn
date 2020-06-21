package LeetCode.String;/*
 @author Myvin Barboza
 20/06/20 5:32 AM 
 */

import java.util.*;

public class LC1044LongestDuplicateSubstring {

    static String longestDupSubstring(String s) {
        if(s==null ) return "";
        int l=0,r=s.length()-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(rabinKarp(s,mid)!=null) l=mid+1;
            else r=mid-1;
        }
        //r will stay in that index
       return rabinKarp(s,r);

    }


    static String rabinKarp(String str,int len){
        if(len==0) return "";

        HashMap<Long,List<Integer>> map=new HashMap<>();
        //be a prime number to avoid collusion
        long p=(1<<31)-1;
        long multi=1;
        //256 characters
        long base=256;
        long hash=0;
        //getting the hash value of the string
        for(int i=0;i<len;i++){
            hash=(hash*base+str.charAt(i))%p;
        }
        //i=1 starting as 256^0 is 1
        //when we move on to the next character there are the base value in the length of the string
        // b * (256^0) + a * (256^1) + n * (256^2) now we need to move to ana
        //               a * (256^0) + n * (256^1) +a * (256^2) notice the extra 256 that is trailing and needs to be removed
        for(int i=1;i<len;i++){
            multi=(multi*base)%p;
        }
        List<Integer> hashIndex=new ArrayList<>();
        hashIndex.add(0);
        map.put(hash,hashIndex);
        int from=0;
        int to=len;
        while(to<str.length()){
            //removing the first character and adding the last character
            hash=((hash+p-multi*str.charAt(from++)%p)*base+str.charAt(to++))%p;
            hashIndex=map.get(hash);
            if(hashIndex==null){
                hashIndex=new ArrayList<>();
                map.put(hash,hashIndex);
            }
            else {
                ///checking if index in hash matches the new string founf
                for( int j:hashIndex){
                    if(str.substring(from,to).equals(str.substring(j,j+len))){
                        return str.substring(j,j+len);

                    }
                }
            }
            hashIndex.add(from);
        }



        return null;
    }


    public static void main(String[] args) {
        System.out.println(longestDupSubstring("banana"));
    }







}

