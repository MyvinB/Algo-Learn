package TopicWise2022.DP.MergeIntervals;

public class LC96UniqueBinarySearchTrees {

    public static void main(String[] args) {

    }

    //Concept of Catelan Numbers apply here
    public int numTrees(int n) {
        int T[] = new int[n+1];
        T[0] = 1;//C0 = 1
        T[1] = 1; //one has only one possible way
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                T[i] = T[j] + T[i-j-1];
            }
        }
        return T[n];
    }
}
