package Year2023.Apr;

import java.util.Stack;

public class LC946 {

    public static void main(String[] args) {
        int[] push = new int[]{1,2,3,4,5};
        int[] pop = new int[]{4,5,3,2,1};
        System.out.println(validateStackSequences(push,pop));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j=0;
        for(int i=0;i<pushed.length;i++){
            stack.push(pushed[i]);
            while(!stack.isEmpty() && stack.peek()== popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();

    }
}
