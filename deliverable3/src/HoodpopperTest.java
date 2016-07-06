/**
 * Created by XINLAI on 6/23/16.
 */
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HoodpopperTest {

    static WebDriver driver = new HtmlUnitDriver();

    // Start at the home page for Ruby Project for each test
    @Before
    public void setUp() throws Exception {
        driver.get("http://lit-bayou-7912.herokuapp.com");
    }

    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
    }

    ////////////////////////////////////////////////////////////////
    //////////////////////////USER STORY 1//////////////////////////
    ////////////////////////////////////////////////////////////////

    /**
     * As a user,
     * I would like to tokenize the code which I type in,
     * So that I can get an array of tokens after I click the Tokenize Button.
     * @author xinlai
     *
     */

    //////////////////////////////////
    //UserStory 1: Scenario 1
    //////////////////////////////////

    // Given that a user is on the main page
    // When he types empty space and click the Tokenize button
    // Then he should see the ":on_sp" to indicate a space
    @Test
    public void testTokenizeSpace() {

        try {
            //Find text area and send the value
            driver.findElement(By.id("code_code")).sendKeys(" ");

            //Look for the Tokenize button and click
            WebElement tokenizeButton = driver.findElement(By.name("commit"));
            tokenizeButton.click();

            //Test space as on_sp
            boolean b = driver.getPageSource().contains(":on_sp");
            assertTrue(b);
        }catch (NoSuchElementException n){ //Otherwise it will fail
            fail();
        }

    }

    //////////////////////////////////
    //UserStory 1: Scenario 2
    //////////////////////////////////

    // Given that a user is on the main page
    // When he types puts and click the Tokenize button
    // Then he should see the ":on_ident" to indicate an identifier
    @Test
    public void testTokenizeIdentifierPuts() {

        try {
            //Find text area and send the value
            driver.findElement(By.id("code_code")).sendKeys("puts");

            //Look for the Tokenize button and click
            WebElement tokenizeButton = driver.findElement(By.name("commit"));
            tokenizeButton.click();

            //Test puts as identifiers
            boolean b = driver.getPageSource().contains(":on_ident");
            assertTrue(b);
        }catch (NoSuchElementException n){ //Otherwise it will fail
            fail();
        }

    }
    //////////////////////////////////
    //UserStory 1: Scenario 3
    //////////////////////////////////

    // Given that a user is on the main page
    // When he types a variable and click the Tokenize button
    // Then he should see the ":on_ident" to indicate an identifier
    @Test
    public void testTokenizeIdentifierVar() {

        try {
            //Find text area and send the value
            driver.findElement(By.id("code_code")).sendKeys("a");

            //Look for the Tokenize button and click
            WebElement tokenizeButton = driver.findElement(By.name("commit"));
            tokenizeButton.click();

            //Test Variables as identifiers
            boolean b = driver.getPageSource().contains(":on_ident");
            assertTrue(b);
        }catch (NoSuchElementException n) { //Otherwise it will fail
            fail();
        }

    }

    //////////////////////////////////
    //UserStory 1: Scenario 4
    //////////////////////////////////

    // Given that a user is on the main page
    // When he types a newline and click the Tokenize button
    // Then he should see the ":on_nl" to indicate a newline
    @Test
    public void testTokenizeNewlines() {

        try {
            //Find text area and send the value
            driver.findElement(By.id("code_code")).sendKeys("\\r\n");

            //Look for the Tokenize button and click
            WebElement tokenizeButton = driver.findElement(By.name("commit"));
            tokenizeButton.click();

            //Test newline as on_nl
            boolean b = driver.getPageSource().contains(":on_nl");
            assertTrue(b);
        }catch (NoSuchElementException n) { //Otherwise it will fail
            fail();
        }

    }
    //////////////////////////////////
    //UserStory 1: Scenario 5
    //////////////////////////////////

    // Given that a user is on the main page
    // When he types a operator and click the Tokenize button
    // Then he should see the ":on_op" to indicate an operator
    @Test
    public void testTokenizeOperators() {

        try {
            //Find text area and send the value
            driver.findElement(By.id("code_code")).sendKeys("*");

            //Look for the Tokenize button and click
            WebElement tokenizeButton = driver.findElement(By.name("commit"));
            tokenizeButton.click();

            //Test operator as on_op
            boolean b = driver.getPageSource().contains(":on_op");
            assertTrue(b);
        }catch (NoSuchElementException n){ //Otherwise it will fail
            fail();
        }

    }

    ////////////////////////////////////////////////////////////////
    //////////////////////////USER STORY 2//////////////////////////
    ////////////////////////////////////////////////////////////////

    /**
     * As a user,
     * I would like to prase the code which I have tokenized,
     * So that I can transform the text into AST after I click the Parse Button.
     * @author xinlai
     *
     */

    //////////////////////////////////
    //UserStory 2: Scenario 1
    //////////////////////////////////

    // Given that a user is on the main page
    // When he types a string and click the Parse button
    // Then he should see the "ident" to indicate that it stores in AST

    @Test
    public void testParseNonWhitespace() {

        try {
            //Find text area and send the value
            driver.findElement(By.id("code_code")).sendKeys("puts \"foo\"");

            //Look for the Parse button and click
            WebElement compileButton = driver.findElement(By.xpath("/html/body/form/p[2]/input[2]"));
            compileButton.click();

            //test non-whitespace, like puts string, will appear ident
            boolean b = driver.findElement(By.tagName("code")).getText().contains("ident");
            assertTrue(b);
        }catch (NoSuchElementException n) { //Otherwise it will fail
            fail();
        }

    }

    //////////////////////////////////
    //UserStory 2: Scenario 2
    //////////////////////////////////

    // Given that a user is on the main page
    // When he types a function and click the Parse button
    // Then he should see the "ident" to indicate that it stores in AST

    @Test
    public void testParseNonWhitespace1() {

        try {
            //Find text area and send the value
            driver.findElement(By.id("code_code")).sendKeys(" a = 3 + 2");

            //Look for the Parse button and click
            WebElement compileButton = driver.findElement(By.xpath("/html/body/form/p[2]/input[2]"));
            compileButton.click();

            //test non-whitespace, like a = 3 + 2, will appear ident
            boolean b = driver.findElement(By.tagName("code")).getText().contains("ident");
            assertTrue(b);
        }catch (NoSuchElementException n) { //Otherwise it will fail
            fail();
        }

    }

    //////////////////////////////////
    //UserStory 2: Scenario 3
    //////////////////////////////////

    // Given that a user is on the main page
    // When he types a empty space and click the Parse button
    // Then he should not see the "sp" to indicate that it not stores in AST
    @Test
    public void testParseWhitespace() {

        try {
            //Find text area and send the value
            driver.findElement(By.id("code_code")).sendKeys(" ");

            //Look for the Parse button and click
            WebElement compileButton = driver.findElement(By.xpath("/html/body/form/p[2]/input[2]"));
            compileButton.click();

            //test whitespace, like space and it will not appear
            boolean b = driver.findElement(By.tagName("code")).getText().contains("sp");
            assertFalse(b);
        }catch (NoSuchElementException n) { //Otherwise it will fail
            fail();
        }
    }

    //////////////////////////////////
    //UserStory 2: Scenario 4
    //////////////////////////////////

    // Given that a user is on the main page
    // When he types a newline and click the Parse button
    // Then he should not see the "nl" to indicate that it not stores in AST
    @Test
    public void testParseWhitespaceNewline() {

        try {
            //Find text area and send the value
            driver.findElement(By.id("code_code")).sendKeys("\\r\n");

            //Look for the Parse button and click
            WebElement compileButton = driver.findElement(By.xpath("/html/body/form/p[2]/input[2]"));
            compileButton.click();

            //test whitespace, like newline and it will not appear
            boolean b = driver.findElement(By.tagName("code")).getText().contains("nl");
            assertFalse(b);
        }catch (NoSuchElementException n) { //Otherwise it will fail
            fail();
        }

    }

    ////////////////////////////////////////////////////////////////
    //////////////////////////USER STORY 3//////////////////////////
    ////////////////////////////////////////////////////////////////

    /**
     * As a user,
     * I would like to compile AST,
     * So that I can get a result after I click the Compile Button.
     * @author xinlai
     *
     */

    //////////////////////////////////
    //UserStory 3: Scenario 1
    //////////////////////////////////

    // Given that a user is on the main page
    // When he types a string and click the Compile button
    // Then he should see the "putstring + string"
    @Test
    public void testCompilePutsString() {

        try {
            //Find text area and send the value
            driver.findElement(By.id("code_code")).sendKeys("puts \"foo\"");

            //Look for the Compile button and click
            WebElement compileButton = driver.findElement(By.xpath("/html/body/form/p[2]/input[3]"));
            compileButton.click();

            //test a string contains puts should appear putstring YARV operation
            boolean b = driver.findElement(By.tagName("code")).getText().contains("putstring \"foo\"");
            assertTrue(b);
        }catch (NoSuchElementException n) { //Otherwise it will fail
            fail();
        }

    }
    //////////////////////////////////
    //UserStory 3: Scenario 2
    //////////////////////////////////

    // Given that a user is on the main page
    // When he types "a = 3" and click the Compile button
    // Then he should see the "putobject 3"
    @Test
    public void testCompilePutsObject() {

        try {
            //Find text area and send the value
            driver.findElement(By.id("code_code")).sendKeys("a = 3");

            //Look for the Compile button and click
            WebElement compileButton = driver.findElement(By.xpath("/html/body/form/p[2]/input[3]"));
            compileButton.click();

            //Test put any of the values specified on the stack using putobject
            boolean b = driver.findElement(By.tagName("code")).getText().contains("putobject 3");
            assertTrue(b);
        }catch (NoSuchElementException n) { //Otherwise it will fail
            fail();
        }

    }
    //////////////////////////////////
    //UserStory 3: Scenario 3
    //////////////////////////////////

    // Given that a user is on the main page
    // When he types "a = 6 + 2" and click the Compile button
    // Then he should see the "opt_plus"
    @Test
    public void testCompilePlus() {

        try {
            //Find text area and send the value
            driver.findElement(By.id("code_code")).sendKeys("a = 6 + 2");

            //Look for the Compile button and click
            WebElement compileButton = driver.findElement(By.xpath("/html/body/form/p[2]/input[3]"));
            compileButton.click();

            //Test + call the opt_plus
            boolean b = driver.findElement(By.tagName("code")).getText().contains("opt_plus");
            assertTrue(b);
        }catch (NoSuchElementException n) { //Otherwise it will fail
            fail();
        }

    }
    //////////////////////////////////
    //UserStory 3: Scenario 4
    //////////////////////////////////

    // Given that a user is on the main page
    // When he types "a = 6 - 2" and click the Compile button
    // Then he should see the "opt_minus"
    @Test
    public void testCompileMinus() {

        try {
            //Find text area and send the value
            driver.findElement(By.id("code_code")).sendKeys("a = 6 - 2");

            //Look for the Compile button and click
            WebElement compileButton = driver.findElement(By.xpath("/html/body/form/p[2]/input[3]"));
            compileButton.click();

            //Test - call the opt_minus
            boolean b = driver.findElement(By.tagName("code")).getText().contains("opt_minus");
            assertTrue(b);
        }catch (NoSuchElementException n) { //Otherwise it will fail
            fail();
        }

    }
    //////////////////////////////////
    //UserStory 3: Scenario 5
    //////////////////////////////////

    // Given that a user is on the main page
    // When he types "a = 6 / 2" and click the Compile button
    // Then he should see the "opt_div"
    @Test
    public void testCompileDiv() {

        try {
            //Find text area and send the value
            driver.findElement(By.id("code_code")).sendKeys("a = 6 / 2");

            //Look for the Compile button and click
            WebElement compileButton = driver.findElement(By.xpath("/html/body/form/p[2]/input[3]"));
            compileButton.click();

            //Test / call the opt_div
            boolean b = driver.findElement(By.tagName("code")).getText().contains("opt_div");
            assertTrue(b);
        }catch (NoSuchElementException n) { //Otherwise it will fail
            fail();
        }
    }
    //////////////////////////////////
    //UserStory 3: Scenario 6
    //////////////////////////////////

    // Given that a user is on the main page
    // When he types "a = 6 * 2" and click the Compile button
    // Then he should see the "opt_mult"
    @Test
    public void testCompileMult() {

        try {
            //Find text area and send the value
            driver.findElement(By.id("code_code")).sendKeys("a = 6 * 2");

            //Look for the Compile button and click
            WebElement compileButton = driver.findElement(By.xpath("/html/body/form/p[2]/input[3]"));
            compileButton.click();

            //Test * call the opt_mult
            boolean b = driver.findElement(By.tagName("code")).getText().contains("opt_mult");
            assertTrue(b);
        }catch (NoSuchElementException n) { //Otherwise it will fail
            fail();
        }

    }

}


