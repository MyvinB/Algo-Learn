package Contest.LeetCode;

/**
 * @author mmichaelbarboza
 * on 9:08 PM 3/19/2022
 * Time Taken:
 */
public class MaximizeNumberOfSubsequencesInAString {
    public static void main(String[] args) {
        //"iekbksdsmuuzwxbpmcngsfkjvpzuknqguzvzik"
        //"mp"
        System.out.println(maximumSubsequenceCount("iekbksdsmuuzwxbpmcngsfkjvpzuknqguzvzik","mp"));
    }
    //mpmp
    //mpmpmp
    ///Wrong answer
    public static long maximumSubsequenceCount(String text, String pattern) {
        int a = pattern.charAt(0)-'a';
        int b = pattern.charAt(1)-'a';
        int aCount = 0;
        int bCount = 0;
        int beforeCount = 0;
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)-'a' == a) aCount++;
            if(text.charAt(i)-'a' == b) bCount++;
            if(text.charAt(i)-'a' == b && aCount!=0 && beforeCount==0) beforeCount++;
        }
        int min = Math.min(aCount,bCount);
        int max  = Math.max(bCount,aCount);
        min = min+1;
        return (min*max)-beforeCount;
    }
}
