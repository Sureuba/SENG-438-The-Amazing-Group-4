package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.jfree.data.KeyedValues;

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

	@Test
	public void calculateColumnTotalZeroTest() {
		mockery.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(-7.5));
				one(values).getValue(1, 0);
				will(returnValue(7.5));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(0, result, .000000001d);
	}

	@Test
	public void calculateColumnTotalNullTest() {
		mockery.checking(new Expectations() {
			{
				one(values).getRowCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(null));
				one(values).getValue(1, 0);
				will(returnValue(7.5));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(7.5, result, .000000001d);
	}

	@Test
	public void calculateColumnTotalBothNullTest() {
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

	@Test(expected = InvalidParameterException.class)
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

	@Test
	public void calculateRowTotalZeroTest() {
		mockery.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(-7.5));
				one(values).getValue(0, 1);
				will(returnValue(7.5));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(0, result, .000000001d);
	}

	@Test
	public void calculateRowTotalNullTest() {
		mockery.checking(new Expectations() {
			{
				one(values).getColumnCount();
				will(returnValue(2));
				one(values).getValue(0, 0);
				will(returnValue(null));
				one(values).getValue(0, 1);
				will(returnValue(7.5));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals(7.5, result, .000000001d);
	}

	@Test
	public void calculateRowTotalBothNullTest() {
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

	@Test
	public void calculateRowTotalColumnOneTest() {
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

	@Test(expected = InvalidParameterException.class)
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

	@Test
	public void createNumberArrayTest() {
		double[] data = { 1.0, 2.5, 3.5, 4.5 };
		Number[] result = DataUtilities.createNumberArray(data);

		assertEquals(data.length, result.length);

		for (int i = 0; i < data.length; i++) {
			assertEquals(data[i], result[i].doubleValue(), .000000001d);
		}
	}

	@Test
	public void createNumberArrayEmptyTest() {
		double[] data = {};
		Number[] result = DataUtilities.createNumberArray(data);

		assertEquals(0, result.length);
	}

	@Test(expected = InvalidParameterException.class)
	public void createNumberArrayNullTest() {
		double[] data = null;
		DataUtilities.createNumberArray(data);
	}

	@Test
	public void createNumberArrayMixedValuesTest() {
		double[] data = { 1.0, -2.5, 0.0, 4.5, -3.5 };
		Number[] result = DataUtilities.createNumberArray(data);

		assertEquals(data.length, result.length);

		for (int i = 0; i < data.length; i++) {
			assertEquals(data[i], result[i].doubleValue(), .000000001d);
		}
	}

	@Test
	public void createNumberArray2DTest() {
		double[][] data = { { 1.0, 2.5, 3.5, 4.5 }, { 5.0, 6.5, 7.5, 8.5 } };
		Number[][] result = DataUtilities.createNumberArray2D(data);

		assertEquals(data.length, result.length);

		for (int i = 0; i < data.length; i++) {
			assertEquals(data[i].length, result[i].length);

			for (int j = 0; j < data[i].length; j++) {
				assertEquals(data[i][j], result[i][j].doubleValue(), .000000001d);
			}
		}
	}

	@Test
	public void createNumberArray2DEmptyTest() {
		double[][] data = {};
		Number[][] result = DataUtilities.createNumberArray2D(data);

		assertEquals(0, result.length);
	}

	@Test(expected = InvalidParameterException.class)
	public void createNumberArray2DNullTest() {
		double[][] data = null;
		DataUtilities.createNumberArray2D(data);
	}

	@Test
	public void createNumberArray2DMixedValuesTest() {
		double[][] data = { { 1.0, -2.5, 0.0, 4.5 }, { -3.5, 6.0, -7.0, 8.5 } };
		Number[][] result = DataUtilities.createNumberArray2D(data);

		assertEquals(data.length, result.length);

		for (int i = 0; i < data.length; i++) {
			assertEquals(data[i].length, result[i].length);

			for (int j = 0; j < data[i].length; j++) {
				assertEquals(data[i][j], result[i][j].doubleValue(), .000000001d);
			}
		}
	}

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

		assertEquals(0.0, result.getValue(0));
		assertEquals(0.0, result.getValue(1));
	}
	
	@Test
	public void getCumulativePercentagesOneTest() {
		mockery.checking(new Expectations() {
			{
				allowing(keyedValues).getItemCount();
				will(returnValue(2));
				allowing(keyedValues).getValue(0);
				will(returnValue(0));
				allowing(keyedValues).getValue(1);
				will(returnValue(123.5));
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

	@Test(expected = InvalidParameterException.class)
	public void getCumulativePercentagesNullTest() {
		mockery.checking(new Expectations() {
			{
				allowing(keyedValues).getItemCount();
				will(returnValue(null));
			}
		});

		DataUtilities.getCumulativePercentages(keyedValues);

	}
	
	@Test(expected = InvalidParameterException.class)
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
