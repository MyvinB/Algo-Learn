package CodeForce.A;
/*
 @author Myvin Barboza
 21/08/20 1:57 PM 
 */

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A1399 {

    public static void main(String[] args) {
        FastReader fr=new FastReader();
        int t=fr.nextInt();
        while(t--!=0){
            int n=fr.nextInt();
            int ar[]=new int[n];
            for(int i=0;i<n;i++)
                ar[i]=fr.nextInt();
            Arrays.sort(ar);
            boolean flag=true;
            for(int i=1;i<n;i++){
                if(ar[i]-ar[i-1]>1){
                    flag=false;
                }
            }
            if(flag)
            System.out.println("YES");
            else System.out.println("NO");
        }
    }



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
}
