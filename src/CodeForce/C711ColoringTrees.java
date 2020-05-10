package CodeForce;


import java.io.*;
import java.util.*;


/*
 @author Myvin Barboza
 10/05/20 2:55 PM 
 */
public class C711ColoringTrees {




                /************************ SOLUTION STARTS HERE ***********************/
                        static int N;
                        static int M;
                        static long cost[][];
                        static long memo[][][];
                        static int arr[];
                        static final long INF=(long)1e16;
                static long findOptimum(int indx,int prev,int beauty,int k){
                        if(beauty>k){
                                return INF;
                        }
                        if(indx == N){
                        return k==beauty?0:INF;
                        }
                        else{
                               //
                              if(memo[indx][prev][beauty]!=-1)
                               return memo[indx][prev][beauty];

                              if(arr[indx]!=0){
                                      //dont calculate cost here as we have a fixed element
                                      return memo[indx][prev][beauty] = findOptimum(indx+1,arr[indx],prev==arr[indx]?beauty:beauty+1,k);
                              }
                              else{
                                      long min=INF;
                                      for (int i = 1; i <=M ; i++)
                                      min=Math.min(min,cost[indx][i]+findOptimum(indx+1,i,prev==i?beauty:beauty+1,k));


                                      return memo[indx][prev][beauty]=min;
                              }

                        }


                }

                private static void solve(FastScanner s1, PrintWriter out){
                        N=s1.nextInt();
                        M=s1.nextInt();
                        int k=s1.nextInt();
                        arr=s1.nextIntArray(N);
                        cost=new long[N][M];
                        memo=new long[102][102][102];
                        for (int i = 0; i <102 ; i++) {
                                for (int j = 0; j <102 ; j++) {
                                        Arrays.fill(memo[i][j],-1);
                                }
                        }
                        for (int i = 0; i <N ; i++) {
                                cost[i]=s1.nextLongArrayOneBased(M);
                        }
                        long ans=findOptimum(0,0,0,k);

                        out.println(ans== INF ?-1:ans);

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