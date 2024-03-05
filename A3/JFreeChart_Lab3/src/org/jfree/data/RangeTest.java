/*
 * Due: Monday Feb 12th, 2024
 * Completed By: Naina and Uruba
 * Testing Range
 */

package org.jfree.data;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exRange;
    private Range exRange2;
    private Range exRange3;
    private Range exRange4;
    private Range exRange5, exRange6, exRange7;
    private Range minMaxRange;
    private Range nullRange;
    private Range positiveRange;
	private Range negativeRange;
	private Range zeroRange;
    
    @BeforeClass 
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception { 
    
    	//negative to positive ranges
    	exRange = new Range(-1, 1);
    	
    	//zero to positive ranges
    	exRange2 = new Range(0, 10);
    	
    	//completely positive ranges
    	exRange3 = new Range(1, 10);
    	
    	//zero to negative range
    	exRange4 = new Range(-10, 0);
    	
    	//completely negative ranges
    	exRange5 = new Range(-50, -10);
    	
    	exRange7 = new Range(1, 1);
    	
    	nullRange = null;
    	
    	positiveRange = new Range(4, 6);
    	
    	negativeRange = new Range(-8, -4);
    	
    	zeroRange = new Range(0, 0);
    	
    	//min and max range values
    	minMaxRange = new Range(Double.MIN_VALUE, Double.MAX_VALUE);
    	
    }
    
    //NEW: if (lower > upper) for constructor
    @Test(expected = IllegalArgumentException.class)
    public void testCtorValues() {
    	exRange6 =  new Range(50, 4);
    }
    
    //NEW: testing toString function
    @Test 
    public void testToString() {
    	exRange.toString();
    }
    
    
    //ALL NEW test combine(Range range1, Range range2) function ************************************************************
//    @Test 
//    public void testToString() {
//    	assertEquals("Combining with null should return the non-null range", range1, Range.combine(range1, range2));
//        ````````````````````````````````````````````````````````````````````````````````````````
//    }
//    
    
    //ALL NEW Test getLength() function ************************************************************************************
    @Test
    public void getNegToPosLength() {
    	assertEquals("The length in range -1 to 1 should be 2",
    	        2, exRange.getLength(), .000000001d);
    }
    @Test
    public void getLengthPosToPos() {
    	assertEquals("The length in range 1 to 10 should be 9",
    	        9, exRange3.getLength(), .000000001d);
    }
    
    
    //ALL NEW Test intersects(Range range1,Range range2) function ************************************************************************************
    @Test
    public void intersectsOverlapWithin() {
        assertTrue("Ranges 0 to 10 and 1 to 10 should overlap", exRange2.intersects(exRange3));
    }
    public void intersectsOverlapWithBiggerRange(){
        assertTrue("Ranges -1 to 1 and -10 to 0 should overlap", exRange.intersects(exRange4));
    }
    
    
    //ALL NEW Test intersects(double b0, double b1) function ************************************************************************************
    @Test
    public void intersectsBiggerTestRangesOverlaps() {
        assertTrue("Ranges -1 to 1 and -5 to 5 should overlap", exRange.intersects(-5, 5));
    }
    
    @Test
    public void intersectsLessThanLB() {
        assertTrue("Ranges 0 to 10 and -2 to 5 should overlap", exRange2.intersects(-2, 5));
    }
    @Test
    public void intersectsLessThanLB2() {
        assertTrue("Ranges 0 to 10 and -2 to 11 should overlap", exRange2.intersects(-2, 11));
    }
    
    @Test
    public void intersectHalfOverlap() {
        assertTrue("Ranges -1 to 1 and 0 to 5 should overlap", exRange.intersects(0, 5));
    }
    
    @Test
    public void intersectsWithinRange() {
        assertTrue("Ranges 0 to 10 and 2 to 5 should overlap", exRange2.intersects(2, 5));
    }
    
 

    //Test getCentralValue() function ******************************************************************************************
    @Test     
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exRange.getCentralValue(), .000000001d);
    }
    @Test
    public void centralValueShouldBePositive() {
    	assertEquals("The central value of 0 and 10 should be 5",
    	        5, exRange2.getCentralValue(), .000000001d);
    }
    @Test
    public void centralValueShouldBeDecimal() {
    	assertEquals("The central value of 1 and 10 should be 5.5",
    	       5.5 , exRange3.getCentralValue(), .000000001d);
    }
    @Test
    public void centralValueShouldBeNegative() {
    	assertEquals("The central value of -10 and 0 should be -5",
    	        -5, exRange4.getCentralValue(), .000000001d);
    }
    @Test
    public void getCentralValueMinMaxTest() {
    	double avg = (Double.MAX_VALUE + Double.MIN_VALUE)/2;
    	
        assertEquals("The central value of MIN_VALUE and MIN_VALUE should be " + avg,
        		avg, minMaxRange.getCentralValue(), .000000001d);
    }

    //Testing contains(double b0) function *******************************************************************************
    //NEW
    @Test 
    public void containsLowerEdgeValue() {assertTrue(exRange.contains(-1)); }
    
    //NEW
    @Test
    public void containsUpperEdgeValue() {assertTrue(exRange.contains(1)); }
    
    //NEW
    @Test
    public void containsBothUBandLB() {assertTrue(exRange7.contains(1)); }
    
    @Test
    public void containsZeroValue() {assertTrue(exRange.contains(0)); }
    
    @Test
    public void containsNegativeValue() {assertTrue(exRange4.contains(-6)); }
    
    @Test
    public void containsPositiveValue() {assertTrue(exRange2.contains(5)); }
    
    @Test
    public void doesntContainAboveUpperBound() {assertFalse(exRange2.contains(11));	}
    
    @Test
    public void doesntContainBelowLowerBound() {assertFalse(exRange2.contains(-2)); }
    
    @Test
    public void containsMinTest() {
    	assertTrue("Value " + Double.MIN_VALUE + " is within " + Double.MIN_VALUE + " and " + Double.MAX_VALUE,  minMaxRange.contains(Double.MIN_VALUE));
    }
    
    @Test
    public void containsMaxTest() {
    	assertTrue("Value " + Double.MAX_VALUE + " is within " + Double.MIN_VALUE + " and " + Double.MAX_VALUE,  minMaxRange.contains(Double.MAX_VALUE));

    }
    //Testing constrain() Function *******************************************************************************        
    
    @Test
    public void constrainShouldBePositiveValue() {
    	assertEquals("The constrain value of 5.4 in range 0 to 10 should be 5.4",
    	        5.4, exRange2.constrain(5.4), .000000001d);
    }
    
    @Test
    public void constrainShouldBeNegativeValue() {
    	assertEquals("The constrain value of -5.4 in range -10 to 0 should be -5.4",
    	        -5.4, exRange4.constrain(-5.4), .000000001d);
    }
    
    @Test
    public void constrainShouldBeZero() {
    	assertEquals("The constrain value of 0 in range 0 to 10 should be 0",
    	        0, exRange2.constrain(0), .000000001d);
    }
    
    @Test
    public void constrainShouldBeUpperBoundaryValue() {
    	assertEquals("The constrain value of 100 in range 0 to 10 should be 10",
    	        10, exRange2.constrain(100), .000000001d);
    }
    @Test
    public void constrainShouldBeLowerBoundaryValue() {
    	assertEquals("The constrain value of -50 in range 0 to 10 should be 0",
    	        0, exRange2.constrain(-50), .000000001d);
    }
    
    @Test
    public void constrainMaxTest() {
    	assertEquals("The closed value from (" + Double.MIN_VALUE + ", " +  Double.MAX_VALUE + ") to " + Double.MAX_VALUE + " is " + Double.MAX_VALUE,
    			Double.MAX_VALUE, minMaxRange.constrain(Double.MAX_VALUE), .000000001d);
    	}
    @Test
    public void constrainMinTest() {
    	assertEquals("The closed value from (" + Double.MIN_VALUE + ", " +  Double.MAX_VALUE + ") to " + Double.MIN_VALUE + " is " + Double.MIN_VALUE,
    			Double.MIN_VALUE, minMaxRange.constrain(Double.MIN_VALUE), .000000001d);

        
    }
    
    //Testing double getUpperBound() Function *******************************************************************************
    @Test
    public void getUpperBoundPositiveValue() {
    	assertEquals("The upper bound in range 0 to 10 is 10",
    	        10, exRange2.getUpperBound(), .000000001d);
    }
    @Test
    public void getUpperBoundNegativeValue() {
    	assertEquals("The upper bound in range -50 to -10 is -10",
    	        -10, exRange5.getUpperBound(), .000000001d);
    }
    @Test
    public void getUpperBoundZeroValue() { 
    	assertEquals("The upper bound in range -10 to 0 is 0", 
    			0, exRange4.getUpperBound(), .000000001d);
    }
    @Test
    public void getUpperBoundMinMaxTest() {
    	assertEquals("The upperbound of MIN_VALUE and MIN_VALUE should be " + Double.MAX_VALUE, 
    			Double.MAX_VALUE, minMaxRange.getUpperBound(), .000000001d);
    }
    //Testing getLowerBound() Function *******************************************************************************
    
   
    @Test
    public void getLowerBoundNegativeValue() {
    	assertEquals("The lower bound in range -10 to 0 is -10",
    	        -10, exRange4.getLowerBound(), .000000001d);
    }
    @Test
    public void getLowerBoundZeroValue() {
    	assertEquals("The lower bound in range 0 to 10 is 0",
    	        0, exRange2.getLowerBound(), .000000001d);
    }
    @Test
    public void getLowerBoundMinMaxTest() {
    	assertEquals("The lowerbound of MIN_VALUE and MIN_VALUE should be " + Double.MIN_VALUE, 
    			Double.MIN_VALUE, minMaxRange.getLowerBound(), .000000001d);
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
    	 exRange = null;
    	 exRange2 = null;
    	 exRange3 = null;
    	 exRange4 = null;
    	 exRange5 = null;
    	 exRange6 = null;
    	 exRange7 = null;
    	 positiveRange = null;
    	 negativeRange = null;
    	 zeroRange = null;
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    	System.out.println("All Range Testing Completed!");
    }
    
}
