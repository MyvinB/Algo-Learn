package Company.Amazon;

import java.util.Stack;

/**
 * @author mmichaelbarboza
 * on 9:59 AM 3/22/2022
 * Time Taken:
 */
public class LC155 {

    public static void main(String[] args) {

    }

    class MinStack {
        Stack<Integer> stack;
        int min;
        public MinStack() {
            stack = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int val) {
            if(val<min){
                min = val;
                //value will always be less as
                //val<min
                // val-min<0
                //2val-min<val
                stack.push(2*val-min);
            }
            else stack.push(val);
        }

        public void pop() {
            int val = stack.pop();
            //top = 2*val - prevMin
            //2val - (2*Val -prevMin)
            //prevMin
            //val over here is current min
            if(val<min){
                min = 2 * min - val;
            }


        }

        public int top() {
            if(stack.peek()<min) return min;
            else return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}
