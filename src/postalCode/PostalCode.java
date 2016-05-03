package postalCode;

import java.util.Comparator;

/*	File Name: PostalCode Class
 *	Course Name: Data Structures CST 8130
 *	Lab	Section:CST 8130-301
 *	Student	Name: Amaury Diaz Diaz
 *	Date: Jan-28-2015
 */
/*
 * References:(Rex Woollard (2015) personal communication)
 */
/*
 * This class contains the postal codes with its respective city,
 * province,latitude and longitude. It also contains the static 
 * comparator classes used by the sorting methods in the
 * PostalCodeIndex. 
 */
public class PostalCode {

	private String code;
	private String city;
	private String province;
	private double latitude;
	private double longitude;
	
	/*
	 * This constructor takes a string as a parameter and then
	 * uses the split method to separate each string and initialize
	 * each variable.
	 */
	public PostalCode(String inputLine) {
		String[] fields = inputLine.split("\\||\\r\\n");
		code = fields[1];
		city = fields[2].intern();
		province = fields[3].intern();
		latitude = Double.parseDouble(fields[6]);
		longitude = Double.parseDouble(fields[7]);
	}//end of PostalCode(String)
	
    /*
     * This method returns a formatted string.
     */
	@Override
	public String toString() {
		return String.format("%s %s %s %f %f", code, city, province, latitude,
				longitude);
	}//end of toString()
  
    /*
     * This method returns a String that represents the postal code
     */
	public String getCode() {
		return code;
	}//end of getCode()
    
	/*
     * This method returns a String that represents the city
     */
	public String getCity() {
		return city;
	}//end of getCity()

	/*
     * This method returns a String that represents the province
     */
	public  String getProvince() {
		return province;
	}//end of getProvince()

	/*
     * This method returns a double that represents the latitude
     */
	public double getLatitude() {
		return latitude;
	}//end of getLatitude()

	/*
     * This method returns a double that represents the longitude
     */
	public double getLongitude() {
		return longitude;
	}//end of Longitude 
	
	/*
	 * This static nested class compares the postal code based on the 
	 * postal code. 
	 */
	public static class CompareCode implements Comparator<PostalCode>{
		// No CompareTitle object will be created if instance variable never used.
		public final static CompareCode instance = new CompareCode();
		
		private CompareCode(){}// private keyword prevents creation of CompareTitle objects outside the class
		
		@Override
		
		public int compare(PostalCode pc1, PostalCode pc2){
			return pc1.code.compareTo(pc2.code);
		}//end compare()
	}//end of CompareCode class

	/*
	 * This static nested class compares the postal code based on the 
	 * city. 
	 */
	public static class CompareCity implements Comparator<PostalCode> {
		// No CompareTitle object will be created if instance variable never used.
		public final static CompareCity instance = new CompareCity(); 

		private CompareCity() {} // private keyword prevents creation of CompareTitle objects outside the class

		@Override
		public int compare(PostalCode pc1, PostalCode pc2) {
			return pc1.city.compareTo(pc2.city);
		}//end of compare()
	} // end class CompareCity

	/*
	 * This static nested class compares the postal code based on the 
	 * province. 
	 */
	public static class CompareProvince implements Comparator<PostalCode> {
		// No CompareTitle object will be created if instance variable never used.
		public final static CompareProvince instance = new CompareProvince(); 

		private CompareProvince() {} // private keyword prevents creation of CompareTitle objects outside the class
		
		@Override
		public int compare(PostalCode pc1, PostalCode pc2) {
			return pc1.province.compareTo(pc2.province);
			
		}//end of compare()
	} // end class CompareTitle

	/*
	 * This static nested class compares the postal code based on the 
	 * latitude. 
	 */
	public static class CompareLatitude implements Comparator<PostalCode> {
		// No CompareTitle object will be created if instance variable never used.
		public final static CompareLatitude instance = new CompareLatitude(); 

		private CompareLatitude() {} // private keyword prevents creation of CompareTitle objects outside the class

		@Override
		public int compare(PostalCode pc1, PostalCode pc2) {
			if (pc1.latitude < pc2.latitude){
				return -1;
			}//end of if
			else if (pc1.latitude > pc2.latitude){
				return 1;
			}//end of else if
			else{
			return 0;
			}//end of else
		}//end of compare()
	}//end of CompareLatitude class

	/*
	 * This static nested class compares the postal code based on the 
	 * longitude. 
	 */
	public static class CompareLongitude implements Comparator<PostalCode> {
		// No CompareTitle object will be created if instance variable never used.
		public final static CompareLongitude instance = new CompareLongitude();

		private CompareLongitude() {} // private keyword prevents creation of CompareTitle objects outside the class

		@Override
		public int compare(PostalCode pc1, PostalCode pc2) {
			if (pc1.longitude < pc2.longitude){
				return -1;
			}//end of if
			else if (pc1.longitude > pc2.longitude){
				return 1;
			}//end of else if
			else{
			return 0;
			}//end of else
		}//end of compare()
	}//end of CompareLongitude class
}//end of PostalCode class
