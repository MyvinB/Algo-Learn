package CodeForce.A;/*
 @author Myvin Barboza
 16/08/20 9:15 AM 
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class A1326 {

    public static void main(String[] args) {
        FastReader fr=new FastReader();
        int t=fr.nextInt();
        while(t--!=0){
            int n=fr.nextInt();
            if(n==1) System.out.print(-1);
            else if(n>=2){
                System.out.print("2");
                for(int i=1;i<=n-1;i++){
                    System.out.print("3");
                }
            }
            System.out.println();
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



