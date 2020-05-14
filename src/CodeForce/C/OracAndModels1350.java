package CodeForce.C;/*
 @author Myvin Barboza
 13/05/20 10:24 AM 
 */
import java.util.*;
import java.io.*;

public class OracAndModels1350 {



    static int iterativeDP(int a[],int n){
        int dp[]=new int[n+1];
        Arrays.fill(dp,1);
        int ans=1;
        int max=0;

        for (int i = 2; i <=n ; i++) {
            max=0;
            for (int j = 1; j*j <=i ; j++)
                if(i%j==0){
                    int m1=j;
                    int m2=i/j;

                    if(a[m1]<a[i]){
                        max=Math.max(max,dp[m1]);
                    }
                    if(a[m2]<a[i]){
                        max=Math.max(max,dp[m2]);
                    }



                }
            dp[i]=dp[i]+max;

            ans=Math.max(dp[i],ans);

        }
        return ans;
    }


    static int recurDPFun(int index,int n,int a[],int dp[]){

        if(index>n) return 0;
        if(dp[index]!=-1) return dp[index];
        int count=0;
        for (int i = index; i <=n ; i=i+index) {
            if(a[i]>a[index]){
                count=Math.max(count,1+recurDPFun(i,n,a,dp));
            }
        }
        return dp[index]=count;

    }

    static int recur(int n,int a[]){
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        int ans=1;
        for (int i = 1; i <=n; i++) {
            ans=Math.max(ans,1+recurDPFun(i,n,a,dp));
        }
        return ans;
    }

         /************************ SOLUTION STARTS HERE ***********************/
                 private static void solve(FastScanner s1, PrintWriter out){
                     int t=s1.nextInt();
                     while(t--!=0){
                         int n=s1.nextInt();
                         int a[]=s1.nextIntArrayOneBased(n);
                         System.out.println(iterativeDP(a,n));
                         //System.out.println(recur(n,a));


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