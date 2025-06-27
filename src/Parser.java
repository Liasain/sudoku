public class Parser {

    public void parse(String input, Board board) {
        input = input.replaceAll("\n", "");
        int row = 1;
        int col = 1;
        for (int i = 0; i < input.length(); i++) {
            int value = input.charAt(i) - '0';
            if (1 <= value && value <= 9) {
                board.set(row, col, value);
            }
            col++;
            if (col > 9) {
                col = 1;
                row++;
            }
            if (row > 9) {
                break;
            }
        }
    }
}
