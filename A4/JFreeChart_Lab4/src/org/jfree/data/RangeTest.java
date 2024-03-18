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
    
    @Test(expected = IllegalArgumentException.class)
    public void invalidRangeTest() {
    	Range invalidRange = new Range(6, 4);
    }
    
    @Test
    public void getLengthTest() {
    	assertEquals("The length between 4 and 6 should be 2", 2, positiveRange.getLength(), .000000001d);
    }
    
    @Test
    public void intersectsNOMTest() {
    	assertTrue(positiveRange.intersects(0, 5));
    }
    
    @Test
    public void intersectsBLBTest() {
    	assertFalse(positiveRange.intersects(0, 1));
    }
    
    @Test
    public void intersectsALBTest() {
    	assertTrue(positiveRange.intersects(5, 7));
    }
    
    @Test
    public void intersectsFalseTest() {
    	assertFalse(positiveRange.intersects(5, 4));
    }
    
    @Test
    public void intersectsb0Test() {
    	assertFalse(positiveRange.intersects(7, 7));
    }
    
    @Test
    public void intersectsRangeTest() {
    	Range intersectRange = new Range (2, 6);
    	assertTrue(positiveRange.intersects(intersectRange));
    }
    
    @Test
    public void combineFirstNullTest() {
    	assertEquals("Combine null and (2,6) should return (2, 6)", positiveRange, Range.combine(null, positiveRange));
    }
    
    @Test
    public void combineSecondullTest() {
    	assertEquals("Combine null and (2,6) should return (2, 6)", positiveRange, Range.combine(positiveRange, null));
    }
    
    @Test
    public void combineTest() {
    	assertEquals("Combine (2,6) and (2,6) should return (2, 6)", positiveRange, Range.combine(positiveRange, positiveRange));
    }
    
    @Test
    public void combinecombineIgnoringNaNFirstNullTest() {
    	assertEquals("Combine null and (2,6) should return (2, 6)", positiveRange, Range.combineIgnoringNaN(null, positiveRange));
    }
    
    @Test
    public void combinecombineIgnoringNaNSecondNullTest() {
    	assertEquals("Combine null and (2,6) should return (2, 6)", positiveRange, Range.combineIgnoringNaN(positiveRange, null));
    }
    
    @Test
    public void combinecombineIgnoringNaNTest() {
    	assertEquals("Combine (2,6) and (2,6) should return (2, 6)", positiveRange, Range.combineIgnoringNaN(positiveRange, positiveRange));
    }
    
    @Test
    public void combinecombineIgnoringNaNSecondNaNTest() {
    	Range NaNRange = new Range(Double.NaN, Double.NaN);
    	assertEquals("Combine Null and NaN should return null", null, Range.combineIgnoringNaN(null, NaNRange));
    }
    
    @Test
    public void combinecombineIgnoringNaNFirstNaNTest() {
    	Range NaNRange = new Range(Double.NaN, Double.NaN);
    	assertEquals("Combine NaN and Null should return null", null, Range.combineIgnoringNaN(NaNRange, null));
    }
    
    @Test
    public void combinecombineIgnoringNaNBothNaNTest() {
    	Range NaNRange = new Range(Double.NaN, Double.NaN);
    	assertEquals("Combine NaN and NaN should return null", null, Range.combineIgnoringNaN(NaNRange, NaNRange));
    }
    
    @Test
    public void combineIgnoringNaNTest() {
    	Range range1 = new Range(3, 5);
    	Range range2 = new Range(Double.NaN, Double.NaN);
    	
    	assertEquals("Combine (3, 5) and NaN should return (3, 5)", range1, Range.combineIgnoringNaN(range1, range2));
    }
    
    @Test
    public void expandToIncludeNullTest() {
    	Range resultRange = new Range(1, 1);
    	assertEquals("Expand Null with 1 should return (1, 1)", resultRange, Range.expandToInclude(null, 1));
    }
    
    @Test
    public void expandToIncludeBLBTest() {
    	Range resultRange = new Range(3, 6);
    	assertEquals("Expand (4, 6) with 3 should return (3, 6)", resultRange, Range.expandToInclude(positiveRange, 3));
    }   
    
    @Test
    public void expandToIncludeAUBTest() {
    	Range resultRange = new Range(4, 7);
    	assertEquals("Expand (4, 6) with 7 should return (4, 7)", resultRange, Range.expandToInclude(positiveRange, 7));
    }
    
    @Test
    public void expandToIncludeNOMTest() {
    	Range resultRange = new Range(4, 6);
    	assertEquals("Expand (4, 6) with 5 should return (4, 6)", resultRange, Range.expandToInclude(positiveRange, 5));
    }
    
    @Test
    public void expandlowerMarginTest() {
    	Range resultRange = new Range(0, 6);
    	assertEquals("Expand (4, 6) with lowerMargin = 2 should return (0, 6)", resultRange, Range.expand(positiveRange, 2, 0));
    }
    
    @Test
    public void expandTest() {
    	Range resultRange = new Range(7, 7);
    	assertEquals("Expand (4, 6) with lowerMargin = -2 should return (7, 7)", resultRange, Range.expand(positiveRange, -2, 0));
    }
    
    @Test
    public void shiftTest() {
    	Range resultRange = new Range(6, 8);
    	assertEquals("Shift (4, 6) with delta = 2 should return (6, 8)", resultRange, Range.shift(positiveRange, 2));
    }
    
    @Test
    public void shiftallowZeroCrossingTest() {
    	Range resultRange = new Range(-2, 0);
    	assertEquals("Shift (4, 6) with delta = -6 should return (-2, 0)", resultRange, Range.shift(positiveRange, -6, true));
    }
    
    @Test
    public void shiftWithNoZeroCrossingTest() {
    	Range resultRange = new Range(0, 0);
    	assertEquals("Shift (4, 6) with delta = -6 should return (0, 0)", resultRange, Range.shift(positiveRange, -6, false));
    }
    
    @Test
    public void shiftWithNoZeroCrossingNegativeTest() {
    	Range resultRange = new Range(-10, -6);
    	assertEquals("Shift (-8, -4) with delta = -2 should return (-10, -6)", resultRange, Range.shift(negativeRange, -2, false));
    }
    
    @Test
    public void shiftWithNoZeroCrossingZeroTest() {
    	Range resultRange = new Range(0, 0);
    	assertEquals("Shift (0, 0) with delta = 0 should return (0, 0)", resultRange, Range.shift(zeroRange, 0, false));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void scaleExceptionTest() {
    	Range.scale(positiveRange, -1);
    }
    
    @Test
    public void scaleTest() {
    	Range resultRange = new Range(8, 12);
    	assertEquals("Scale (4, 6) with factor = 0 should return (8, 12)", resultRange, Range.scale(positiveRange, 2));
    }
    
    @Test
    public void equalsTest() {
    	assertTrue(positiveRange.equals(positiveRange));
    }
    
    @Test
    public void equalsNotRangeTest() {
    	assertFalse(positiveRange.equals("a"));
    }
    
    @Test
    public void equalsLowerTest() {
    	assertFalse(positiveRange.equals(negativeRange));
    }
    
    @Test
    public void equalsUpperTest() {
    	Range resultRange = new Range(4, 12);
    	assertFalse(positiveRange.equals(resultRange));
    }
    
    @Test
    public void isNaNRangeTest() {
    	Range resultRange = new Range(Double.NaN, 12);
    	assertFalse(resultRange.isNaNRange());
    }
    
    @Test
    public void hashCodeTest() {
    	assertEquals("Hashcode for (4, 6) should be -2115502080",-2115502080, positiveRange.hashCode());
    }
    
    @Test
    public void toStringTest() {
    	String toString = "Range[4.0,6.0]";
    	assertEquals("Tostring for (4, 6) should return Range[4.0, 6.0]", toString, positiveRange.toString());
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
