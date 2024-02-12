package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exRange;
    private Range exRange2;
    private Range exRange3;
    private Range exRange4;
    private Range exRange5;
    
    @BeforeClass 
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception { 
    	exRange = new Range(-1, 1);
    	exRange2 = new Range(0, 10);
    	exRange3 = new Range(1, 10);
    	exRange4 = new Range(-10, 0);
    	exRange5 = new Range(-50, -10);
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
    	assertEquals("The central value of 0 and 10 should be -5",
    	        -5, exRange4.getCentralValue(), .000000001d);
    }

    //Testing contains() function *******************************************************************************
    @Test
    public void containsEdgeValue() {assertTrue(exRange.contains(-1)); }
    @Test
    public void containsZeroValue() {assertTrue(exRange.contains(0)); }
    @Test
    public void containsNegariveValue() {assertTrue(exRange4.contains(-6)); }
    @Test
    public void containsPositiveValue() {assertTrue(exRange2.contains(5)); }
    @Test
    public void doesntContainAboveUpperBound() {assertFalse(exRange2.contains(11));	}
    @Test
    public void doesntContainBelowLowerBound() {assertFalse(exRange2.contains(-2)); }

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
    //Testing Constrain Function *******************************************************************************
    
    @Test
    public void getLowerBoundPositiveValue() {
    	assertEquals("The lower bound in range 1 to 10 is 1",
    	        1, exRange3.getLowerBound(), .000000001d);
    }
    @Test
    public void getLowerBoundNegativeValue() {
    	assertEquals("The lower bound in range -10 to 0 is -10",
    	        10, exRange4.getLowerBound(), .000000001d);
    }
    @Test
    public void getLowerBoundZeroValue() {
    	assertEquals("The lower bound in range 0 to 10 is 0",
    	        0, exRange2.getLowerBound(), .000000001d);
    }
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
