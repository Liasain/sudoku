import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SolverTest {

    Board b0;
    Board b1;
    Parser p;
    Validator v;
    Solver s;

    @BeforeEach
    void setUp() {
        b0 = new Board();
        b1 = new Board();
        p = new Parser();
        v = new Validator();
        s = new Solver();
    }

    @Test
    @DisplayName("Solve sudoku 0")
    void solve0() {
        String input = "453826197" +
                "892571634" +
                "167493528" +
                "714952863" +
                "586137249" +
                "329684751" +
                "935218476" +
                "671345982" +
                "248769315";
        p.parse(input, b0);
        p.parse(input, b1);
        assertTrue(v.validate(b0));
        assertEquals(b0, b1);

        for (int i = 1; i <= 9; i++) {
            b1.set(i, i, 0);
        }
        assertTrue(v.validate(b1));
        assertNotEquals(b0, b1);

        s.solve(b1, v);
        assertTrue(v.validate(b1));
        assertEquals(b0, b1);
    }

    @Test
    @DisplayName("Solve sudoku 1")
    void solve1() {
        String s0 = "45......." +
                "..2.7.63." +
                ".......28" +
                "...95...." +
                ".86...2.." +
                ".2.6..75." +
                "......476" +
                ".7..45..." +
                "..8..9...";
        String s1 = "453826197" +
                "892571634" +
                "167493528" +
                "714952863" +
                "586137249" +
                "329684751" +
                "935218476" +
                "671345982" +
                "248769315";
        p.parse(s0, b0);
        p.parse(s1, b1);
        assertTrue(v.validate(b0));
        assertTrue(v.validate(b1));
        assertNotEquals(b0, b1);

        s.solve(b0, v);
        assertTrue(v.validate(b0));
        assertEquals(b0, b1);
    }

    @Test
    @DisplayName("Solve brute force worst case")
    void solve2() {
        String s0 = "........." +
                ".....3.85" +
                "..1.2...." +
                "...5.7..." +
                "..4...1.." +
                ".9......." +
                "5......73" +
                "..2.1...." +
                "....4...9";
        String s1 = "987654321" +
                "246173985" +
                "351928746" +
                "128537694" +
                "634892157" +
                "795461832" +
                "519286473" +
                "472319568" +
                "863745219";
        p.parse(s0, b0);
        p.parse(s1, b1);
        assertTrue(v.validate(b0));
        assertTrue(v.validate(b1));
        assertNotEquals(b0, b1);

        s.solve(b0, v);
        assertTrue(v.validate(b0));
        assertEquals(b0, b1);
    }
}