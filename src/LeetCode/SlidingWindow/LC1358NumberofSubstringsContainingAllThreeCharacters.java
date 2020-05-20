package LeetCode.SlidingWindow;
/*
 @author Myvin Barboza
 20/05/20 10:18 AM 
 */

public class LC1358NumberofSubstringsContainingAllThreeCharacters {
/*

Sliding WIndow Technique
Think of abc occurring in any order having a count of 1
when i increases abc in any order has also increased by 1 in that particular string
follow the iterations below to understand easily


* i=0> abc 1 res=1
 a=0 b=1 c=1  per=abc
* i=1> abca 1+2 res=3
 a=1 b=0 c=1 perm=abca bca
* i=2> abcab 3+3 res=6
 a=1 b=1 c=0 perm=abcab bcab cab
* i=3 > abcabc 6+4 res=10
 a=1 b=1 c=0 perm abcabc bcabc cabc abc
* abcab abca abcb 3+3
* abcabc 6+4
 total result 4

 aaacb (Condition for while loop )

 count of a is 3
 end of string aaacb
 i=0 a=2 b=1 c=1 res=1
 i=1 a=1 b=1 c=1 res=2
 i=2 a=0 b=1 c=1 res=3
 res=3 end of string

* */
   static int numberOfSubstrings(String s) {
    int count[]={0,0,0} ,res=0,i=0,n=s.length();
       for (int j = 0; j <n ; j++) {
           ++count[s.charAt(j)-'a'];
           while(count[0]>0 && count[1]>0 && count[2]>0){
               --count[s.charAt(i++)-'a'];
           }
           res=res+i;
       }
       return res;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("aaaacb") );
    }
}