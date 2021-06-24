package Challenge;/*
 @author Myvin Barboza
 09/08/20 5:51 PM 
 */


public class De {
    public static void main(String[] args) throws Exception {
//        int a[]={4,3,5,6,4,7,6,8,3,9};
//        int count=1;
//        int minHeight=a[0];
//        for(int i=1;i<a.length;i++){
//            if(a[i]>minHeight){
//                count++;
//                minHeight=a[i];
//            }
//        }
//        System.out.println(count);
        //print perfect squares

//        for(int i=1;i<25;i++){
//            if(Math.sqrt(i)==(int)Math.sqrt(i)){
//                System.out.println(i);
//            }
//        }


//        String s="ankita";
//        int a[]=new int[256];
//        for(int i=0;i<s.length();i++){
//            a[s.charAt(i)]++;
//        }
//        StringBuilder sb=new StringBuilder();
//        for(int i=0;i<a.length;i++){
//            if(a[i]!=0)sb.append((char)i).append(a[i]);
//        }
//        System.out.println(sb.toString());
        int count=1;
        int n=4;
//        for(int i=0;i<2*n-1;i++){
//            for(int j=0;j<Math.abs(n-1-i);j++) System.out.print(" ");
//            for(int j=0; j<2*(4-Math.abs(4-1-i))-1; j++) System.out.print(count++);;
//            System.out.println();
//        }

        for(int i=0;i<2*n-1;i++){
            for(int j=0;j<2*n-1;j++)
                System.out.print(1 + Math.max( Math.abs(n-i-1),Math.abs(n-j-1) ));
            System.out.println(" ");
        }


    }





    enum Barcode{
        a,b,c,d,e;
    }

}
