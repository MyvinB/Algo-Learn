package Year2023.Feb;

public class LC6 {

    public static void main(String[] args) {

    }

    public String convert(String s, int numRows) {
        if(numRows<=1) return s;
        int diff= 0;
        int cur=0;
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++) rows[i] = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            rows[cur].append(s.charAt(i));
            if(cur==numRows-1) diff=-1;
            else if(cur==0) diff=+1;
            cur +=diff;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder t:rows){
            res.append(t.toString());
        }
        return res.toString();
    }
}
