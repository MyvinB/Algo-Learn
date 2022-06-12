package LeetCodeChallenge.JUNE2022;

import java.util.HashMap;

public class LC166 {

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(-1, -2147483648));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        StringBuilder res = new StringBuilder();
        res.append(numerator>0 != denominator>0?"-":"");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        res.append(num/den);
        num %=den;
        if(num==0) return res.toString();
        res.append(".");
        HashMap<Long,Integer> map = new HashMap<>();
        map.put(num,res.length());
        while(num!=0){
            num *=10;
            res.append(num/den);
            num%=den;
            if(map.containsKey(num)){
                int index = map.get(num);
                res.insert(index,'(');
                res.append(')');
                break;
            }else{
                map.put(num,res.length());
            }
        }
        return res.toString();
    }
}
