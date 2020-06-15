package CodeForce.B;
/*
 @author Myvin Barboza
 11/05/20 9:57 AM 
 */



import java.io.*;
import java.util.*;
public class Square1351 {

            /************************ SOLUTION STARTS HERE ***********************/



                    private static void solve(FastScanner s1, PrintWriter out){

                        int t=s1.nextInt();
                        while(t--!=0){
                        int a1=s1.nextInt();
                        int b1=s1.nextInt();
                        int max1=Math.max(a1,b1);
                        int min1=Math.min(a1,b1);

                        int a2=s1.nextInt();
                        int b2=s1.nextInt();
                        int max2=Math.max(a2,b2);
                        int min2=Math.min(a2,b2);



                        if(max1==max2 && max1==min1+min2)
                            System.out.println("YES");
                        else
                            System.out.println("NO");

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