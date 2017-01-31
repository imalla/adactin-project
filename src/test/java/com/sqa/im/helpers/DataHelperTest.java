package com.sqa.im.helpers;

import org.testng.*;
import org.testng.annotations.*;

public class DataHelperTest {
	// @Test(dataProvider = "dp")
	// public void test(Object [] data) {
	// }

	// @DataProvider
	// public Object[][] dp() {
	// return new Object[][] {
	// new Object[] { 3, 5, 4, 1 },
	// new Object[] { 3, 5, 4, 1 },
	// }

	public Object[][] dp() {
		return new Object[][] { { 3, 5, 4, 1 }, { 3.1, 5.55, 4.1, 1.3 }, { "3", "5", "4", "1" },
				{ '3', '5', '4', '1' } };

	}

	@Test // (dataProvider="dp")
	public void testDataHelper() {
		Object[][] data = dp();
		String expected = "\n3	5	4	1\n" + "3.1	5.55	4.1	1.3\n" + " 3 5	4	1\n" + "3 5	4	1\n	]";
		String actual = DataHelper.displayData(data);
		System.out.println();
		Assert.assertEquals(actual, expected, "does not work correctly");
	}
}
