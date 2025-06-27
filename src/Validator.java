import java.util.Arrays;

public final class Validator {

    public boolean validate(Board board) {
        int[] temp = new int[10];

        // Row validation
        for (int i = 1; i <= 9; i++) {
            Arrays.fill(temp, 0);
            for (int j = 1; j <= 9; j++) {
                int value = board.get(i, j);
                temp[value]++;
            }
            for (int k = 1; k <= 9; k++) {
                if (temp[k] > 1) return false;
            }
        }

        // Column validation
        for (int i = 1; i <= 9; i++) {
            Arrays.fill(temp, 0);
            for (int j = 1; j <= 9; j++) {
                int value = board.get(j, i);
                temp[value]++;
            }
            for (int k = 1; k <= 9; k++) {
                if (temp[k] > 1) return false;
            }
        }

        // Box validation
        for (int box = 0; box < 9; box++) {
            int rowOffset = box % 3;
            int colOffset = box / 3;
            Arrays.fill(temp, 0);
            for (int row = 1; row <= 3; row++) {
                for (int col = 1; col <= 3; col++) {
                    int value = board.get(row + rowOffset * 3, col + colOffset * 3);
                    temp[value]++;
                }
            }
            for (int k = 1; k <= 9; k++) {
                if (temp[k] > 1) return false;
            }
        }

        return true;
    }
}
