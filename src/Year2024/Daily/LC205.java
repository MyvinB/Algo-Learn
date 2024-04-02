package Year2024.Daily;

public class LC205 {


    public boolean isIsomorphic(String s, String t) {
        int[] m = new int[256];
        int[] n = new int[256];
        //t.length == s.length given in condition
        for(int i=0;i<s.length();i++){
            if(m[s.charAt(i)]!=n[t.charAt(i)]) return false;
            m[s.charAt(i)]=i+1;
            n[t.charAt(i)]=i+1;
        }
        return true;
    }


}
