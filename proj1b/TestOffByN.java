import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    CharacterComparator offBy0 = new OffByN(0);
    CharacterComparator offBy1 = new OffByN(1);
    CharacterComparator offBy5 = new OffByN(5);

    @Test
    public void testEqualCharsBy0() {
        assertFalse(offBy0.equalChars('a','b'));
        assertTrue(offBy0.equalChars('a','a'));
    }
    public void testEqualCharsBy1() {
        assertTrue(offBy1.equalChars('a','b'));
        assertFalse(offBy1.equalChars('a','a'));
    }
    public void testEqualCharsBy5() {
        assertTrue(offBy5.equalChars('a','f'));
        assertFalse(offBy5.equalChars('a','b'));
    }
}
