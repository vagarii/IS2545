import org.junit.Assert;
import org.junit.Test;


public class VisitorTest {

    // --------------------------------------------------------------
    // Visitor number TESTS
    // --------------------------------------------------------------

    //Test that set visitor number equals 1 and it will get number 1.
    @Test
    public void testGetNum1() {
        Visitor v = new Visitor();
        v.setNum(1);
        Assert.assertEquals(1, v.getNum());
    }
    //Test that set visitor number equals 10 and it will get number 0.
    //number[1,5]
    @Test
    public void testGetNum2() {
        Visitor v = new Visitor();
        v.setNum(10);
        Assert.assertEquals(0, v.getNum());
    }
    //Test that set visitor number equals -1 and it will get number 0.
    //number[1,5]
    @Test
    public void testGetNum3() {
        Visitor v = new Visitor();
        v.setNum(-1);
        Assert.assertEquals(0, v.getNum());
    }

    // --------------------------------------------------------------
    // Identify TESTS
    // --------------------------------------------------------------

    //Test that set visitor type which is a Student, it will return
    //Student.
    @Test
    public void testGetIdentify1() {
        Visitor v = new Visitor();
        v.setIdentify("Student");
        Assert.assertEquals("Student", v.getIdentify());
    }
    //Test that set visitor type which is a Blogger, it will return
    //Blogger.
    @Test
    public void testGetIdentify2() {
        Visitor v = new Visitor();
        v.setIdentify("Blogger");
        Assert.assertEquals("Blogger", v.getIdentify());
    }
    //Test that set visitor type which is not including in those four types,
    //it will return null.
    @Test
    public void testGetIdentify3() {
        Visitor v = new Visitor();
        v.setIdentify("Runner");
        Assert.assertEquals(null, v.getIdentify());
    }
}
