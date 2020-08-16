package CodeForce.B;/*
 @author Myvin Barboza
 16/08/20 9:59 AM 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class B1326 {


    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int b[] = new int[n];
        for (int i = 0; i <n ; i++) {
            b[i] = sc.nextInt();
        }
        System.out.print(b[0]+" ");
        int max=b[0];
        for(int i=1;i<n;i++){
            b[i]+=max;
            max=Math.max(b[i],max);
            System.out.print(b[i]+" ");
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
