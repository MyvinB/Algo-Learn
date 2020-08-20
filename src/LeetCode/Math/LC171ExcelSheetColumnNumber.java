package LeetCode.Math;/*
 @author Myvin Barboza
 20/08/20 8:44 AM 
 */

public class LC171ExcelSheetColumnNumber {
    public static void main(String[] args) {

    }

    public int titleToNumber(String s) {
        int n=s.length();
        int multi=n-1;
        int count=0;
        for(int i=0;i<n;i++){
            int letterNo=s.charAt(i)-'A'+1;
            count+=letterNo*Math.pow(26,multi);
            //faster way
            //count=count*26+letterNo;
            multi--;
        }


        return count;
    }

}
