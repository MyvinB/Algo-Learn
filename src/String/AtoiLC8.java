package String;

public class AtoiLC8 {
	
	static int myAtoi(String str) {
	        str=str.trim();
	        int i=0,r=0,sign=1;
	        if(str.length()==0)return 0;
	        else if(str.charAt(i)=='-'){i++; sign=-1;}
	        else if(str.charAt(i)=='+'){i++; }
	        while(i<str.length()&&Character.isDigit(str.charAt(i))){
	        	int d=str.charAt(i)-'0';
	        	
	        	if(r>(Integer.MAX_VALUE-d)/10) return sign>0? Integer.MAX_VALUE:Integer.MIN_VALUE;
	        	r=r*10+d;
	        	
	        	i++;
	        }
	        return r*sign;
	
	
	
	}
	
	
public static void main(String[] args) {
	System.out.println(myAtoi("4193 with words"));
	System.out.println(myAtoi("4193 with words"));
	System.out.println(myAtoi("4193 with words"));
}
}
