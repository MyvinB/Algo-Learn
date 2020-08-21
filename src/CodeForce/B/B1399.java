package CodeForce.B;/*
 @author Myvin Barboza
 21/08/20 2:19 PM
 */

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class B1399 {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        int t=fr.nextInt();
        while(t--!=0){
            int n=fr.nextInt();
            int ar1[]=new int[n];
            int ar2[]=new int[n];
            int min1=Integer.MAX_VALUE;
            int min2=Integer.MAX_VALUE;
            for (int i = 0; i <n ; i++) {
                ar1[i]=fr.nextInt();
                min1=Math.min(min1,ar1[i]);
            }

            for (int i = 0; i <n ; i++) {
                ar2[i]=fr.nextInt();
                min2=Math.min(min2,ar2[i]);
            }
            long total=0;
            long minus=0;
         //  System.out.println(min1 +" "+min2);
            for(int i=0;i<n;i++){
                if(ar1[i]>min1 && ar2[i]>min2){
                    minus+=Math.min(ar1[i]-min1,ar2[i]-min2);
                }
                if(ar1[i]>min1){
                    total+=ar1[i]-min1;
                }
                if(ar2[i]>min2)
                 total+=ar2[i]-min2;

            }

            System.out.println(total-minus);

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
