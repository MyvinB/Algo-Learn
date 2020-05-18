package LeetCode.String;
/*
 @author Myvin Barboza
 18/05/20 5:08 PM 
 */

import java.util.ArrayList;
import java.util.List;

public class LC93RestoreIPAddresses {

    static List<String> restoreIpAddresses(String s) {
        List<String> list=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        //starting from 1to3 as 256 length is 3
        for (int a = 1; a <4 ; a++)
            for(int b=1;b<4;b++)
                for(int c=1;c<4;c++)
                    for (int d=1;d<4;d++){
                        //if cumulative length = length of the string we founf an ip possibility
                        if(a+b+c+d==s.length()){
                         int A=Integer.parseInt(s.substring(0,a)) ;
                         int B=Integer.parseInt(s.substring(a,a+b));
                         int C=Integer.parseInt(s.substring(a+b,a+b+c));
                         int D=Integer.parseInt(s.substring(a+b+c));
                         //checking the basic rules of it
                         if( A <=255 && B<=255 && C<=255 && D<=255 ){
                             sb.append(A).append(".").append(B).append(".").append(C).append(".").append(D);
                            if(sb.length()==s.length()+3)
                             list.add(sb.toString());
                             sb.delete(0,sb.length());
                         }
                        }
                    }
        return list;
    }


    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("0000"));
    }
}