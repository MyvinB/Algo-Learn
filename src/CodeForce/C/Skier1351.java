package CodeForce.C;
/*
 @author Myvin Barboza
 11/05/20 11:38 AM 
 */
import java.util.*;
import java.io.*;

public class Skier1351 {
           /************************ SOLUTION STARTS HERE ***********************/
                   private static void solve(FastScanner s1, PrintWriter out){
                        int t=s1.nextInt();
                        while(t--!=0){
                            int time=0;
                         String s=s1.nextLine();
                         Set<String> set=new HashSet<>();
                         int xs=0,ys=0,xe=0,ye=0;
                            for (int i = 0; i <s.length() ; i++) {
                                //done so that start co-orindates get the previous end cordinates
                                xs=xe;
                                ys=ye;
                                if (s.charAt(i) == 'N') {
                                    ye++;
                                } else if (s.charAt(i) == 'S') {
                                    ye--;
                                } else if (s.charAt(i) == 'E') {
                                    xe++;
                                } else if (s.charAt(i) == 'W') {
                                    xe--;
                                }

                                //going one way co ordinates
                                String oneWay = xs + "-" + ys + "-" + xe + "-" + ye;
                                //cordinates of comming back the same way you came end to start
                                String twoWay = xe + "-" + ye + "-" + xs + "-" + ys;

                                if (set.contains(oneWay) || set.contains(twoWay)) {
                                    time=time+1;
                                }
                                else{
                                    time=time+5;
                                    set.add(oneWay);
                                    set.add(twoWay);
                                }

                            }
                            System.out.println(time);
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