package postalCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;

import postalCode.PostalCode.CompareCity;
import postalCode.PostalCode.CompareCode;
import postalCode.PostalCode.CompareLatitude;
import postalCode.PostalCode.CompareLongitude;
import postalCode.PostalCode.CompareProvince;
import javafx.collections.*;

/*	File Name: PostalCodeIndex Class
 *	Course Name: Data Structures CST 8130
 *	Lab	Section:CST 8130-301
 *	Student	Name: Amaury Diaz Diaz
 *	Date: Jan-28-2015
 */
/*
 * References:(Rex Woollard (2015) personal communication)
 */
/*
 * This class is the core of the whole program. It reads the Postal Code
 * data from a file and then it adds it to an ArrayList. Then initializes
 * 4 other ArrayLists which point to the same objects contained in the
 * first ArrayList(codeOrderList). It also contains a method that sorts
 * the ArrayLists based on different comparators.
 */
public class PostalCodeIndex {
	private ObservableList<PostalCode> codeOrderList = FXCollections
			.observableList(new ArrayList<>());//ObservableList of PostalCode objects
	private ObservableList<PostalCode> cityOrderList;
	private ObservableList<PostalCode> provinceOrderList;
	private ObservableList<PostalCode> latitudeOrderList;
	private ObservableList<PostalCode> longitudeOrderList;

	/*
	 * This method returns an ObservableList codeOrderList
	 */
	public ObservableList<PostalCode> getCodeOrderList() {
		return FXCollections.unmodifiableObservableList(codeOrderList);
	}//end of getCodeOrderList()

	/*
	 * This method returns an ObservableList cityOrderList
	 */
	public ObservableList<PostalCode> getCityOrderList() {
		return FXCollections.unmodifiableObservableList(cityOrderList);
	}//end of getCityOrderList()

	/*
	 * This method returns an ObservableList proviceOrderList
	 */
	public ObservableList<PostalCode> getProvinceOrderList() {
		return FXCollections.unmodifiableObservableList(provinceOrderList);
	}//end of getProvinceOrderList()

	/*
	 * This method returns an ObservableList latitudeOrderList
	 */
	public ObservableList<PostalCode> getLatitudeOrderList() {
		return FXCollections.unmodifiableObservableList(latitudeOrderList);
	}//end of getLatitudeOrderList()

    /*
	 * This method returns an ObservableList longitudeOrderList
	 */
	public ObservableList<PostalCode> getLongitudeOrderList() {
		return FXCollections.unmodifiableObservableList(longitudeOrderList);
	}//end of getLongitudeOrderList

    /*
	 * This constructor reads the data from the file and adds it to PostalCode
	 * objects. Then it adds the the PostalCode Object to an ObservableList
	 * (codeOrderList) and initializes the other 4 ObservableList to have the same 
	 * content as codeOrderList does.
	 */
	public PostalCodeIndex() {
		File file = new File("postal_codes.csv");
		try (BufferedReader input = Files.newBufferedReader(file.toPath())) {
			String inputLine = input.readLine();
			while ((inputLine = input.readLine()) != null) {// watch for the end of file looking for null											
				PostalCode postalCode = new PostalCode(inputLine);
				codeOrderList.add(postalCode);
			}//end of while

		} catch (IOException e) {
			e.printStackTrace();
		}//end of catch
		cityOrderList = FXCollections.observableList(new ArrayList<PostalCode>(
				codeOrderList));
		provinceOrderList = FXCollections
				.observableList(new ArrayList<PostalCode>(codeOrderList));
		latitudeOrderList = FXCollections
				.observableList(new ArrayList<PostalCode>(codeOrderList));
		longitudeOrderList = FXCollections
				.observableList(new ArrayList<PostalCode>(codeOrderList));

	}//end of PostalCodeIndex() constructor

	/*
	 * This method sorts the ObservableLists using the respective
	 * comparator for each one.
	 */
	public void sort() {
		long startTime = System.currentTimeMillis();
		FXCollections.sort(codeOrderList, CompareCode.instance);
		FXCollections.sort(cityOrderList, CompareCity.instance);
		FXCollections.sort(provinceOrderList, CompareProvince.instance);
		FXCollections.sort(latitudeOrderList, CompareLatitude.instance);
		FXCollections.sort(longitudeOrderList, CompareLongitude.instance);
		System.out.printf("Copied ArrayList: %.3f seconds%n",
				(double) (System.currentTimeMillis() - startTime) / 1000.0);//time to sort all the ObservableLists.

	}//end of sort()

}//end of PostalCodeIndex()
