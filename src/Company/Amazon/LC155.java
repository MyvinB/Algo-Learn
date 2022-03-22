package Company.Amazon;

import java.util.Stack;

/**
 * @author mmichaelbarboza
 * on 9:59 AM 3/22/2022
 * Time Taken:
 */
public class LC155 {

    public static void main(String[] args) {
        //Can also be done by having the min in stack whenever there is min value

    }

    class MinStack {
        Stack<Long> stack;
        Long min;
        public MinStack() {
            stack = new Stack<>();
            min = Long.MAX_VALUE;
        }

        public void push(int val) {
            Long value = Long.valueOf(val);
            if(val<min){
                //value will always be less as
                //val<min
                // val-min<0
                //2val-min<val
                stack.push(2*value-min);
                min = value;

            }
            else stack.push(value);
        }

        public void pop() {
            if(stack.isEmpty()) return;
            long val = stack.pop();
            //top = 2*val - prevMin
            //2val - (2*Val -prevMin)
            //prevMin
            //val over here is current min
            if(val<min) {
                min = 2 * min - val;
            }
        }

        public int top() {
            if(stack.isEmpty()) return -1;
            if(stack.peek()<min) return min.intValue();
            else return stack.peek().intValue();
        }

        public int getMin() {
            return min.intValue();
        }
    }
}
