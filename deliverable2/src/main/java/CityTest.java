import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

public class CityTest {

    @Mock
    Visitor mockedVisitor = Mockito.mock(Visitor.class);
    CitySim9002 mockedCitySim = Mockito.mock(CitySim9002.class);

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(mockedVisitor);
        MockitoAnnotations.initMocks(mockedCitySim);
    }

    @After
    public void tearDown() throws Exception {
    }

    // --------------------------------------------------------------
    // CheckInput TESTS
    // --------------------------------------------------------------

    //Test that an valid integer will return itself if you try to get
    //the first element 1.
    @Test
    public void testCheckInput1() {
        String a = "1";
        CitySim9002 input = new CitySim9002();
        assertEquals(1, input.checkInput(a));
    }
    //the second element 0.
    @Test
    public void testCheckInput2() {
        String a = "0";
        CitySim9002 input = new CitySim9002();
        assertEquals(0, input.checkInput(a));
    }
    //the third element -1 (negative integer).
    @Test
    public void testCheckInput3() {
        String a = "-1";
        CitySim9002 input = new CitySim9002();
        assertEquals(-1, input.checkInput(a));
    }
    //the forth element 1000 (large integer).
    @Test
    public void testCheckInput4() {
        String a = "1000";
        CitySim9002 input = new CitySim9002();
        assertEquals(1000, input.checkInput(a));
    }


/*    //Test that null input will return null.
    @Test
    public void testCheckInteger5() {
        String a = "s";
        CitySim9002 input = new CitySim9002();
        input.checkInput(s);
        fail();
    }

    //Test that more than one integer input will return null.
    @Test
    public void testCheckInteger6() {
        String a = "1 5";
        CitySim9002 input = new CitySim9002();
        input.checkInput(a);
        fail();
    }

*/
    // --------------------------------------------------------------
    // Preferences TESTS
    // --------------------------------------------------------------

    //Test that if visitors preference Left the city and it will return false.
    @Test
    public void testPreferences1() {
        CitySim9002 preference = new CitySim9002();
        assertFalse(preference.preferences(mockedVisitor, "left the city"));
    }

    //Test that visitor type which is a student preferences Cathedral of Learning
    //and it will return false.
    @Test
    public void testPreferences2() {
        CitySim9002 preference = new CitySim9002();
        Visitor a = new Visitor();
        Mockito.when(a.getIdentify()).thenReturn("Student");
        assertFalse(preference.preferences(a, "The Cathedral of Learning"));
    }

    //Test that visitor type which is a student preferences Squirrel Hill
    //and it will return true.
    @Test
    public void testPreferences3() {
        CitySim9002 preference = new CitySim9002();
        Visitor a = new Visitor();
        a.setIdentify("Student");
        assertTrue(preference.preferences(a, "Squirrel Hill"));
    }

    //Test that visitor type which is a Student preferences the location
    //not including in the existing four locations, for example,
    //South Side, and it will return false.
    @Test
    public void testPreferences4() {
        CitySim9002 preference = new CitySim9002();
        Visitor a = new Visitor();
        a.setIdentify("Student");
        assertFalse(preference.preferences(a, "South Side"));
    }

    //Test that visitor type which is a professor preferences
    //Squirrel Hill, and it will return true.
    @Test
    public void testPreferences5() {
        CitySim9002 preference = new CitySim9002();
        Visitor a = new Visitor();
        a.setIdentify("Professor");
        assertTrue(preference.preferences(a, "Squirrel Hill"));
    }

    //Test that visitor type which is a Professor preferences the location
    //not including in the existing four locations, for example,
    //Amc, and it will return false.
    @Test
    public void testPreferences6() {
        CitySim9002 preference = new CitySim9002();
        Visitor a = new Visitor();
        a.setIdentify("Professor");
        assertFalse(preference.preferences(a, "Amc"));
    }

    //Test that visitor type which is a Business Person preferences
    //Downtown, and it will return true.
    @Test
    public void testPreferences7() {
        CitySim9002 preference = new CitySim9002();
        Visitor a = new Visitor();
        a.setIdentify("Business Person");
        assertTrue(preference.preferences(a, "Downtown"));
    }

    //Test that visitor type which is a Business Person preferences
    //The Point, and it will return false.
    @Test
    public void testPreferences8() {
        CitySim9002 preference = new CitySim9002();
        Visitor a = new Visitor();
        a.setIdentify("Business Person");
        assertFalse(preference.preferences(a, "The Point"));
    }

    //Test that visitor type which is a Business Person preferences the location
    //not including in the existing four locations, for example,
    //William Pitt Union, and it will return false.
    @Test
    public void testPreferences9() {
        CitySim9002 preference = new CitySim9002();
        Visitor a = new Visitor();
        a.setIdentify("Business Person");
        assertFalse(preference.preferences(a, "William Pitt Union"));
    }

    //Test that visitor type which is a Blogger preferences
    //Squirrel Hill, and it will return false.
    @Test
    public void testPreferences10() {
        CitySim9002 preference = new CitySim9002();
        Visitor a = new Visitor();
        a.setIdentify("Blogger");
        assertFalse(preference.preferences(a, "Squirrel Hill"));
    }
    //Test that visitor type which is a Blogger preferences the location
    //not including in the existing four locations, for example,
    //The Market, and it will return false.
    @Test
    public void testPreferences11() {
        CitySim9002 preference = new CitySim9002();
        Visitor a = new Visitor();
        a.setIdentify("Blogger");
        assertFalse(preference.preferences(a, "The Market"));
    }


    // --------------------------------------------------------------
    // DisplayPreference TESTS
    // --------------------------------------------------------------

    //Test that if visitor type which is a student goes to Cathedral of Learning
    //will display dislike preference.
    @Test
        public void testDisplay1() {
        CitySim9002 print = new CitySim9002();
        Mockito.when(mockedVisitor.getIdentify()).thenReturn("Student");
        assertEquals(print.displayPreference(mockedVisitor,"The Cathedral of Learning"), "Visitor " + mockedVisitor.getNum() + " did not like The Cathedral of Learning.");
    }
    //Test that if visitor type which is a professor goes to The Point
    //will display like preference.
    @Test
    public void testDisplay2() {
        CitySim9002 print = new CitySim9002();
        Mockito.when(mockedVisitor.getIdentify()).thenReturn("Professor");
        assertEquals(print.displayPreference(mockedVisitor,"The Point"), "Visitor " + mockedVisitor.getNum() + " did like The Point.");
    }
    //Test that if visitors does not like the location, for example, The Point,
    // it will return does not like the location.
    @Test
    public void testDisplay3() {
        CitySim9002 print = new CitySim9002();
        Mockito.when(mockedVisitor.getNum()).thenReturn(1);
        Mockito.when(mockedCitySim.preferences(mockedVisitor, null)).thenReturn(false);
        assertEquals(print.displayPreference(mockedVisitor,"The Point"), "Visitor " + mockedVisitor.getNum()+" did not like The Point.");
    }
}
