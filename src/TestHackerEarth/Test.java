package TestHackerEarth;

/*
 @author Myvin Barboza
 21/03/20 1:14 PM 
 */public class Test {

     static int calc(String s){
         //1101001101
         int not=0;
         int count=0;
         int max=0;
         boolean check=true;
         for (int i = 0; i <s.length() ;) {
             //if(!check&&s.charAt(i)=='0')check=true;

             if(i<s.length()-1&&s.charAt(i)=='0'&&s.charAt(i+1)=='0'){
               //  check=false;
                   while(i<s.length()&&s.charAt(i)=='0')i++;
                    if(i==s.length())return max;
                   count=0;
             }
             count++;
              i++;
             if(count>max)max=count;

         }
            return max;

         }


    public static void main(String[] args) {
//    String s="0011";
//    int not=0;
//    int count=0;
//    int max=Integer.MIN_VALUE;
//        for (int i = 0; i < s.length() ; i++) {
//            count++;
//            if(s.charAt(i)=='0')++not;
//            if(s.charAt(i)=='1')not=0;
//            if(not==2){
//                count=count-2;
//                not=0;
//                if(count>max)max=count;
//            }
//
//        }
//        if(max==Integer.MIN_VALUE)
//        System.out.println(s.length());else System.out.println(max);
        System.out.println( calc("1100011010"));
    }
}