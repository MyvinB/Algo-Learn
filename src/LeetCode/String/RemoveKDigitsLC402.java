package LeetCode.String;
/*
 @author Myvin Barboza
 13/05/20 4:35 PM 
 */

public class RemoveKDigitsLC402 {

    static String removeKdigits(String num, int k) {
        for (int i = 1; i <=k ; i++) {
           num=removeKdigitsFOR(num,i);
        }
       return num.length()==0?"0":num;


    }

    static String removeKdigitsFOR(String num, int k) {
        StringBuilder sb=new StringBuilder();
        int index=num.length()-1;
       for(int i=0;i<num.length()-1;i++){
           if(num.charAt(i)>num.charAt(i+1)){
               //the index we don't want to include in the substring
               index=i;
               break;
           }
       }

       for(int i=0;i<num.length();i++){
           if(sb.length()==0 && num.charAt(i)=='0' || i==index){
               continue;
           }
           sb.append(num.charAt(i));
       }
        return sb.toString();
    }




    public static void main(String[] args) {
        String s="1432219";
       System.out.println(removeKdigits(s,3));
       // System.out.println(s.substring(2,s.length()));
    }
}