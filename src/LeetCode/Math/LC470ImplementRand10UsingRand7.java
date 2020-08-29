package LeetCode.Math;

public class LC470ImplementRand10UsingRand7 {
    /**
     * The rand7() API is already defined in the parent class SolBase.
     * public int rand7();
     *
     * @return a random integer in the range 1 to 7
     */
    static int rand7(){
        return 0;
    }
    public int rand10(){
        int rand40 = 40;
        while (rand40 >= 40) {
            rand40 = 7*(rand7()-1)+rand7()-1;
        }
        return rand40 % 10 + 1;
    }
    public static void main(String[] args) {

    }
}
