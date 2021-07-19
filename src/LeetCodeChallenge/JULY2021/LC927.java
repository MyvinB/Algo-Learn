package LeetCodeChallenge.JULY2021;

public class LC927 {

    public static void main(String[] args) {
        int[] test = new int[]{1,0,1,0,1};
        threeEqualParts(test);
    }

    public static int[] threeEqualParts(int[] arr) {
        int noOf1s = 0;
        int[] ans = new int[]{-1, 1};
        for (int i : arr) {
            if (i == 1) noOf1s++;
        }
        if (noOf1s == 0) {
            return new int[]{0, 2};
        }

        if (noOf1s % 3 != 0) {
            return ans;
        }

        int noOf1sInEachPart = noOf1s / 3;
        int zeroIndex = -1;
        int oneIndex = -1;
        int twoIndex = -1;
        noOf1s = 0;
        //Getting starting pointers of each index
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 1) {
                noOf1s++;
                System.out.println(noOf1s);
                if (noOf1s == 1) {
                    zeroIndex = i;
                } else if (noOf1s == noOf1sInEachPart + 1) {
                    oneIndex = i;
                } else if (noOf1s == 2 * noOf1sInEachPart + 1) {
                    twoIndex = i;
                }
            }
        }
        System.out.println("new line");


        while (twoIndex < arr.length) {
            System.out.println(zeroIndex+" "+oneIndex+" "+twoIndex);
            if (arr[zeroIndex] == arr[oneIndex] && arr[oneIndex] == arr[twoIndex]) {
                zeroIndex++;
                oneIndex++;
                twoIndex++;
            }
            else return ans;
        }
        System.out.println(zeroIndex-1);
        System.out.println(oneIndex);

        //since it is incrementing one of everyhthing before breaking out of the loop
        return new int[]{zeroIndex -1,oneIndex};

    }
}
