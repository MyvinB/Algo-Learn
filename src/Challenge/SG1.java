package Challenge;/*
 @author Myvin Barboza
 10/10/20 4:47 PM 
 */

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class SG1 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(in), 32768);
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return parseInt(next());
        }

        long nextLong() {
            return parseLong(next());
        }

        double nextDouble() {
            return parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String[] args) {
        FastReader sc=new FastReader();
        int t=sc.nextInt();
        while(t--!=0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            String s=sc.nextLine();
            String p=sc.nextLine();
            int a[]=new int[26];
            for(int i=0;i<s.length();i++){
                a[s.charAt(i)-'a']++;
            }
            boolean flag=false;
            for(int i=0;i<p.length();i++){
               if(--a[p.charAt(i)-'a']<0)flag=true;
            }
            if(flag) System.out.println(0);
            else System.out.println(1);
        }

    }

}
