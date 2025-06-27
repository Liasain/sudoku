import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ParserTest {

    Board b;
    Parser p;

    @BeforeEach
    void setUp() {
        b = new Board();
        p = new Parser();
    }

    @Test
    @DisplayName("Board is empty")
    void parseEmpty() {
        p.parse("", b);
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                assertEquals(0, b.get(i, j));
            }
        }
    }

    @Test
    @DisplayName("Row is 123456789")
    void parseRow() {
        p.parse("123456789", b);
        for (int i = 1; i <= 9; i++) {
            assertEquals(i, b.get(1, i));
        }
    }

    @Test
    @DisplayName("Row is 1.......9")
    void parseRowDefault() {
        p.parse("1abcdefg9", b);
        assertEquals(1, b.get(1, 1));
        assertEquals(9, b.get(1, 9));
        for (int i = 2; i <= 8; i++) {
            assertEquals(0, b.get(1, i));
        }
    }

    @Test
    @DisplayName("Row is 12")
    void parseRowIgnoreNewline() {
        p.parse("1\n2", b);
        assertEquals(1, b.get(1, 1));
        assertEquals(2, b.get(1, 2));
    }

    @Test
    @DisplayName("Board is full, overflow ignored")
    void parseAllIgnoreOverflow() {
        String input = "123456789" +
                "123456789" +
                "123456789" +
                "123456789" +
                "123456789" +
                "123456789" +
                "123456789" +
                "123456789" +
                "123456789" +
                "111111111";
        p.parse(input, b);
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                assertEquals(j, b.get(i, j));
            }
        }
    }
}