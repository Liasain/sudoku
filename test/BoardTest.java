import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BoardTest {

    Board b;

    @BeforeEach
    void setUp() {
        b = new Board();
    }

    @Test
    @DisplayName("All cells 0")
    void sanity() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                assertEquals(0, b.get(i, j));
            }
        }
    }

    @Test
    @DisplayName("Set cells to 1 to 9")
    void set() {
        for (int i = 1; i <= 9; i++) {
            b.set(3, 4, i);
            assertEquals(i, b.get(3, 4));
        }
    }

    @Test
    @DisplayName("Set cell to 0")
    void set0() {
        b.set(1, 1, 1);
        assertEquals(1, b.get(1, 1));
        b.set(1, 1, 0);
        assertEquals(0, b.get(1, 1));
    }

    @Test
    @DisplayName("Set cell >9 throws")
    void setExceptionHigh() {
        assertThrows(RuntimeException.class, () -> b.set(1, 2, 10));
    }

    @Test
    @DisplayName("Set cell < 0 throws")
    void setExceptionLow() {
        assertThrows(RuntimeException.class, () -> b.set(1, 2, -1));
    }

    @Test
    @DisplayName("Boards should be equal")
    void equals() {
        Board b2 = new Board();
        b.set(1, 2, 3);
        b2.set(1, 2, 3);
        assertTrue(b.equals(b2));
        assertEquals(b.hashCode(), b2.hashCode());
    }

    @Test
    @DisplayName("Boards should not be equal")
    void notEquals() {
        Board b2 = new Board();
        b.set(1, 2, 3);
        b2.set(1, 2, 4);
        assertFalse(b.equals(b2));
        assertNotEquals(b.hashCode(), b2.hashCode());
    }
}
