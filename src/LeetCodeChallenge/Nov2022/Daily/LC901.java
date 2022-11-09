package LeetCodeChallenge.Nov2022.Daily;

import java.util.Stack;

public class LC901 {

    public static void main(String[] args) {

    }

    class StockSpanner {
        Stack<int[]> stack;
        public StockSpanner() {
            stack = new Stack<>();
        }

        public int next(int price) {
            int res = 1;
            while(!stack.isEmpty() && stack.peek()[0]<=price){
                res+=stack.pop()[1];
            }
            stack.push(new int[]{price,res});
            return res;
        }
    }
}
