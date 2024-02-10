package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeTest {
    private Range testRange;
    
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    	testRange = new Range(-5, 5);
    }

    @Test
    public void getCentralValueZeroTest() {
        assertEquals("The central value of -5 and 5 should be 0",
        		0, testRange.getCentralValue(), .000000001d);
    }
    
    @Test
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
    public void getCentralValueMinMaxTest() {
    	Range range = new Range(Double.MIN_VALUE, Double.MAX_VALUE);
    	double medium = (Double.MAX_VALUE + Double.MIN_VALUE)/2;
        assertEquals("The central value of MIN_VALUE and MIN_VALUE should be " + medium,
        		medium, range.getCentralValue(), .000000001d);
    }
    
    @Test
    public void getUpperBoundPositiveTest() {
    	assertEquals("The upperbound of -5 and 5 should be 5",
    	        5, testRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void getUpperBoundNegativeTest() {
    	Range negativeRange = new Range(-10, -9);
    	assertEquals("The upperbound of -10 and -9 is -9", -9,
    			negativeRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void getUpperBoundMinMaxTest() {
    	Range range = new Range(Double.MIN_VALUE, Double.MAX_VALUE);
    	assertEquals("The upperbound of MIN_VALUE and MIN_VALUE should be " + Double.MAX_VALUE, 
    			Double.MAX_VALUE, range.getUpperBound(), .000000001d);
    }
    
    @Test
    public void getLowerBoundNegativeTest() {
    	assertEquals("The upperbound of -5 and 5 should be 5",
    	        -5, testRange.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getLowerBoundPositiveTest() {
    	Range positiveRange = new Range(19, 25);
    	assertEquals("The lower bound of 19 and 25 is 19", 19, positiveRange.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getLowerBoundMinMaxTest() {
    	Range range = new Range(Double.MIN_VALUE, Double.MAX_VALUE);
    	assertEquals("The lowerbound of MIN_VALUE and MIN_VALUE should be " + Double.MIN_VALUE, 
    			Double.MIN_VALUE, range.getLowerBound(), .000000001d);
    }
    
    @Test
    //5 is also the upper_bound value in this range
    public void containsPositiveTest() {
    	assertTrue("Value 5 is within -5 and 5",  testRange.contains(5));
    }
    
    @Test
    public void containsNegativeTest() {
    	assertFalse("Value -6 is not within -5 and 5",  testRange.contains(-6));
    }
    
    @Test
    public void containsZeroTest() {
    	assertTrue("Value 0 is within -5 and 5",  testRange.contains(0));
    }
    
    @Test
    public void containsMinMaxTest() {
    	Range range = new Range(Double.MIN_VALUE, Double.MAX_VALUE);
    	assertTrue("Value " + Double.MIN_VALUE + " is within " + Double.MIN_VALUE + " and " + Double.MAX_VALUE,  range.contains(Double.MIN_VALUE));
    	assertTrue("Value " + Double.MAX_VALUE + " is within " + Double.MIN_VALUE + " and " + Double.MAX_VALUE,  range.contains(Double.MAX_VALUE));
    }
    
    @Test
    public void constrainPositiveTest() {
    	assertEquals("The closed value from -5 to 5 to 6 is 5", 5, testRange.constrain(6), .000000001d);
    }
    
    @Test
    public void constrainNegativeTest() {
    	assertEquals("The closed value from -5 to 5 to -6 is -5", -5, testRange.constrain(-6), .000000001d);
    }
    
    @Test
    public void constrainZeroTest() {
    	assertEquals("The closed value from -5 to 5 to 0 is 0", 0, testRange.constrain(0), .000000001d);
    }
    
    @Test
    public void constrainMinMaxTest() {
    	Range range = new Range(Double.MIN_VALUE, Double.MAX_VALUE);
    	assertEquals("The closed value from " + Double.MIN_VALUE + " to " +  Double.MAX_VALUE + " to " + Double.MAX_VALUE + " is " + Double.MAX_VALUE,
    			Double.MAX_VALUE, range.constrain(Double.MAX_VALUE), .000000001d);
    	assertEquals("The closed value from " + Double.MIN_VALUE + " to " +  Double.MAX_VALUE + " to " + Double.MIN_VALUE + " is " + Double.MIN_VALUE,
    			Double.MIN_VALUE, range.constrain(Double.MIN_VALUE), .000000001d);
    }
    
    @After
    public void tearDown() throws Exception {
    	testRange = null;
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    	System.out.println("Range Test Completed.");
    }
}
