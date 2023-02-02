package Year2023.Feb;

public class LC953 {

    public static void main(String[] args) {

    }
    int[] ar = new int[26];
    public boolean isAlienSorted(String[] words, String order) {
        for(int i=0;i<26;i++){
            ar[order.charAt(i)-'a'] = i;
        }

        for(int i=0;i<words.length-1;i++){
            if(compare(words[i],words[i+1])>0) return false;
        }
        return true;
    }

    public int compare(String word1,String word2){
        int compare_char = 0;
        int i=0,j=0;
        while(i<word1.length() && j<word2.length() && compare_char==0){
            compare_char = ar[word1.charAt(i)-'a']-ar[word2.charAt(i)-'a'];
            i++;
            j++;
        }
        if(compare_char==0){
            return word1.length()-word2.length();
        }else return compare_char;
    }
}
