package Array;/*
 @author Myvin Barboza
 3/16/2020 5:21 PM
 */

import java.util.Arrays;

class CustomStack {
    int ar[];
    int i=0;
    public CustomStack(int maxSize) {
        ar=new int[maxSize];
    }

    public void push(int x) {
        if (i != ar.length) {
            ar[i] = x;
            i++;
        }
        else System.out.println("Don't add another elements as size is "+ar.length);
    }

    public int pop() {
        if(i==0) return -1;

        return ar[--i];
    }

    public void increment(int k, int val) {
        System.out.println(Arrays.toString(ar));
        for (int i=0;i<ar.length && i<k;i++){
            ar[i]=ar[i]+val;
        }
        System.out.println(Arrays.toString(ar));
    }
}

public class CustomStackLC1381 {




    public static  void main(String[] args) {
    CustomStack stack=new CustomStack(3);
    stack.push(1);
    stack.push(2);
    System.out.println(stack.pop());
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.increment(5,100);
    }
}
