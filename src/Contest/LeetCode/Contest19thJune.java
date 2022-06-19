package Contest.LeetCode;

public class Contest19thJune {


    public static void main(String[] args) {
//        String s = "lEeTcOdE";
//        System.out.println(greatestLetter(s));
        System.out.println(minimumNumbers(58,9));

    }

    public static String greatestLetter(String s) {
        int n = s.length();
        int[] l= new int[26];
        int[] u= new int[26];
        for(int i=-0;i<n;i++){
            char cur = s.charAt(i);
            if(Character.isLowerCase(cur)){
                l[cur-'a']++;
            }else if(Character.isUpperCase(cur)) u[cur-'A']++;
        }
        for(int i=25;i>=0;i--){
            if(l[i]>0 && u[i]>0){
                return (char)(i+'A') +"";
            }
        }
        return "";
    }


    public static int minimumNumbers(int num, int k) {
        if(num==0) return 0;
        int total = num;
        int val1=0,val2=0;
        int count = 0;
        int i = 0;
        int m = 10;
        while(true){
            val1 = k+i*m;
            val2 = total -val1;
            if(val1+val2>total) break;
            if(val1%10==k && val2%10==k) count++;
            if(i==9){
                m = m*10;
                i=1;
            }
            i++;

        }
        return count;
    }
}
