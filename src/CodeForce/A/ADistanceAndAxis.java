package CodeForce.A;/*
 @author Myvin Barboza
 21/08/20 8:30 PM
 */

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ADistanceAndAxis {
    public static void main(String[] args) {
    FastReader fr=new FastReader();
    int t=fr.nextInt();
    while(t--!=0){
        long n=fr.nextInt();
        long k=fr.nextInt();
        if(n==0)
            System.out.println(k);
        else if(k==0 && n%2==0)
            System.out.println(0);
        else if(k==0 && n%2!=0)
            System.out.println(n);
        else System.out.println(Math.abs(n-k));
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
