/**
 *   File Name: DataHelper.java<br>
 *
 *   Malla, Isha<br>
 *   Created: Jan 30, 2017
 *
 */

package com.sqa.im.helpers;

/**
 * DataHelper //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Malla, Isha
 * @version 1.0.0
 * @since 1.0
 *
 */
public class DataHelper {

	public static String displayData(Object[][] data) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				sb.append(data[i][j] + "\t");
			}
		}
		return sb.toString();
	}

	private String dataString;

	// Constructor
	public DataHelper(Object[][] data) {
		this.dataString = displayData(data);
	}

	// Instance method (will need constructor that takes the Object[][])
	public String displayData() {
		return this.dataString;
	}

}
