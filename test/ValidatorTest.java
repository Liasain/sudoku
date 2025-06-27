import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    Board b;
    Validator v;

    @BeforeEach
    void setUp() {
        b = new Board();
        v = new Validator();
    }

    @Test
    @DisplayName("Empty board is valid")
    void validateEmpty() {
        assertTrue(v.validate(b));
    }

    @Test
    @DisplayName("Row repeated cell is invalid")
    void invalidateRow() {
        b.set(1, 1, 1);
        b.set(1, 2, 1);
        assertFalse(v.validate(b));
    }

    @Test
    @DisplayName("Row unique cell is valid")
    void validateRow() {
        b.set(2, 1, 1);
        b.set(2, 2, 2);
        b.set(3, 2, 3);
        assertTrue(v.validate(b));
    }

    @Test
    @DisplayName("Column repeated cell is invalid")
    void invalidateCol() {
        b.set(1, 1, 1);
        b.set(2, 1, 1);
        assertFalse(v.validate(b));
    }

    @Test
    @DisplayName("Column unique cell is valid")
    void validateCol() {
        b.set(1, 1, 1);
        b.set(2, 1, 2);
        assertTrue(v.validate(b));
    }

    @Test
    @DisplayName("Box repeated cell is invalid")
    void invalidateBox() {
        b.set(1, 1, 1);
        b.set(2, 2, 1);
        assertFalse(v.validate(b));
    }

    @Test
    @DisplayName("Box repeated cell is invalid")
    void validateBox() {
        b.set(1, 1, 1);
        b.set(2, 4, 1);
        assertTrue(v.validate(b));
    }
}