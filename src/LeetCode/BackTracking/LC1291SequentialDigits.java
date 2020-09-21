package LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class LC1291SequentialDigits {

    static List<Integer> sequentialDigitsDp(int low, int high) {

        List<Integer> ans=new ArrayList<>();
        int digmap[] = {12,23,34,45,56,67,78,89,123,234,345,456,567,678,789,1234,2345,3456,4567,5678,6789,
                12345,23456,34567,45678,56789,123456,234567,345678,456789,1234567,2345678,3456789,
                12345678,23456789,123456789};

        for (int i = 0; i <digmap.length ; i++) {
            if(digmap[i]<low)continue;
            if(digmap[i]>high)break;
            ans.add(digmap[i]);
        }
        return ans;

    }






    public static void main(String[] args) {
        sequentialDigitsDp(100,300);
    }
}
