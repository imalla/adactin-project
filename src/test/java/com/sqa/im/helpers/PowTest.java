package com.sqa.im.helpers;

import org.testng.*;
import org.testng.annotations.*;

public class PowTest {

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, 2, 1 }, new Object[] { 2, 2, 4 }, new Object[] { 2, 8, 256 },
				new Object[] { 0, 4, 0 }, new Object[] { -3, 2, 9 }, new Object[] { 3, 3, 27 } };
	}

	@Test(dataProvider = "dp")
	public void testSquareNonStaticMethod(int number, int power, int expected) {
		QAMath math = new QAMath();
		math.addNumber(number);
		math.square(power);
		int actual = math.getTotal();
		Assert.assertEquals(actual, expected);
	}

	@Test(dataProvider = "dp")
	public void testSquareStaticMethod(double num, double power, double expected) {
		double actual = QAMath.square(num, power);
		Assert.assertEquals(actual, expected);
	}
}