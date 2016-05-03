package fxLauncher;

import postalCode.PostalCode;
import postalCode.PostalCodeIndex;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*	File Name: FXLauncher Class
 *	Course Name: Data Structures CST 8130
 *	Lab	Section:CST 8130-301
 *	Student	Name: Amaury Diaz Diaz
 *	Date: Jan-28-2015
 */
/*
 * References:(Rex Woollard (2015) personal communication)
 */
/*
 * This class contains the javaFX code that is going to display
 * the five lists sorted on a stage. 
 * Additional* a menu is created, so the user can select which list
 * he wants to see.  
 */

    
	/*
	 * This method contains the method main that runs the javaFX 
	 * application.
	 */
    public class FXLauncher extends Application {
    Stage stage = new Stage();
	private PostalCodeIndex postalCodeIndex = new PostalCodeIndex();
	public static void main(String[] args) {launch(args);}

	/*
	 * This method sets the stage on which the javaFX aplication
	 * is going to be shown, it is also the reponsible of sorting
	 * the ArrayLists in PostalCodeIndex class.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		postalCodeIndex.sort();
		stage = primaryStage;//so 5 different scenes can be created for each list.
		primaryStage.setTitle("Postal Code Analyzer");
		primaryStage.setFullScreen(true);
		Scene scene = codeShow();//codeShow is the first scene to be shown.
		primaryStage.setScene(scene);
		primaryStage.show();

	}//end of start(Stage primaryStage) method

	/*
	 * This method returns a menu bar which contains a menu that allows
	 * the user to make selections in the current javaFX application. As
	 * a consequence,  the user can select which sorted list he wants to 
	 * see, as well as exiting the application.
	 */
	public MenuBar buildPostalCodeIndexMenu() {
		
		final MenuItem exit = new MenuItem("Exit");
		exit.setOnAction(event -> System.exit(0));//user clicks the item, it exits.
		
		// Creating the File menu
		final Menu fileMenu = new Menu("_File");//This Menu only supports exit.
		fileMenu.getItems().addAll(exit);//add only the MenuItem "Exit"
		fileMenu.setMnemonicParsing(true);

		/*
		 * When the user clicks the MenuItem "Code" the
		 * scene returned from the codeShow method is going
		 * to be set on the stage.
		 */
		final MenuItem code = new MenuItem("_Code");
		code.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				stage.setScene(codeShow());
				stage.setFullScreen(true);
			}
		});
		code.setMnemonicParsing(true);
		
		/*
		 * When the user clicks the MenuItem "City" the
		 * scene returned from the cityShow method is going
		 * to be set on the stage.
		 */
		final MenuItem city = new MenuItem("_City");
		city.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				stage.setScene(cityShow());
				stage.setFullScreen(true);
			}
		});
		city.setMnemonicParsing(true);
		
		/*
		 * When the user clicks the MenuItem "Code" the
		 * scene returned from the provinceShow method is going
		 * to be set on the stage.
		 */
		final MenuItem province = new MenuItem("_Province");
		province.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				stage.setScene(provinceShow());
				stage.setFullScreen(true);
			}
		});
		province.setMnemonicParsing(true);
		
		/*
		 * When the user clicks the MenuItem "Code" the
		 * scene returned from the latitudeShow method is going
		 * to be set on the stage.
		 */
		final MenuItem latitude = new MenuItem("_Latitude");
		latitude.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				stage.setScene(latitudeShow());
				stage.setFullScreen(true);
			}
		});
		latitude.setMnemonicParsing(true);

		/*
		 * When the user clicks the MenuItem "Code" the
		 * scene returned from the longitudeShow method is going
		 * to be set on the stage.
		 */
		final MenuItem longitude = new MenuItem("_Longitude");
		longitude.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				stage.setScene(longitudeShow());
				stage.setFullScreen(true);
			}
		});
		longitude.setMnemonicParsing(true);

		// Creating the Sort Menu
		final Menu sortMenu = new Menu("_Sort By");
		sortMenu.getItems().addAll(code, city, province, latitude, longitude);//add the mentioned MenuItems to the menu
		sortMenu.setMnemonicParsing(true);

		//Creating a Menu Bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, sortMenu);//Adding File and Sort Menu to the Menu bar
		return menuBar;
	} // end buildPostalCodeIndexMenu()

	/*
	 * This method returns a scene which contains the list of Postal Codes
	 * sorted by postal Code as well as the menu bar which allows the user
	 * to see any list that he wants.
	 */
	public Scene codeShow() {
		ListView<PostalCode> listCodeOrder = new ListView<>(
				postalCodeIndex.getCodeOrderList());//listView of the codeOrderList arrayList
		VBox vBox = new VBox(buildPostalCodeIndexMenu(), new Text(
				"Sorted by Postal Code"));
		HBox hBox = new HBox(listCodeOrder);
		vBox.getChildren().addAll(hBox);//Hbox is going to be contained inside the VBox 
		HBox.setHgrow(listCodeOrder, Priority.ALWAYS);//show full horizontally
		VBox.setVgrow(hBox, Priority.ALWAYS);//show full vertically
		return new Scene(vBox);
	}//end codeShow()

	/*
	 * This method returns a scene which contains the list of Postal Codes
	 * sorted by city as well as the menu bar which allows the user
	 * to see any list that he wants.
	 */
	public Scene cityShow() {
		ListView<PostalCode> listCityOrder = new ListView<>(
				postalCodeIndex.getCityOrderList());//listView of the cityOrderList arrayList
		VBox vBox = new VBox(buildPostalCodeIndexMenu(), new Text(
				"Sorted by City"));
		HBox hBox = new HBox(listCityOrder);
		vBox.getChildren().addAll(hBox);//Hbox is going to be contained inside the VBox
		HBox.setHgrow(listCityOrder, Priority.ALWAYS);//show full horizontally
		VBox.setVgrow(hBox, Priority.ALWAYS);//show full vertically
		return new Scene(vBox);
	}//end cityShow()

	/*
	 * This method returns a scene which contains the list of Postal Codes
	 * sorted by province as well as the menu bar which allows the user
	 * to see any list that he wants.
	 */
	public Scene provinceShow() {
		ListView<PostalCode> listProvinceOrder = new ListView<>(
				postalCodeIndex.getProvinceOrderList());//listView of the provinceOrderList arrayList
		VBox vBox = new VBox(buildPostalCodeIndexMenu(), new Text(
				"Sorted by Province"));
		HBox hBox = new HBox(listProvinceOrder);
		vBox.getChildren().addAll(hBox);//Hbox is going to be contained inside the VBox
		HBox.setHgrow(listProvinceOrder, Priority.ALWAYS);//show full horizontally
		VBox.setVgrow(hBox, Priority.ALWAYS);//show full vertically
		return new Scene(vBox);
	}//end provinceShow()

	/*
	 * This method returns a scene which contains the list of Postal Codes
	 * sorted by latitude as well as the menu bar which allows the user
	 * to see any list that he wants.
	 */
	public Scene latitudeShow() {
		ListView<PostalCode> listLatitudeOrder = new ListView<>(
				postalCodeIndex.getLatitudeOrderList());//listView of the latitudeOrderList arrayList
		VBox vBox = new VBox(buildPostalCodeIndexMenu(), new Text(
				"Sorted by Latitude"));
		HBox hBox = new HBox(listLatitudeOrder);
		vBox.getChildren().addAll(hBox);//Hbox is going to be contained inside the VBox
		HBox.setHgrow(listLatitudeOrder, Priority.ALWAYS);//show full horizontally
		VBox.setVgrow(hBox, Priority.ALWAYS);//show full vertically
		return new Scene(vBox);
	}//end latitudeShow()
	
	/*
	 * This method returns a scene which contains the list of Postal Codes
	 * sorted by longitude as well as the menu bar which allows the user
	 * to see any list that he wants.
	 */
	public Scene longitudeShow() {
		ListView<PostalCode> listLongitudeOrder = new ListView<>(
				postalCodeIndex.getLongitudeOrderList());//listView of the longitudeOrderList arrayList
		VBox vBox = new VBox(buildPostalCodeIndexMenu(), new Text(
				"Sorted by Longitude"));
		HBox hBox = new HBox(listLongitudeOrder);
		vBox.getChildren().addAll(hBox);//Hbox is going to be contained inside the VBox
		HBox.setHgrow(listLongitudeOrder, Priority.ALWAYS);//show full horizontally
		VBox.setVgrow(hBox, Priority.ALWAYS);//show full vertically
		return new Scene(vBox);
	}//end longitudeShow()

}//end FXLauncher class
