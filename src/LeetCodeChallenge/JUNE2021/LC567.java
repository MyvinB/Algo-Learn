package LeetCodeChallenge.JUNE2021;

public class LC567 {

    static int mod = 1000000007;
    static private Long memo[][][] = null;

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        memo = new Long[m][n][maxMove + 1];
        return (int) findPathMemoHelper(m, n, maxMove, startRow, startColumn);
    }

    public static long findPathMemoHelper(int m, int n, int maxMove, int row, int col) {
        if (maxMove < 0) return 0;
        if (row == m || col == n || row < 0 || col < 0)
            return 1;
        if (memo[row][col][maxMove] != null)
            return memo[row][col][maxMove];
        long right = findPathMemoHelper(m, n, maxMove - 1, row, col + 1);
        long left = findPathMemoHelper(m, n, maxMove - 1, row, col - 1);
        long up = findPathMemoHelper(m, n, maxMove - 1, row + 1, col);
        long down = findPathMemoHelper(m, n, maxMove - 1, row - 1, col);
        long total = (up + down + right + left) % mod;
        memo[row][col][maxMove] = total;
        return total;
    }


    public static void main(String[] args) {
        System.out.println(findPaths(2, 2, 2, 0, 0));
    }
}
