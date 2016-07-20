import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by XINLAI on 7/16/16.
 */
public class PinningTests {

    ////////////////////////////////////////////////////////////////
    //////////////////////////1: Test Convert to int////////////////
    ////////////////////////////////////////////////////////////////

    @Test
    public void testConvertToIntZero() { //test when input is 0
        try {
            MainPanel m = new MainPanel(16);
            int n = m.convertToInt(0);
            assertEquals(0, n);
        }catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testConvertToIntNormal() { //test when input is 6
        try {
            MainPanel m = new MainPanel(28);
            int n = m.convertToInt(6);
            assertEquals(6, n);
        }catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testConvertToIntMax() { //test when input is max integer
        try {
            MainPanel m = new MainPanel(16);
            int n = m.convertToInt(Integer.MAX_VALUE);
            assertEquals(Integer.MAX_VALUE, n);
        }catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testConvertToIntMin() { //test when input is min integer
        try {
            MainPanel m = new MainPanel(36);
            int n = m.convertToInt(Integer.MIN_VALUE);
            assertEquals(Integer.MIN_VALUE, n);
        }catch (Exception e) {
            fail();
        }
    }

    ////////////////////////////////////////////////////////////////
    //////////////////////////2: Test CellToString//////////////////
    ////////////////////////////////////////////////////////////////

    @Test
    public void testCellToStringLive() { //test an alive cell should convert to "X"
        Cell c = new Cell();
        c.setAlive(true);
        assertEquals(c.toString(),"X");
    }

    @Test
    public void testCellToStringDead() { //test a dead cell should convert to "."
        Cell c = new Cell();
        c.setAlive(false);
        assertEquals(c.toString(),".");
    }

    @Test
    public void testCellToStringDefault() { //test a default cell should convert to "."
        Cell c = new Cell();
        assertEquals(c.toString(),".");
    }

    ////////////////////////////////////////////////////////////////
    //////////////////////////3: Test RunContinuous/////////////////
    ////////////////////////////////////////////////////////////////

    //Manual test see the paperwork

}
