import java.util.Arrays;
import java.util.Objects;

public final class Board {
    private final int[][] data = new int[9][9];

    public int get(int row, int col) {
        return data[row - 1][col - 1];
    }

    public void set(int row, int col, int value) {
        if (value < 0 || 9 < value ) {
            throw new RuntimeException("expected 0 <= value <= 9 but was " + value);
        }
        data[row - 1][col - 1] = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.deepEquals(data, board.data);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(data);
    }

    @Override
    public String toString() {
        String result = "Board{\n";
        for (int i = 0; i < data.length; i++) {
            result += Arrays.toString(data[i]) + "\n";
        }
        result += "}";
        return result;
    }
}
