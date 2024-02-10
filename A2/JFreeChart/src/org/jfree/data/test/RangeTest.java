package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception {
    	exampleRange = new Range(-5, 5);
    }


    @Test
    public void getCentralValueZeroTest() {
        assertEquals("The central value of -5 and 5 should be 0",
        0, exampleRange.getCentralValue(), .000000001d);
    }
    
    public void getCentralValuePositiveTest() {
    	Range positiveRange = new Range(4, 6);
    	assertEquals("The central value of 4 and 6 should be 5",
    	        5, positiveRange.getCentralValue(), .000000001d);
    }
    
    @Test
    public void getCentralValueNegativeTest() {
    	Range negativeRange = new Range(-8, -4);
        assertEquals("The central value of -8 and -4 should be -6",
        -6, negativeRange.getCentralValue(), .000000001d);
    }
    
    
    @Test
    public void getUpperBoundPositiveTest() {
    	assertEquals("The upperbound of -5 and 5 should be 5",
    	        5, exampleRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void getUpperBoundNegativeTest() {
    	Range negativeRange = new Range(-10, -9);
    	assertEquals("The upperbound of -10 and -9 is -9", -10, negativeRange.getUpperBound(), .000000001d);
    }
    
    
    @Test
    public void getLowerBoundNegativeTest() {
    	assertEquals("The upperbound of -5 and 5 should be 5",
    	        -5, exampleRange.getLowerBound(), .000000001d);
    }
    
    public void getLowerBoundPositiveTest() {
    	Range positiveRange = new Range(19, 25);
    	assertEquals("The lower bound of 19 and 25 is 19", 19, positiveRange.getLowerBound(), .000000001d);
    }
    
    @Test
    //5 is also the upper_bound value in this range
    public void containsPositiveTest() {
    	assertTrue("Value 5 is within -5 and 5",  exampleRange.contains(5));
    }
    
    @Test
    public void containsNegativeTest() {
    	assertFalse("Value -6 is not within -5 and 5",  exampleRange.contains(-6));
    }
    
    @Test
    public void containsZeroTest() {
    	assertTrue("Value 0 is within -5 and 5",  exampleRange.contains(0));
    }
    
    @Test
    public void constrainPositiveTest() {
    	assertEquals("The closed value from -5 to 5 to 6 is 5", 5, exampleRange.constrain(6), .000000001d);
    }
    
    @Test
    public void constrainNegativeTest() {
    	assertEquals("The closed value from -5 to 5 to -6 is -5", -5, exampleRange.constrain(-6), .000000001d);
    }
    
    @Test
    public void constrainZeroTest() {
    	assertEquals("The closed value from -5 to 5 to 0 is 0", 5, exampleRange.constrain(0), .000000001d);
    }
    
    

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
