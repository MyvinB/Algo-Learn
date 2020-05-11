package CodeForce.B;
/*
 @author Myvin Barboza
 11/05/20 8:35 AM
 Help:https://www.youtube.com/watch?v=-cSd-SwOCxQ
 */

import java.io.*;
import java.util.*;

public class SameParitySummands135 {
            /************************ SOLUTION STARTS HERE ***********************/
                    private static void solve(FastScanner s1, PrintWriter out){
                        int t=s1.nextInt();
                        while(t--!=0){
                            int n=s1.nextInt();
                            int k=s1.nextInt();

                            int div=n/k;
                            int rem=n%k;

                            if(n<k){
                                System.out.println("NO");

                            }
                            else if(rem==0){
                                System.out.println("Yes");
                                for (int i = 1; i <=k ; i++) {
                                    System.out.print(div+" ");
                                }
                                System.out.println();
                            }
                            else if(div%2==0 && (div+rem)%2==0){
                                System.out.println("Yes");
                                for (int i = 1; i <=k-1 ; i++) {
                                    System.out.print(div+" ");
                                };System.out.print(div+rem);
                                System.out.println();
                            }else if(div%2!=0 && (div+rem)%2!=0){
                                System.out.println("Yes");
                                for (int i = 1; i <=k-1 ; i++) {
                                    System.out.print(div+" ");
                                };System.out.print(div+rem);
                                System.out.println();
                            }
                            else if((k-1)%2!=0){
                                System.out.println("NO");
                            }
                            else if(div==1){
                                System.out.println("NO");
                            }
                            else{
                                System.out.println("Yes");
                                for (int i = 1; i <=k/2 ; i++) {
                                    System.out.print((div+1)+" "+(div-1)+" ");
                                }System.out.print(div+rem);
                                System.out.println();

                            }
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