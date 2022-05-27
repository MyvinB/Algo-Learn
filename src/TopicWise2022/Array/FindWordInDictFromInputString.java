package TopicWise2022.Array;

public class FindWordInDictFromInputString {

    public static void main(String[] args) {
        String[] array = {"to", "banana", "toe", "dogs", "ababcd", "elephant"};
        String input = "ogtdes";

        System.out.println(getLargestWordFromDictionary(array, input));
    }

    public static String getLargestWordFromDictionary(String arr[],String s){
        int n = arr.length;
        int[] input = new int[26];
        fillArrayWithCount(s,input);
        int max = 0;
        String word = null;
        for(String a:arr){
            int[] wordInDict = new int[26];
            fillArrayWithCount(a,wordInDict);
            if(canBeMade(input,wordInDict)){
                if(a.length()>max){
                    max = a.length();
                    word =a;
                }
            };
        }
        return word;

    }

    public static void fillArrayWithCount(String s, int word[]){
        int n= s.length();
        for(int i=0;i<n;i++){
            word[s.charAt(i)-'a']++;
        }
    }

     public static boolean canBeMade(int[] input, int[] wordInDict){
        for(int i=0;i<26;i++){
            if(wordInDict[i]==1 && input[i]==0) return false;
            else if(input[i]!=0 && wordInDict[i]!=0) wordInDict[i]--;
        }
        return true;
    }
}
