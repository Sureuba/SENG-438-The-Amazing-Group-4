package org.jfree.data;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {
	private Mockery mockery;
	private Values2D values;
	private KeyedValues keyedValues;

	@Before
	public void setUp() throws Exception {
		mockery = new Mockery();
		values = mockery.mock(Values2D.class);
		keyedValues = mockery.mock(KeyedValues.class);
	}

	// this test covers normal values for variable data and column
	@Test
	public void calculateColumnTotalTest() {
		mockery.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(7.5));
				one(values).getValue(1, 0);
				will(returnValue(2.5));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(10.0, result, .000000001d);
	}
	
	// this test covers normal values for variable data and column
	@Test
	public void calculateColumnTotalNegativeTest() {
		mockery.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(-7.5));
				one(values).getValue(1, 0);
				will(returnValue(-7.5));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(-15, result, .000000001d);
	}

	// this test covers normal values for variable data and column
	@Test
	public void calculateColumnTotalZeroTest() {
		mockery.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(0));
				one(values).getValue(1, 0);
				will(returnValue(0));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(0, result, .000000001d);
	}
	
	// this test covers invalid values for variable data and normal values for column
	@Test
	public void calculateColumnTotalNullTest() {
		mockery.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(null));
				one(values).getValue(1, 0);
				will(returnValue(null));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(0, result, .000000001d);
	}
	
	// this test covers invalid values for variable data and normal values for column
	@Test(expected = IllegalStateException.class)
	public void calculateColumnTotalExceptionTest() {
		mockery.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue('a'));
				one(values).getValue(1, 0);
				will(returnValue(7.5));
			}
		});
		DataUtilities.calculateColumnTotal(values, 0);
	}
	
	// this test covers maximum and minimum values for variable data and normal values for column
	@Test
	public void calculateColumnTotalMinMaxTest() {
		mockery.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(Double.MIN_VALUE));
				one(values).getValue(1, 0);
				will(returnValue(Double.MAX_VALUE));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(Double.MIN_VALUE + Double.MAX_VALUE, result, .000000001d);
	}

	// calculates the column total of the second column
	// this test covers normal values for variable data and column
	@Test
	public void calculateColumnTotalColumnOneTest() {
		mockery.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(3));
				one(values).getValue(0, 0);
				will(returnValue(0));
				one(values).getValue(1, 0);
				will(returnValue(1.5));
				one(values).getValue(2, 0);
				will(returnValue(2.5));
				one(values).getValue(0, 1);
				will(returnValue(3.5));
				one(values).getValue(1, 1);
				will(returnValue(4.5));
				one(values).getValue(2, 1);
				will(returnValue(5.5));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 1);
		assertEquals(13.5, result, .000000001d);
	}

	// this test covers normal values for variable data and row
	@Test
	public void calculateRowTotalTest() {
		mockery.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(7.5));
				one(values).getValue(0, 1);
				will(returnValue(2.5));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(10.0, result, .000000001d);
	}

	// this test covers normal values for variable data and row
	@Test
	public void calculateRowTotalNegativeTest() {
		mockery.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(-7.5));
				one(values).getValue(0, 1);
				will(returnValue(-7.5));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(-15, result, .000000001d);
	}

	// this test covers normal values for variable data and row
	@Test
	public void calculateRowTotalZeroTest() {
		mockery.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(0));
				one(values).getValue(0, 1);
				will(returnValue(0));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(0, result, .000000001d);
	}
	
	// this test covers invalid values for variable data and normal values for row
	@Test
	public void calculateRowTotalNullTest() {
		mockery.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(null));
				one(values).getValue(0, 1);
				will(returnValue(null));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(0, result, .000000001d);
	}
	
	// this test covers invalid values for variable data and normal values for row
	@Test(expected = IllegalStateException.class)
	public void calculateRowTotalExceptionTest() {
		mockery.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue('a'));
				one(values).getValue(0, 1);
				will(returnValue(7.5));
			}
		});
		DataUtilities.calculateRowTotal(values, 0);
	}

	// this test covers maximum and minimum values for variable data and normal values for row
	@Test
	public void calculateRowMinMaxTest() {
		mockery.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(Double.MIN_VALUE));
				one(values).getValue(0, 1);
				will(returnValue(Double.MAX_VALUE));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(Double.MIN_VALUE + Double.MAX_VALUE, result, .000000001d);
	}

	// calculates the column total of the second row
	// this test covers normal values for variable data and row
	@Test
	public void calculateRowTotalRowOneTest() {
		mockery.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(3));
				one(values).getValue(0, 0);
				will(returnValue(0));
				one(values).getValue(0, 1);
				will(returnValue(1.5));
				one(values).getValue(0, 2);
				will(returnValue(2.5));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(4.0, result, .000000001d);
	}

	// this test covers normal values for variable data
	@Test
	public void createNumberArrayTest() {
		double[] data = { 1.0, 2.5, -3.5, 4.5, 0.0 };
		Number[] result = DataUtilities.createNumberArray(data);

		assertEquals(data.length, result.length);

		for (int i = 0; i < data.length - 1; i++) {
			assertEquals(data[i], result[i].doubleValue(), .000000001d);
		}
	}

	// this test covers empty values for variable data
	@Test
	public void createNumberArrayEmptyTest() {
		double[] data = {};
		Number[] result = DataUtilities.createNumberArray(data);

		assertEquals(0, result.length);
	}

	// this test covers invalid values for variable data
	@Test(expected = IllegalArgumentException.class)
	public void createNumberArrayNullTest() {
		double[] data = null;
		DataUtilities.createNumberArray(data);
	}
	
	// this test covers maximum and minimum values for variable data
	@Test
	public void createNumberArrayMinMaxTest() {
		double[] data = { Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.MAX_VALUE };
		Number[] result = DataUtilities.createNumberArray(data);

		assertEquals(data.length, result.length);

		for (int i = 0; i < data.length - 1; i++) {
			assertEquals(data[i], result[i].doubleValue(), .000000001d);
		}
	}
	
	// this test covers normal values for variable data
	@Test
	public void createNumberArray2DTest() {
		double[][] data = { { 1.0, -2.5, 3.5, 0 }, { -5.0, 6.5, 7.5, 8.5 } };
		Number[][] result = DataUtilities.createNumberArray2D(data);

		assertEquals(data.length, result.length);

		for (int i = 0; i < data.length - 1; i++) {
			
			assertEquals(data[i].length, result[i].length);

			for (int j = 0; j < data[i].length - 1; j++) {
				assertEquals(data[i][j], result[i][j].doubleValue(), .000000001d);
			}
		}
	}

	// this test covers empty values for variable data
	@Test
	public void createNumberArray2DEmptyTest() {
		double[][] data = {};
		Number[][] result = DataUtilities.createNumberArray2D(data);

		assertEquals(0, result.length);
	}

	// this test covers invalid values for variable data
	@Test(expected = IllegalArgumentException.class)
	public void createNumberArray2DNullTest() {
		double[][] data = null;
		DataUtilities.createNumberArray2D(data);
	}
	
	// this test covers maximum and minimum values for variable data
	@Test
	public void createNumberArray2DMinMaxTest() {
		double[][] data = { { Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.MAX_VALUE },
				{ Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.MAX_VALUE } };
		Number[][] result = DataUtilities.createNumberArray2D(data);

		assertEquals(data.length, result.length);

		for (int i = 0; i < data.length - 1; i++) {
			
			assertEquals(data[i].length, result[i].length);

			for (int j = 0; j < data[i].length - 1; j++) {
				assertEquals(data[i][j], result[i][j].doubleValue(), .000000001d);
			}
		}
	}

	// this test covers normal values for variable data
	@Test
	public void getCumulativePercentagesTest() {
		mockery.checking(new Expectations() {
			{
				allowing(keyedValues).getItemCount();
				will(returnValue(3));
				allowing(keyedValues).getValue(0);
				will(returnValue(5));
				allowing(keyedValues).getValue(1);
				will(returnValue(9));
				allowing(keyedValues).getValue(2);
				will(returnValue(2));
				allowing(keyedValues).getKey(0);
				will(returnValue(0));
				allowing(keyedValues).getKey(1);
				will(returnValue(1));
				allowing(keyedValues).getKey(2);
				will(returnValue(2));
			}
		});

		KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);

		assertEquals(0.3125, result.getValue(0));
		assertEquals(0.875, result.getValue(1));
		assertEquals(1.0, result.getValue(2));
	}
	
	// this test covers empty values for variable data
	@Test
	public void getCumulativePercentagesEmptyTest() {
		mockery.checking(new Expectations() {
			{
				allowing(keyedValues).getItemCount();
				will(returnValue(0));
			}
		});

		KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);

		assertEquals(0, result.getItemCount());
	}
	
	// the cumulative percentage of 0 should be 0%
	// this test covers normal values for variable data
	@Test
	public void getCumulativePercentagesZeroTest() {
		mockery.checking(new Expectations() {
			{
				allowing(keyedValues).getItemCount();
				will(returnValue(2));
				allowing(keyedValues).getValue(0);
				will(returnValue(0));
				allowing(keyedValues).getValue(1);
				will(returnValue(0));
				allowing(keyedValues).getKey(0);
				will(returnValue(0));
				allowing(keyedValues).getKey(1);
				will(returnValue(1));
			}
		});

		KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);

		assertEquals(Double.NaN, result.getValue(0));
		assertEquals(Double.NaN, result.getValue(1));
	}

	// this test covers invalid values for variable data
	@Test(expected = IllegalStateException.class)
	public void getCumulativePercentagesNullTest() {
		mockery.checking(new Expectations() {
			{
				allowing(keyedValues).getItemCount();
				will(returnValue(null));
			}
		});

		DataUtilities.getCumulativePercentages(keyedValues);

	}
	
	// this test covers invalid values for variable data
	@Test(expected = IllegalStateException.class)
	public void getCumulativePercentagesExceptionTest() {
		mockery.checking(new Expectations() {
			{
				allowing(keyedValues).getItemCount();
				will(returnValue(2));
				allowing(keyedValues).getValue(0);
				will(returnValue(0));
				allowing(keyedValues).getValue(1);
				will(returnValue(' '));
				allowing(keyedValues).getKey(0);
				will(returnValue(0));
				allowing(keyedValues).getKey(1);
				will(returnValue(1));
			}
		});

		DataUtilities.getCumulativePercentages(keyedValues);

	}
	
	// this test covers maximum and minimum values for variable data
	@Test
	public void getCumulativePercentagesMinMaxTest() {
		mockery.checking(new Expectations() {
			{
				allowing(keyedValues).getItemCount();
				will(returnValue(2));
				allowing(keyedValues).getValue(0);
				will(returnValue(0));
				allowing(keyedValues).getValue(1);
				will(returnValue(Double.MAX_VALUE));
				allowing(keyedValues).getKey(0);
				will(returnValue(0));
				allowing(keyedValues).getKey(1);
				will(returnValue(1));
			}
		});

		KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);

		assertEquals(0.0, result.getValue(0));
		assertEquals(1.0, result.getValue(1));
	}
	
	@Test
	public void equalTest() {
		double[][] a = { { 1.0, -2.5, 3.5, 0 }, { -5.0, 6.5, 7.5, 8.5 } };
		double[][] b = { { 1.0, -2.5, 3.5, 0 }, { -5.0, 6.5, 7.5, 8.5 } };
		
		assertTrue(DataUtilities.equal(a, b));
	}
	
	@Test
	public void equalLengthTest() {
		double[][] a = { { 1.0, -2.5, 3.5, 0 } };
		double[][] b = { { 1.0, -2.5, 3.5, 0 }, { -5.0, 6.5, 7.5, 8.5 } };
		
		assertFalse(DataUtilities.equal(a, b));
	}
	
	@Test
	public void notEqualTest() {
		double[][] a = { { 1.0, -2.5, 3.5, 0 }, { -5.0, 6.5, 7.5, 8.5 } };
		double[][] b = { { 1.0, -2.5, 3.5, 3.5 }, { -5.0, 6.5, 7.5, 8.5 } };
		
		assertFalse(DataUtilities.equal(a, b));
	}
	
	@Test
	public void equalNullTest() {
		double[][] a = null;
		double[][] b = null;
		
		assertTrue(DataUtilities.equal(a, b));
	}
	
	@Test
	public void equalANullTest() {
		double[][] a = null;
		double[][] b = { { 1.0, -2.5, 3.5, 0 }, { -5.0, 6.5, 7.5, 8.5 } };
		
		assertFalse(DataUtilities.equal(a, b));
	}
	
	@Test
	public void equalBNullTest() {
		double[][] a = { { 1.0, -2.5, 3.5, 0 }, { -5.0, 6.5, 7.5, 8.5 } };
		double[][] b = null;
		
		assertFalse(DataUtilities.equal(a, b));
	}
	
	@Test
	public void cloneTest() {
		double[][] clone = { { 1.0, -2.5, 3.5, 0 }, null };
		double[][] result = DataUtilities.clone(clone);
		
		
		assertEquals(clone.length, result.length);

		for (int i = 0; i < clone.length - 1; i++) {
			
			assertEquals(clone[i].length, result[i].length);

			for (int j = 0; j < clone[i].length - 1; j++) {
				assertEquals(clone[i][j], result[i][j], .000000001d);
			}
		}
	}
	
	@Test
	public void calculateColumnTotalvalidRowsTest() {
		mockery.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(7.5));
				one(values).getValue(1, 0);
				will(returnValue(2.5));
			}
		});
		int[] validRows = {1, 2};
		
		double result = DataUtilities.calculateColumnTotal(values, 0, validRows);
		assertEquals(2.5, result, .000000001d);
	}
	
	@Test
	public void calculateColumnTotalvalidRowsNullTest() {
		mockery.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(7.5));
				one(values).getValue(1, 0);
				will(returnValue(null));
			}
		});
		int[] validRows = {0, 1};
		
		double result = DataUtilities.calculateColumnTotal(values, 0, validRows);
		assertEquals(7.5, result, .000000001d);
	}
	
	@Test
	public void calculateRowTotalvalidColsTest() {
		mockery.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(7.5));
				one(values).getValue(0, 1);
				will(returnValue(2.5));
			}
		});
		int[] validCols = {1, 2};
		
		double result = DataUtilities.calculateRowTotal(values, 0, validCols);
		assertEquals(2.5, result, .000000001d);
	}
	
	@Test
	public void calculateRowTotalvalidColsNullTest() {
		mockery.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(7.5));
				one(values).getValue(0, 1);
				will(returnValue(null));
			}
		});
		int[] validCols = {0, 1};
		
		double result = DataUtilities.calculateRowTotal(values, 0, validCols);
		assertEquals(7.5, result, .000000001d);
	}

	@Test
	public void getCumulativePercentagesNullValueTest() {
		mockery.checking(new Expectations() {
			{
				allowing(keyedValues).getItemCount();
				will(returnValue(2));
				allowing(keyedValues).getValue(0);
				will(returnValue(0));
				allowing(keyedValues).getValue(1);
				will(returnValue(null));
				allowing(keyedValues).getKey(0);
				will(returnValue(0));
				allowing(keyedValues).getKey(1);
				will(returnValue(1));
			}
		});

		KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);

		assertEquals(Double.NaN, result.getValue(0));
		assertEquals(Double.NaN, result.getValue(1));
	}
	
	//  Incremented (a++) integer local variable number 2
	@Test
	public void equalLoopMutationTest() {
		double[][] a = {{ 1.0, -2.5, 3.5, 0 }, { -5.0, 6.5, 7.5, 8.5 }};
		double[][] b = {{ 1.0, -2.5, 3.5, 0 }, { -5.0, 6.5, 7.5, 8.6 }};
		
		assertFalse(DataUtilities.equal(a, b));
	}
	
	// removed call to org/jfree/chart/util/ParamChecks::nullNotPermitted
	@Test(expected = IllegalArgumentException.class)
	public void cloneNullTest() {
		double[][] clone = null;
		double[][] result = DataUtilities.clone(clone);
	}
	
	// Negated integer local variable number 2; Incremented (a++) integer local variable number 2
	@Test
	public void cloneDifferentLengthTest() {
		double[][] clone = { { 1.0, -2.5, 3.5, 0 }, { -5.0, 6.5, 7.5, 8.5 }, {} };
		double[][] result = DataUtilities.clone(clone);
		
		
		assertEquals(clone.length, result.length);

		for (int i = 0; i < clone.length - 1; i++) {
			
			assertEquals(clone[i].length, result[i].length);

			for (int j = 0; j < clone[i].length - 1; j++) {
				assertEquals(clone[i][j], result[i][j], .000000001d);
			}
		}
	}
	
	// removed call to org/jfree/chart/util/ParamChecks::nullNotPermitted
	@Test(expected = IllegalArgumentException.class)
	public void calculateColumnTotalNullDataTest() {
		double result = DataUtilities.calculateColumnTotal(null, 0);
	}
	
	// Less than to not equal; Incremented (a++) integer local variable number 6
	@Test
	public void calculateColumnTotalInvalidRowTest() {
		mockery.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(-2));
				one(values).getValue(0, 0);
				will(returnValue(7.5));
				one(values).getValue(1, 0);
				will(returnValue(2.5));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(0, result, .000000001d);
	}
	
	// removed call to org/jfree/chart/util/ParamChecks::nullNotPermitted
	@Test(expected = IllegalArgumentException.class)
	public void calculateColumnTotalNullParamTest() {
		int[] validRows = {1, 2};
		double result = DataUtilities.calculateColumnTotal(null, 0, validRows);
	}
	
	// Negated double local variable number 3; Replaced double operation by second member;
	@Test
	public void calculateColumnTotalEmptyRowsTest() {
		mockery.checking(new Expectations() {
			{
				allowing(values).getRowCount();
				will(returnValue(2));
				allowing(values).getValue(0, 0);
				will(returnValue(7.5));
				allowing(values).getValue(1, 0);
				will(returnValue(2.5));
			}
		});

	    int[] validRows = {0, 0};
	    double result = DataUtilities.calculateColumnTotal(values, 0, validRows);
	    assertEquals(15, result, .000000001d);
	}

	// removed call to org/jfree/chart/util/ParamChecks::nullNotPermitted
	@Test(expected = IllegalArgumentException.class)
	public void calculateRowTotalNullParamTest() {	
		double result = DataUtilities.calculateRowTotal(null, 0);
	}
	
	// Less than to not equal; Negated integer local variable number 1
	@Test
	public void calculateRowTotalInvalidColTest() {
		mockery.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(-2));
				one(values).getValue(0, 0);
				will(returnValue(7.5));
				one(values).getValue(0, 1);
				will(returnValue(2.5));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(0, result, .000000001d);
	}
	
	// removed call to org/jfree/chart/util/ParamChecks::nullNotPermitted
	@Test(expected = IllegalArgumentException.class)
	public void calculateRowTotalNullDataTest() {	
		int[] validCols = {0, 1};
		double result = DataUtilities.calculateRowTotal(null, 0, validCols);
	}
	
	// Negated double local variable number 3; Replaced double operation by second member
	@Test
	public void calculateRowTotalEmptyColTest() {
		mockery.checking(new Expectations() {
			{
				allowing(values).getColumnCount();
				will(returnValue(2));
				allowing(values).getValue(0, 0);
				will(returnValue(7.5));
				allowing(values).getValue(0, 1);
				will(returnValue(2.5));
			}
		});
		int[] validCols = {0, 0};
		
		double result = DataUtilities.calculateRowTotal(values, 0, validCols);
		assertEquals(15, result, .000000001d);
	}
	
	// removed call to org/jfree/chart/util/ParamChecks::nullNotPermitted
	@Test(expected = IllegalArgumentException.class)
	public void getCumulativePercentagesEmptyDataTest() {
		KeyedValues result = DataUtilities.getCumulativePercentages(null);
	}
	
	// Less than to not equal
	@Test 
	public void getCumulativePercentagesInvalidItemTest() {
		mockery.checking(new Expectations() {
			{
				allowing(keyedValues).getItemCount();
				will(returnValue(-3));
				allowing(keyedValues).getValue(0);
				will(returnValue(5));
				allowing(keyedValues).getKey(0);
				will(returnValue(0));
			}
		});

		KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);

		assertEquals(new DefaultKeyedValues(), result);
	}
	
	// Decremented (a--) integer local variable number 1
	@Test
	public void createNumberArray2DNaNTest() {
		double[][] data = {{Double.NaN}};
		Number[][] result = DataUtilities.createNumberArray2D(data);

		assertArrayEquals(data, result);
	}

	// Negated integer local variable number 1
	@Test
	public void calculateRowTotalRowTwoTest() {
		mockery.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(3));
				one(values).getValue(1, 0);
				will(returnValue(0));
				one(values).getValue(1, 1);
				will(returnValue(1.5));
				one(values).getValue(1, 2);
				will(returnValue(2.5));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 1);
		assertEquals(4.0, result, .000000001d);
	}
	
	@After
	public void tearDown() throws Exception {
		mockery = null;
		values = null;
		keyedValues = null;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("DataUtilitiesTest completed.");
	}
}
