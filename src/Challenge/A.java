package Challenge;
/*
 @author Myvin Barboza
 21/05/20 4:08 PM 
 */



import java.util.*;
 import java.io.*;

public class A {

            /************************ SOLUTION STARTS HERE ***********************/


                    private static void solve(FastScanner s1, PrintWriter out) {
                            int n = s1.nextInt();
                            int m = s1.nextInt();
                            Set<String> po = new HashSet<>();
                            Set<String> en = new HashSet<>();
                            Set<String> Commonset = new HashSet<>();
                            int t = 0;
                            while (t < n) {
                                    po.add(s1.nextLine());
                                    t++;
                            }
                            t = 0;
                            while (t < m) {
                                    en.add(s1.nextLine());
                                    t++;
                            }
                            for (String s : po) {
                                    if (en.contains(s)) {
                                            Commonset.add(s);
                                    }
                            }
                            int s=Commonset.size();
                            n=n-s;
                            m=m-s;
                           if(s%2==0){
                                   System.out.println(n>m?"YES":"NO");
                           }
                           else System.out.println(n>=m?"YES":"NO");
                    }

                    /************************ SOLUTION ENDS HERE ************************/





                    /************************ TEMPLATE STARTS HERE *********************/

                    public static void main(String []args) throws IOException {
                            FastScanner in  = new FastScanner(System.in);
                            PrintWriter out =
                                    new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)), false);
                            solve(in, out);
                            in.close();
                            out.close();
                    }

                    static class FastScanner{
                            BufferedReader reader;
                            StringTokenizer st;
                            FastScanner(InputStream stream){reader=new BufferedReader(new InputStreamReader(stream));st=null;}
                            String next()
                            {while(st == null || !st.hasMoreTokens()){try{String line = reader.readLine();if(line == null){return null;}
                                    st = new StringTokenizer(line);}catch (Exception e){throw new RuntimeException();}}return st.nextToken();}
                            String nextLine()  {String s=null;try{s=reader.readLine();}catch(IOException e){e.printStackTrace();}return s;}
                            int    nextInt()   {return Integer.parseInt(next());}
                            long   nextLong()  {return Long.parseLong(next());}
                            double nextDouble(){return Double.parseDouble(next());}
                            char   nextChar()  {return next().charAt(0);}
                            int[]  nextIntArray(int n)         {int[] arr= new int[n];   int i=0;while(i<n){arr[i++]=nextInt();}  return arr;}
                            long[] nextLongArray(int n)        {long[]arr= new long[n];  int i=0;while(i<n){arr[i++]=nextLong();} return arr;}
                            int[]  nextIntArrayOneBased(int n) {int[] arr= new int[n+1]; int i=1;while(i<=n){arr[i++]=nextInt();} return arr;}
                            long[] nextLongArrayOneBased(int n){long[]arr= new long[n+1];int i=1;while(i<=n){arr[i++]=nextLong();}return arr;}
                            void   close(){try{reader.close();}catch(IOException e){e.printStackTrace();}}
                    }

                    /************************ TEMPLATE ENDS HERE ************************/
}