package practise;

public class LC374 {
    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is lower than the guess number
     *			      1 if num is higher than the guess number
     *               otherwise return 0
     * int guess(int num);
     */
    int guess(int n){

        return 9;

    }

    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        int mid=0;
        while(low<=high){
            mid = low +(high-low)/2;
            int val = guess(mid);
            System.out.println(mid+""+val);
            if(val<0)high=mid-1;
            else if(val>0)low=mid+1;
            else if(val==0)break;
        }
        return mid;

    }
}
