class Solution {
    public boolean isValidSudoku(char[][] board) {
        var columnSets =
            IntStream.range(0, board.length).mapToObj(i -> new HashSet<Character>()).toList();
        var lineSets =
            IntStream.range(0, board.length).mapToObj(i -> new HashSet<Character>()).toList();
        var squareSets = IntStream.range(0, 9).mapToObj(i -> new HashSet<Character>()).toList();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.')
                    continue;

                if (!lineSets.get(i).add(c))
                    return false;
                if (!columnSets.get(j).add(c))
                    return false;

                int squareNumber = (i / 3) * 3 + (j / 3);
                if (!squareSets.get(squareNumber).add(c))
                    return false;
            }
        }

        return true;
    }
}
