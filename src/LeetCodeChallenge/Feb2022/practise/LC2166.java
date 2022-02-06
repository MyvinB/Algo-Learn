package LeetCodeChallenge.Feb2022.practise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mmichaelbarboza
 * on 12:34 AM 2/7/2022
 * Time Taken:
 */
public class LC2166 {

    public static void main(String[] args) {
        Set<Integer> one = new HashSet<>();
        System.out.println(one.remove(1));
    }

    class Bitset {
        int size;
        Set<Integer> one;
        Set<Integer> zero;
        public Bitset(int size) {
            this.size=size;
            one = new HashSet<>();
            zero = new HashSet<>();
            for(int i=0;i<size;i++){
                zero.add(i);
            }
        }

        public void fix(int idx) {
           one.add(idx);
           zero.remove(idx);
        }

        public void unfix(int idx) {
            zero.add(idx);
            one.remove(idx);
        }

        public void flip() {
          Set<Integer> temp = one;
          one = zero;
          zero = temp;
        }

        public boolean all() {
            return one.size()==size;
        }

        public boolean one() {
          return one.size()>1;
        }

        public int count() {
            return one.size();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<size;i++){
                if(one.contains(i)){
                    sb.append("1");
                }else if(zero.contains(i)){
                    sb.append("0");
                }
            }
            return sb.toString();
        }
    }
}
