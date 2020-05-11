package CodeForce.A;
/*
 @author Myvin Barboza
 11/05/20 10:59 AM 
 */

import java.io.*;
import java.util.*;
public class SumOfRoundNumbers1352 {

            /************************ SOLUTION STARTS HERE ***********************/
                    private static void solve(FastScanner s1, PrintWriter out){
                    int t=s1.nextInt();
                        while(t--!=0){
                            int n=s1.nextInt();
                            ArrayList<Integer> list=new ArrayList<>();
                            int i=0;
                            while(n!=0){
                                int r=n%10;
                                if(r!=0){
                                   int store= (int) (r *Math.pow(10,i));
                                   list.add(store);
                                }
                                n=n/10;
                                i++;
                            }
                            Collections.reverse(list);
                            System.out.println(list.size());
                            for(Integer e: list)
                            System.out.print(e+" ");
                            System.out.println();

                        }
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