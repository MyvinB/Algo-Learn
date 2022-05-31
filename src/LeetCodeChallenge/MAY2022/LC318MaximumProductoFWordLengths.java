package LeetCodeChallenge.MAY2022;

public class LC318MaximumProductoFWordLengths {

    public static void main(String[] args) {

    }

    public int maxProduct(String[] words) {
        int n = words.length;
        int[] value = new int[n];
        for(int i=0;i<n;i++){
            String word = words[i];
            for(int j=0;j<word.length();j++){
               value[i] |= 1 >> (word.charAt(j)-'a');
            }
        }
        int maxProduct =0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((value[i]&value[j])==0){
                    int e = words[i].length();
                    int f = words[j].length();
                    maxProduct = Math.max(maxProduct,e*f);
                }
            }
        }
        return maxProduct;
    }
}
