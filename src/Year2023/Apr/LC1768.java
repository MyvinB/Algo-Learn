package Year2023.Apr;

public class LC1768 {

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abcd","pq"));
    }

    public static String mergeAlternately(String word1, String word2) {
        int i=0,j=0;
        int max = Math.min(word1.length(),word2.length());
        StringBuilder sb =new StringBuilder();
        while(i<max && j<max){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
            i++;
            j++;
        }
        while(i<word1.length()){
            sb.append(word1.charAt(i++));
        }
        while(j<word2.length()){
            sb.append(word2.charAt(j++));
        }
        return sb.toString();
    }
}
