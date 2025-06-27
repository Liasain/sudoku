public class Solver {

    public void solve(Board board, Validator validator) {
        solve(board, validator, 1, 1);
    }

    private boolean solve(Board board, Validator validator, int row0, int col0) {
        for (int row = row0; row <= 9; row++) {
            for (int col = col0; col <= 9; col++) {
                int value = board.get(row, col);
                if (value != 0) continue; // cell not empty, move on

                for (int guess = 1; guess <= 9; guess++) {
                    board.set(row, col, guess);
                    if (!validator.validate(board)) {
                        board.set(row, col, 0); // cleanup
                        continue; // bad guess, guess again
                    }

                    if (row == 9 && col == 9) return true; // board full, return success

                    int nextRow = col == 9 ? row + 1 : row;
                    int nextCol = col == 9 ? 1 : col + 1;
                    boolean ok = solve(board, validator, nextRow, nextCol);
                    if (ok) return true; // board solved, return success

                    board.set(row, col, 0); // cleanup
                }
                return false;
            }
            col0 = 1;
        }

        return validator.validate(board);
//        throw new RuntimeException("Logic error");
    }
}
