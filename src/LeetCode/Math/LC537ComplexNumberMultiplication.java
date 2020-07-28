package LeetCode.Math;/*
 @author Myvin Barboza
 28/07/20 9:27 AM 
 */

import java.util.stream.Stream;

public class LC537ComplexNumberMultiplication {

    public static void main(String[] args) {
        String a="1+1i";
        String b="1-1i";

    }
    public String complexNumberMultiply(String a, String b) {
        int coeff[]= Stream.of((a+b).split("\\+|i")).mapToInt(Integer::parseInt).toArray();
        //(a+bi ) * (c+di)=(ac-bd)+(ad+bc)i
        return coeff[0]*coeff[2]-coeff[1]*coeff[3]+"+"+(coeff[0]*coeff[3]+coeff[1]*coeff[2])+"i";
    }

}
