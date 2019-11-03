import java.util.Arrays;
//https://www.youtube.com/watch?v=GTJr8OvyEVQ for refernce KMP algo thought well
public class KMPString {
    static int[] calcArray(char[] a){
        int ar[]=new int[a.length];
        int j=0;
        for (int i = 1; i <a.length ;) {
            if(a[i]==a[j]){
                j++;
                ar[i]=j;
                i++;
            }
            else{
                if(j!=0){
                    j=ar[j-1];
                }
                else{
                    i++;
                }
            }
        }
        return ar;
    }

    static boolean isPresent(char []a,char []b,int []br){
        int i=0,j=0;
        while(i<a.length){

            if(a[i]==b[j]){
                i++;
                j++;
            }else{
                if(j!=0){
                    j=br[j-1];
                }
                else i++;
            }
            if(j==b.length){
                return true;
            }

        }
        return false;
    }
    public static void main(String[] args) {
        /*sample string to check calcArray aabaabaaa should give [0, 1, 0, 1, 2, 3, 4, 5, 2] */
        /*Example s="abxabcabcaby" tofind="abcaby" */
        String s="pandalives";
        String tofind="panda";

        char a[]=s.toCharArray();
        char b[]=tofind.toCharArray();
        int br[]=calcArray(b);
        System.out.println(isPresent(a,b,br));

    }
}
