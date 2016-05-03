package postalCode;

import static org.junit.Assert.*;
import org.junit.Test;

/*	File Name: PostalCodeTest JUnit Test Case
 *	Course Name: Data Structures CST 8130
 *	Lab	Section:CST 8130-301
 *	Student	Name: Amaury Diaz Diaz
 *	Date: Jan-28-2015
 */
/*
 * References:(Rex Woollard (2015) personal communication)
 */
/*
 * This class tests the five comparators used to sort the postal codes
 * (based on the city, province, longitude, latitude and postal code
 * itself) work correctly.
 */
public class PostalCodeTest {
	/*
	 * This method tests that the postal codes are correctly sorted based
	 * on the postal code. First we must verify if the PostalCode objects
	 * were correctly sorted, and then we must verify that no object was
	 * lost during the sorting. 
	 */
	@Test
	public void testSortCode() {
		
		PostalCodeIndex postalCodeIndex = new PostalCodeIndex();
		long before = 0;//used to store the sum of all the hashcodes before the sorting
		long after = 0;//used to store the sum of all the hashcodes after the sorting
		PostalCode previous = null; // used to compare adjacent PostalCode
		
		/*
		 * iterates the ArrayList adding all the PostalCode objects hashCodes
		 * before sorting.
		 */
		for (PostalCode beforeSort : postalCodeIndex.getCodeOrderList()) {
			before += beforeSort.hashCode();
		}//end for
		
		postalCodeIndex.sort();//sort the codeOrderList
		
		/*
		 * iterates comparing the current object with the previous one.
		 */
		for (PostalCode current : postalCodeIndex.getCodeOrderList()) {
			if (previous == null) { //the first time previous and current are the same.
				previous = current;
				continue;
			} // end if
			assertTrue(previous.getCode().compareTo(current.getCode()) <= 0);
			previous = current;

		} // end for

		/*
		 * iterates the ArrayList adding all the PostalCode objects hashCodes
		 * after sorting.
		 */
		for (PostalCode afterSort : postalCodeIndex.getCodeOrderList()) {
			after += afterSort.hashCode();
		}//end for
		assertEquals(before, after);
	} // end testSortCode()

	
	/*
	 * This method tests that the postal codes are correctly sorted based
	 * on the city. First we must verify if the PostalCode objects
	 * were correctly sorted, and then we must verify that no object was
	 * lost during the sorting. 
	 */
	@Test
	public void testSortCity() {
		PostalCodeIndex postalCodeIndex = new PostalCodeIndex();
		long before = 0;//used to store the sum of all the hashcodes before the sorting.
		long after = 0;//used to store the sum of all the hashcodes after the sorting.
		PostalCode previous = null; // used to compare adjacent PostalCode
		
		/*
		 * iterates the ArrayList adding all the PostalCode objects hashCodes
		 * before sorting.
		 */
		for (PostalCode beforeSort : postalCodeIndex.getCityOrderList()) {
			before += beforeSort.hashCode();
		}//end for
		
		postalCodeIndex.sort();//sort the cityOrderList
		
		/*
		 * iterates comparing the current object with the previous one.
		 */
		for (PostalCode current : postalCodeIndex.getCityOrderList()) {
			if (previous == null) { //the first time previous and current are the same.
				previous = current;
				continue;
			} // end if
			assertTrue(previous.getCity().compareTo(current.getCity()) <= 0);
			previous = current;

		} // end for
		/*
		 * iterates the ArrayList adding all the PostalCode objects hashCodes
		 * after sorting.
		 */
		for (PostalCode afterSort : postalCodeIndex.getLatitudeOrderList()) {
			after += afterSort.hashCode();
		}//end for
		assertEquals(before, after);
	} // end testSortCity()


	/*
	 * This method tests that the postal codes are correctly sorted based
	 * on the province. First we must verify if the PostalCode objects
	 * were correctly sorted, and then we must verify that no object was
	 * lost during the sorting. 
	 */
	@Test
	public void testSortProvince() {
		PostalCodeIndex postalCodeIndex = new PostalCodeIndex();
		long before = 0;//used to store the sum of all the hashcodes before the sorting.
		long after = 0;//used to store the sum of all the hashcodes after the sorting.
		PostalCode previous = null; // used to compare adjacent PostalCode
		
		/*
		 * iterates the ArrayList adding all the PostalCode objects hashCodes
		 * before sorting.
		 */
		for (PostalCode beforeSort : postalCodeIndex.getProvinceOrderList()) {
			before += beforeSort.hashCode();
		}//end for
		
		postalCodeIndex.sort();//sort the provinceOrderList
		
		/*
		 * iterates comparing the current object with the previous one.
		 */
		for (PostalCode current : postalCodeIndex.getProvinceOrderList()) {
			if (previous == null) { //the first time previous and current are the same.
				previous = current;
				continue;
			} // end if
			assertTrue(previous.getProvince().compareTo(current.getProvince()) <= 0);
			previous = current;
		} // end for

		/*
		 * iterates the ArrayList adding all the PostalCode objects hashCodes
		 * after sorting.
		 */
		for (PostalCode afterSort : postalCodeIndex.getProvinceOrderList()) {
			after += afterSort.hashCode();
		}//end for
		assertEquals(before, after);
	} // end testSortProvince()
	
	/*
	 * This method tests that the postal codes are correctly sorted based
	 * on the latitude. First we must verify if the PostalCode objects
	 * were correctly sorted, and then we must verify that no object was
	 * lost during the sorting. 
	 */
	@Test
	public void testSortLatitude() {
		PostalCodeIndex postalCodeIndex = new PostalCodeIndex();
		long before = 0;//used to store the sum of all the hashcodes before the sorting.
		long after = 0;//used to store the sum of all the hashcodes after the sorting.
		PostalCode previous = null; // used to compare adjacent PostalCode
		
		/*
		 * iterates the ArrayList adding all the PostalCode objects hashCodes
		 * before sorting.
		 */
		for (PostalCode beforeSort : postalCodeIndex.getLatitudeOrderList()) {
			before += beforeSort.hashCode();
		}//end for
		
		postalCodeIndex.sort();//sort latitudeOrderList
		
		/*
		 * iterates comparing the current object with the previous one.
		 */
		for (PostalCode current : postalCodeIndex.getLatitudeOrderList()) {
			if (previous == null) { //the first time previous and current are the same.
				previous = current;
				continue;
			} // end if
			assertTrue(previous.getLatitude() <= current.getLatitude());
			previous = current;
		} // end for

		/*
		 * iterates the ArrayList adding all the PostalCode objects hashCodes
		 * after sorting.
		 */
		for (PostalCode afterSort : postalCodeIndex.getLatitudeOrderList()) {
			after += afterSort.hashCode();
		}//end for
		assertEquals(before, after);
	} // end testSortLatitude()

	/*
	 * This method tests that the postal codes are correctly sorted based
	 * on the longitude. First we must verify if the PostalCode objects
	 * were correctly sorted, and then we must verify that no object was
	 * lost during the sorting. 
	 */
	@Test
	public void testSortLongitude() {
		PostalCodeIndex postalCodeIndex = new PostalCodeIndex();
		long before = 0;//used to store the sum of all the hashcodes before the sorting.
		long after = 0;//used to store the sum of all the hashcodes after the sorting.
		PostalCode previous = null; // used to compare adjacent PostalCode
		
		/*
		 * iterates the ArrayList adding all the PostalCode objects hashCodes
		 * before sorting.
		 */
		for (PostalCode beforeSort : postalCodeIndex.getLongitudeOrderList()) {
			before += beforeSort.hashCode();
		}//end for
		
		postalCodeIndex.sort();//sort longitudeOrderList
		
		/*
		 * iterates comparing the current object with the previous one.
		 */
		for (PostalCode current : postalCodeIndex.getLongitudeOrderList()) {
			if (previous == null) { //the first time previous and current are the same.
				previous = current;
				continue;
			} // end if
			assertTrue(previous.getLongitude() <= current.getLongitude());
			previous = current;
		} // end for

		/*
		 * iterates the ArrayList adding all the PostalCode objects hashCodes
		 * after sorting.
		 */
		for (PostalCode afterSort : postalCodeIndex.getLatitudeOrderList()) {
			after += afterSort.hashCode();
		}//end for
		assertEquals(before, after);
	} // end testSortLongitude()
}
