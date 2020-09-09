package LeetCode.String;

public class LC165CompareVersionNumbers {
    public static void main(String[] args) {

    }

    public int compareVersion(String version1, String version2) {
        String s1[]=version1.split("\\.");
        String s2[]=version2.split("\\.");
        int len=Math.max(s1.length,s2.length);

        for(int i=0;i<len;i++){
            Integer a=i<s1.length?Integer.parseInt(s1[i]):0;
            Integer b=i<s2.length?Integer.parseInt(s2[i]):0;
            Integer val=a.compareTo(b);

            if(val!=0) return val;
        }

        return 0;
    }
}
