package Year2023.Feb;

public class LC1071 {
    public static void main(String[] args) {

    }

    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) return "";
        int gcd = getGcd(str1.length(),str2.length());
        return str1.substring(0,gcd);
    }


    public int getGcd(int x,int y){
        if(y==0) return x;
        else return getGcd(y,x%y);
    }

}

