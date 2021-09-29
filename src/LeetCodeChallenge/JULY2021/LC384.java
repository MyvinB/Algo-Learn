package LeetCodeChallenge.JULY2021;

import java.util.Random;

public class LC384 {

    class Solution {
        private int[] nums;
        private Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            this.random = new Random();
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return nums;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            int n = nums.length;
            int[] randomAr = nums.clone();

            for (int i = n - 1; i >= 0; i--) {
                int j = random.nextInt(i + 1);
                int temp = randomAr[i];
                randomAr[i] = randomAr[j];
                randomAr[j] = temp;
            }
            return randomAr;
        }
    }
}
