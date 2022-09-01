package LeetCodeChallenge.Sep2022.GP;

public class LC151ReverseWordsInAString {

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String s) {
        char[] a = s.toCharArray();
        //Reverse whole string
        reverse(a,0,a.length-1);
        //Reverse each word
        reverseWord(a,a.length);
        //trim spaces
        return cleanSpaces(a,a.length);
    }
    //
    public static void reverse(char[] a,int i,int j){
        while(i<j){
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }

    public static void reverseWord(char[] a,int n){
        int i = 0,j=0;
        while(i<n){
            while(i<j || i<n && a[i]==' ')i++;
            while(j<i || j<n && a[j]!=' ')j++;
            reverse(a,i,j-1);
        }
    }

    static String cleanSpaces(char[] a,int n){
        int i=0,j=0;
        while(j<n){
            while(j<n && a[j]==' ')j++;
            while(j<n && a[j]!=' ')a[i++] = a[j++];
            while(j<n && a[j]==' ')j++;
            if(j<n) a[i++] = ' ';
        }
        return new String(a).substring(0,i);
    }
}
