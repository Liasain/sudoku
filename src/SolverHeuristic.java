public class SolverHeuristic implements Solver {

    @Override
    public void solve(Board board, Validator validator) {
        solveInner(board, validator);
    }

    private boolean solveInner(Board board, Validator validator) {
        for (int row = bestRow(board); row != 0; row = bestRow(board)) {
            for (int col = 1; col <= 9; col++) {
                if (board.get(row, col) != 0) continue;
                for (int guess = 1; guess <= 9; guess++) {
                    board.set(row, col, guess);
                    if (!validator.validate(board)) {
                        board.set(row, col, 0);
                        continue;
                    }

                    boolean ok = solveInner(board, validator);
                    if (ok) return true;

                    board.set(row, col, 0);
                }
                return false;
            }
        }
        return validator.validate(board);
    }

    private int bestRow(Board board) {
        int result = 0;
        int max = -1;
        for (int row = 1; row <= 9; row++) {
            int count = 0;
            for (int col = 1; col <= 9; col++) {
                if (board.get(row, col) == 0) continue;
                count++;
            }
            if (9 <= count || count <= max) continue;
            result = row;
            max = count;
        }
        return result;
    }

}
