package Challenge;
/*
 @author Myvin Barboza
 14/05/20 4:18 PM 
 */

import java.util.*;
import java.io.*;
import java.util.concurrent.ConcurrentHashMap;

public class Placement {

            /************************ SOLUTION STARTS HERE ***********************/
            static String printInLine(HashMap<String,String> map,String s, double multi){
                    if(!map.containsKey(s)) return multi+" "+s;
                    String val[]=map.get(s).split(" ");
                    double val1=Double.parseDouble(val[0]);

                    return printInLine(map,val[1],multi*val1);
            }



            private static void solve(FastScanner s1, PrintWriter out){
                        String s=s1.nextLine();
                        String sArr[]=s.split(",");
                        HashMap<String,String> map = new HashMap<String,String>();
                        HashMap<Double,String> mapChange=new HashMap<>();
                        TreeMap<Double,String> mapOrdered=new TreeMap<>();
                        String lastVal="";
                        double max=Double.MIN_VALUE;
                        for (int i = 0; i <sArr.length-1 ; i++) {
                                    String sKeyValue=s1.nextLine();
                                    String sArr1[]=sKeyValue  .split(" = ");
                                    map.put(sArr1[0],sArr1[1]);
                        }
                      //  System.out.println(map);
                        for(String key:map.keySet()){
                                String val[]=map.get(key).split(" ");
                                String newVal=printInLine(map,val[1],  Double.parseDouble(val[0]));
                              // System.out.println(newVal);
                                String val1[]=newVal.split(" ");
                                lastVal=val1[1];
                                max=Math.max(max,Double.parseDouble(val1[0]));
                                mapChange.put(Double.parseDouble(val1[0]),key);
                        }
//                   System.out.println(max);
                    System.out.println(mapChange);
                        for(double key:mapChange.keySet()){
                                String val=mapChange.get(key);
                                double changedVal=max/key;
                                mapOrdered.put(changedVal,val);
                        }
                    System.out.println(mapOrdered);

                    for (double key:mapOrdered.keySet()){

                            if((long)key==key){


                                System.out.print((long)key+""+mapOrdered.get(key)+" = ");
                            }else {

                                System.out.print(key + "" + mapOrdered.get(key) + " = ");
                            }
                    }
                if((long)max==max){

                    System.out.print((long)max+lastVal);
                }else {
                    System.out.print((long)max+lastVal);
                }







//
//



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