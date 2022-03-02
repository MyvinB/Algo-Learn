package practise;

public class StringCount {
    //To count the characters in the string by 0(n) compexity
    public static void main(String[] args) {
        int[] a=new int[255];
        String s="abccdddbbaa";
        for (int i = 0; i <a.length ; i++) {
            a[i]=0;
        }
        for(int i=0;i<s.length();i++){
            a[s.charAt(i)]++;
        }
        for (int i = 0; i <a.length ; i++) {
            if(a[i]!=0){
                System.out.print((char)i+""+a[i]);
            }
        }
    }
}
