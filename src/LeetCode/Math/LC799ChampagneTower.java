package LeetCode.Math;

public class LC799ChampagneTower {
    public static void main(String[] args) {

    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] M = new double[101][101];
        M[0][0] = poured;
        for (int r = 0; r <= query_row; r++) {
            for (int c = 0; c <= r; c++) {
                double excess = (M[r][c] - 1) / 2;
                if (excess > 0) {
                    M[r + 1][c] += excess;
                    M[r + 1][c + 1] += excess;
                }
            }
        }
        //enteries filled are fot the next level so either take minimum 1 or lower than that
        return Math.min(1, M[query_row][query_glass]);

    }
}
