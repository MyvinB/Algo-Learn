package practise;

import org.w3c.dom.ls.LSOutput;

public class Palindrome {



    public static void main(String[] args) {
      int a=121;
      int temp=a;
      int rev=0;
      while(temp!=0){
          rev=rev*10+temp%10;
          temp=temp/10;
          System.out.println(rev);
      }

    }
}
