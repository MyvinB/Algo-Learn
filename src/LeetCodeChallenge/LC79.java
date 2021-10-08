package LeetCodeChallenge;

public class LC79 {

    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfsHelper(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfsHelper(char[][] board, String word, int x, int y, int indexWord) {
        if (word.length() == indexWord) return true;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(indexWord)) {
            return false;
        }

        boolean ret;
        board[x][y] = '$';

        ret = dfsHelper(board, word, x + 1, y, indexWord + 1) || dfsHelper(board, word, x - 1, y, indexWord + 1) || dfsHelper(board, word, x, y + 1, indexWord + 1) || dfsHelper(board, word, x, y - 1, indexWord + 1);


        board[x][y] = word.charAt(indexWord);
        return ret;
    }
}
