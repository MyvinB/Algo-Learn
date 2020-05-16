package Challenge;
/*
 @author Myvin Barboza
 14/05/20 4:18 PM
 */


import java.util.*;
import java.io.*;




public class Placement2 {

    /************************ SOLUTION STARTS HERE ***********************/
     static class Node{
         String name;
         int val=1;
         Node prev;

        public Node(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        Node next;

    }


    private static void solve(FastScanner s1, PrintWriter out){
        int minWhole=Integer.MAX_VALUE;
        int maxWhole=Integer.MIN_VALUE;
        String s=s1.nextLine();
        String sArr[]=s.split(",");
        HashMap<String,Node> map=new HashMap<>();
        for (int i = 0; i <sArr.length ; i++) {
            map.put(sArr[i],new Node(sArr[i]));
        }
        for (int i = 0; i <sArr.length-1 ; i++) {
            String val[]=s1.nextLine().split(" = ");
            String check[]=val[1].split(" ");
            Node node1=map.get(val[0]);
            Node node2=map.get(check[1]);
            int amount=Integer.parseInt(check[0]);
            if(node2.val==1){
                int multi=1;
                if(node1.val!=1){
                    multi=node1.val;
                }
                node2.val=amount*multi;
                node2.prev=node1;
                node1.next=node2;
            }
            else{
                int moduleVal=node2.val;
                int max=Math.max(amount,moduleVal);
                int min=Math.min(amount,moduleVal);
                int div=max/min;
                node2.val=max;

                do{
                    node2=node2.prev;
                }while(node2.val>div);

                if(moduleVal<max){
                    node2.prev=node1;
                    node1.next=node2;
                    node2.val=div;
                }
                else{
                    Node curHold=node2;
                    Node nextHold=node2.next;
                    curHold.next=node1;
                    node1.prev=curHold;
                    node1.next=nextHold;
                    nextHold.prev=node1;
                    node1.val=div;
                }


            }

        }


        for(String key:map.keySet()){
            Node temp=map.get(key);
            if(temp.val==1){
                while(temp!=null){
                    if(temp.next!=null)
                    System.out.print(temp.val+temp.name +" = ");
                    if(temp.next==null)
                        System.out.print(temp.val+temp.name);
                    temp=temp.next;
                }
                System.out.println();
            }

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