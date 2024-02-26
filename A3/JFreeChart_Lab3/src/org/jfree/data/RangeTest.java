package org.jfree.data;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeTest {
	private Range positiveRange;
	private Range negativeRange;
	private Range zeroRange;
	private Range minMaxRange;
	
    @Before
    public void setUp() throws Exception {
    	// this test covers normal values for variable positiveRange
    	positiveRange = new Range(4, 6);
    	// this test covers normal values for variable negativeRange
    	negativeRange = new Range(-8, -4);
    	// this test covers normal values for variable zeroRange
    	zeroRange = new Range(0, 0);
    	// this test covers maximum and minimum values for variable minMaxRange
    	minMaxRange = new Range(Double.MIN_VALUE, Double.MAX_VALUE);
    }
    
    @Test
    public void getCentralValuePositiveTest() {
    	assertEquals("The central value of 4 and 6 should be 5",
    	        5, positiveRange.getCentralValue(), .000000001d);
    }
    
    @Test
    public void getCentralValueNegativeTest() {
        assertEquals("The central value of -8 and -4 should be -6",
        		-6, negativeRange.getCentralValue(), .000000001d);
    }
    
    @Test
    public void getCentralValueZeroTest() {
        assertEquals("The central value of 0 and 0 should be 0",
        		0, zeroRange.getCentralValue(), .000000001d);
    }
    
    @Test
    public void getCentralValueMinMaxTest() {
    	double medium = (Double.MAX_VALUE + Double.MIN_VALUE)/2;
        assertEquals("The central value of MIN_VALUE and MIN_VALUE should be " + medium,
        		medium, minMaxRange.getCentralValue(), .000000001d);
    }
    
    @Test
    public void getUpperBoundPositiveTest() {
    	assertEquals("The upperbound of 4 and 6 should be 6",
    	        6, positiveRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void getUpperBoundNegativeTest() {
    	assertEquals("The upperbound of -8 and -4 should be -4", -4,
    			negativeRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void getUpperBoundZeroTest() {
    	assertEquals("The upperbound of 0 and 0 should be 0", 0,
    			zeroRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void getUpperBoundMinMaxTest() {
    	assertEquals("The upperbound of MIN_VALUE and MIN_VALUE should be " + Double.MAX_VALUE, 
    			Double.MAX_VALUE, minMaxRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void getLowerBoundPositiveTest() {
    	assertEquals("The lower bound of 4 and 6 should be 4", 4, positiveRange.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getLowerBoundNegativeTest() {
    	assertEquals("The upperbound of -8 and -4 should be -8",
    	        -8, negativeRange.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getLowerBoundZeroTest() {
    	assertEquals("The upperbound of 0 and 0 should be 0",
    	        0, zeroRange.getLowerBound(), .000000001d);
    }

    @Test
    public void getLowerBoundMinMaxTest() {
    	assertEquals("The lowerbound of MIN_VALUE and MIN_VALUE should be " + Double.MIN_VALUE, 
    			Double.MIN_VALUE, minMaxRange.getLowerBound(), .000000001d);
    }
    
    // this test covers normal values for variable value
    @Test
    public void containsPositiveTest() {
    	assertTrue("Value 5 is within 4 and 6",  positiveRange.contains(5));
    }
    
    // this test covers normal values for variable value
    @Test
    public void containsNegativeTest() {
    	assertTrue("Value -6 is within -8 and -4",  negativeRange.contains(-6));
    }
    
    // this test covers normal values for variable value
    @Test
    public void containsZeroTest() {
    	assertTrue("Value 0 is within 0 and 0",  zeroRange.contains(0));
    }
    
    // this test covers maximum and minimum values for variable value
    @Test
    public void containsMinMaxTest() {
    	assertTrue("Value " + Double.MIN_VALUE + " is within " + Double.MIN_VALUE + " and " + Double.MAX_VALUE,  minMaxRange.contains(Double.MIN_VALUE));
    	assertTrue("Value " + Double.MAX_VALUE + " is within " + Double.MIN_VALUE + " and " + Double.MAX_VALUE,  minMaxRange.contains(Double.MAX_VALUE));
    }
    
    // this test covers maximum values for variable value
    @Test
    public void containsAUBTest() {
    	assertFalse("Value 7 is not within 4 and 6",  positiveRange.contains(7));
    }
    
    // this test covers minimum values for variable value
    @Test
    public void containsBLBTest() {
    	assertFalse("Value -9 is not within -8 and -4",  negativeRange.contains(-9));
    }
    
    // this test covers normal values for variable value
    @Test
    public void constrainPositiveTest() {
    	assertEquals("The closed value from (4, 6) to 6 is 6", 6, positiveRange.constrain(6), .000000001d);
    }
    
    // this test covers normal values for variable value
    @Test
    public void constrainNegativeTest() {
    	assertEquals("The closed value from (-8, -4) to -8 is -8", -8, negativeRange.constrain(-8), .000000001d);
    }
    
    // this test covers normal values for variable value
    @Test
    public void constrainZeroTest() {
    	assertEquals("The closed value from (0, 0) to 0 is 0", 0, zeroRange.constrain(0), .000000001d);
    }
    
    // this test covers maximum and minimum values for variable value
    @Test
    public void constrainMinMaxTest() {
    	assertEquals("The closed value from (" + Double.MIN_VALUE + ", " +  Double.MAX_VALUE + ") to " + Double.MAX_VALUE + " is " + Double.MAX_VALUE,
    			Double.MAX_VALUE, minMaxRange.constrain(Double.MAX_VALUE), .000000001d);
    	assertEquals("The closed value from (" + Double.MIN_VALUE + ", " +  Double.MAX_VALUE + ") to " + Double.MIN_VALUE + " is " + Double.MIN_VALUE,
    			Double.MIN_VALUE, minMaxRange.constrain(Double.MIN_VALUE), .000000001d);
    }
    
    // this test covers maximum values for variable value
    @Test
    public void constrainAUBTest() {
    	assertEquals("The closed value from (4, 6) to 7 is 6", 6, positiveRange.constrain(7), .000000001d);
    }
    
    // this test covers minimum values for variable value
    @Test
    public void constrainBLBTest() {
    	assertEquals("The closed value from (-8, -4) to -9 is -8", -8, negativeRange.constrain(-9), .000000001d);
    }
    
	@After
	public void tearDown() throws Exception {
    	positiveRange = null;
    	negativeRange = null;
    	zeroRange = null;
    	minMaxRange = null;
	}

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    	System.out.println("Range Test Completed.");
    }
}
