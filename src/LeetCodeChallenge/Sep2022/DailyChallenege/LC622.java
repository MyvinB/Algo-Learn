package LeetCodeChallenge.Sep2022.DailyChallenege;

public class LC622 {

    public static void main(String[] args) {

    }
    //Design Using Array
    class MyCircularQueueArray {
        int[] a;
        int front = 0,rear =-1,len = 0;
        public MyCircularQueueArray(int k) {
            a  = new int[k];
        }
        public boolean enQueue(int value) {
            if(!isFull()){
                rear = (rear+1)%a.length;
                a[++rear]=value;
                len++;
                return true;
            }
            return false;
        }
        public boolean deQueue() {
            if(!isEmpty()){
                front = (front+1)%a.length;
                len--;
                return true;
            }
            return false;
        }
        public int Front() {
            return !isEmpty()?a[front]:-1;
        }
        public int Rear() {
            return !isEmpty()?a[rear]:-1;
        }
        public boolean isEmpty() {
            return len==0;
        }
        public boolean isFull() {
            return len == a.length;
        }
    }
}
