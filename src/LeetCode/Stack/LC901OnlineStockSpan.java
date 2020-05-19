package LeetCode.Stack;
/*
 @author Myvin Barboza
 19/05/20 4:05 PM 
 */


import java.util.Stack;

class StockSpanner {
    Stack<Value> stack;
    int i=0;
    class Value{
        int index=0;
        int price=0;

        public Value(int index, int price) {
            this.index = index;
            this.price = price;
        }
    }
    StockSpanner(){
        stack=new Stack<>();
    }

    public int next(int price) {
    i++;
    int j=0;
    while(!stack.isEmpty() && price>=stack.peek().price ){
        stack.pop();
    }

    if(stack.isEmpty())j=i;
    else{
        j=i-stack.peek().index;
    }
    stack.push(new Value(i,price));
    return  j;

    }


}

public class LC901OnlineStockSpan {

}