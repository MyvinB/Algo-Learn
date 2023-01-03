package Year2023.Jan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LC944 {

    public static void main(String[] args) {
        String[] t = new String[]{"cba","daf","ghi"};
        System.out.println(minDeletionSize(t));
    }


    public static int minDeletionSize(String[] strs) {
        int size = strs[0].length();
        int res = 0;
        for(int col=0;col<size;col++ ){
            Character ch = strs[0].charAt(col);
            for(int i=1;i<strs.length;i++){
                if(strs[i].charAt(col)<ch){
                    res++;
                    break;
                }
                ch = strs[i].charAt(col);
            }

        }
        return res;
    }
}
