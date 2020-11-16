package application;

//import com.sun.tools.javac.util.StringUtils;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Arrays;

import javax.imageio.ImageIO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Node;

public class MainController {
	
	static Double price;
	static int numOfIngredientsSelected;
	static Order order;
	
	@FXML
	ComboBox sandwichCombo;
	
	@FXML
	ListView<String> ingredientsList;
	
	@FXML
	ListView<String> extraIngredientsList;
	
	@FXML
	ImageView sandwichImage;
	
	@FXML
	Button addButton;
	
	@FXML
	Button removeButton;
	
	@FXML
	Button clearButton;
	
	@FXML
	ListView<String> selectedIngredientsList;
	                    
	@FXML
	TextField priceText;
	
	@FXML
	Button addToOrderButton;
	
	@FXML
	Button showOrderButton;
	
	@FXML
	TextArea messageTextArea;
	
	@FXML
	private Scene secondScene;
	
	/*controller2.setView1Controller(this);
	controller2.otherMethod();
	
	MainController passMainController() {
		return this;
	}*/
	
	@FXML
	void initialize() {
		//Image fishImage = new Image("file: Chicken.png");
		//System.out.println("Main controller running");
		String [] chickenIngredients = {"Fried Chicken", "Spicy Sauce", "Pickles"};
		ingredientsToListView(chickenIngredients);
		price = 8.99;
		numOfIngredientsSelected = 0;
		if(order == null) {
			order = new Order();

		}
		setSandwichPrice();
		extraIngredientsToListView();
		extraIngredientsList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		selectedIngredientsList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	}
	
	void extraIngredientsToListView() {
		try {
			extraIngredientsList.getItems().clear();
			
			String [] extraIngredients = {"Onion", "Bacon", "Spinach", "Pickles", "American", "Swiss", "Lettuce", "Mushrooms", "Provolone", "Tomatoes"};
			
			for(int i = 0 ; i < extraIngredients.length; i++) {
				extraIngredientsList.getItems().add(extraIngredients[i]);
			}
		}
		
		catch (Exception e) {
			messageTextArea.appendText("Error occurred listing extra ingredients\n");
			return;
		}
		
		
	}
	
	@FXML
	void showOrder(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ControllerTwo.fxml"));
			Parent root = loader.load();
			
			
			SecondController controller2 = loader.getController();
			
			//controller2.setView1Controller(this);
			//controller2.getOrderDetails(order);
			
			//Stage stage = new Stage();
	        /*stage.setScene(new Scene(root));
	        stage.setTitle("Order Detials");
	        stage.show();*/
			
			Scene scene2 = new Scene(root);
			
			Stage primaryStage = (Stage)(((Node)actionEvent.getSource()).getScene().getWindow());
		
	        primaryStage.setScene(scene2);
	        primaryStage.show();
	        }
		catch (Exception e) {
			messageTextArea.appendText("Error occurred showing order\n");
			return;
		}
		
	}
	
	@FXML
	void addSelectedIngredientToListView(ActionEvent actionEvent) {
		
		try {
			ObservableList<String> selectedIngredient = FXCollections.observableArrayList(extraIngredientsList.getSelectionModel().getSelectedItems());
			//messageTextArea.appendText(selectedIngredient + "\n");

			if(selectedIngredient.size() == 0) {
				messageTextArea.appendText("No ingredient selected to add\n");
				return;
			}
			if(selectedIngredientsList.getItems().size() == 6) {
				extraIngredientsList.setDisable(true);
				messageTextArea.appendText("Maximum limit for extra ingredients reached (6)\n");
				return;
			}
			
			else {
			extraIngredientsList.setDisable(false);
			
			
				for(String i : selectedIngredient) {
					
					if(selectedIngredientsList.getItems().size() == 6) {
						messageTextArea.appendText("Maximum limit for extra ingredients reached (6)\n");
						extraIngredientsList.setDisable(true);

						return;
					}
					
					numOfIngredientsSelected++;
					updateSandwichPrice(true);
					selectedIngredientsList.getItems().add(i);
					extraIngredientsList.getItems().remove(i);

					messageTextArea.appendText(i + " added\n");

				}
				
				if(selectedIngredientsList.getItems().size() == 6) {
					messageTextArea.appendText("Maximum limit for extra ingredients reached (6)\n");
					extraIngredientsList.setDisable(true);

					return;
				}
				
				return;
			}	
		}
		
		catch (Exception e) {
			messageTextArea.appendText("Error occurred listing extra ingredients\n");
			return;
		}
		
	}
	
	@FXML
	void removeSelectedIngredientToListView(ActionEvent actionEvent) {
		
		try {
			ObservableList<String> selectedIngredient = FXCollections.observableArrayList(selectedIngredientsList.getSelectionModel().getSelectedItems());
			
			if(selectedIngredient.size() == 0) {
				messageTextArea.appendText("No ingredient selected to remove\n");
				return;
			}
			
			if(selectedIngredientsList.getItems().size() == 0) {
				messageTextArea.appendText("No ingredient available to remove\n");
				return;
			}

			
			else {
			extraIngredientsList.setDisable(false);
			
			//messageTextArea.appendText(selectedIngredient + "\n");
			
				for(String i : selectedIngredient) {
					updateSandwichPrice(false);

					numOfIngredientsSelected--;

					selectedIngredientsList.getItems().remove(i);
					extraIngredientsList.getItems().add(i);

					messageTextArea.appendText(i + " removed\n");
				}
				
				return;
			}	
		}
		
		catch (Exception e) {
			messageTextArea.appendText("Error occurred removing extra ingredients\n");
			return;
		}
		
	}
	
	@FXML
	void clearSelectedIngredientToListView(ActionEvent actionEvent) {
		
		try {
			ObservableList<String> selectedIngredient = FXCollections.observableArrayList(selectedIngredientsList.getItems());
			
			if(selectedIngredient.size() == 0) {
				messageTextArea.appendText("No ingredients to remove\n");
				return;
			}
			
			if(selectedIngredientsList.getItems().size() == 0) {
				messageTextArea.appendText("No ingredients available to remove\n");
				return;
			}

			
			else {
			extraIngredientsList.setDisable(false);
			
			//messageTextArea.appendText(selectedIngredient + "\n");
			
				for(String i : selectedIngredient) {
					
					updateSandwichPrice(false);
					numOfIngredientsSelected--;

					selectedIngredientsList.getItems().remove(i);
					extraIngredientsList.getItems().add(i);

					//messageTextArea.appendText(i + " removed\n");
				}
				
				return;
			}	
		}
		
		catch (Exception e) {
			messageTextArea.appendText("Error occurred removing extra ingredients\n");
			return;
		}
		
	}
	
	void ingredientsToListView(String [] ingredients) {
		ingredientsList.getItems().clear();
		
		for(int i = 0 ; i < ingredients.length; i++) {
			ingredientsList.getItems().add(ingredients[i]);
		}
		
	}
	
	@FXML
	void sandwichSelected(ActionEvent actionEvent) {
		
		try {
			String selected = (String) sandwichCombo.getSelectionModel().getSelectedItem();
			messageTextArea.appendText(selected + " Selected\n");
			
			String [] chickenIngredients = {"Fried Chicken", "Spicy Sauce", "Pickles"};
			String [] beefIngredients = {"Roast Beef", "Provolone Cheese", "Mustard"};
			String [] fishIngredients = {"Grilled Snapper", "Cilantro", "Lime"};

			setSandwichImage(actionEvent);

			if(selected.equals("Chicken")) {
				ingredientsToListView(chickenIngredients);
				setSandwichPrice();
				return;
			}
			
			else if(selected.equals("Beef")) {
				ingredientsToListView(beefIngredients);
				setSandwichPrice();
				return;
			}
			
			else {
				ingredientsToListView(fishIngredients);
				setSandwichPrice();
				return;

			}
			
		}
		
		catch (Exception e) {
			messageTextArea.appendText("Error occurred selecting sandwich\n");
			return;
		}
		
	}
	
	@FXML
	void setSandwichImage(ActionEvent actionEvent) {
		
		try {
			String selected = (String) sandwichCombo.getSelectionModel().getSelectedItem();
			//messageTextArea.appendText(selected + " Selected\n");
			
		
			Image chickenImage = new Image("file: @../../Chicken.png");
			Image beefImage = new Image("file: @../../Beef.png");
			
			
			Image fishImage = new Image("file: @../../Fish.png");


			
			if(selected.equals("Chicken")) {
				sandwichImage.setImage(chickenImage);
			}
			
			else if(selected.equals("Beef")) {
				sandwichImage.setImage(beefImage);
			}
			
			else {
				sandwichImage.setImage(fishImage);

			}
		}
		
		catch (Exception e) {
			messageTextArea.appendText("Error occurred with sandwich image\n");
			return;
		}
		
	}
	
	@FXML
	void addToOrder(ActionEvent actionEvent) {
		
		try {
			String selected = (String) sandwichCombo.getSelectionModel().getSelectedItem();
			//messageTextArea.appendText(selected + " Selected\n");
			Sandwich sandwich;
			Double totalPrice = Double.parseDouble(priceText.getText());
			ObservableList<String> selectedIngredient = FXCollections.observableArrayList(selectedIngredientsList.getItems());
			//messageTextArea.appendText(totalPrice + "\n");
			//messageTextArea.appendText(selectedIngredient + "\n");

			
			
			if(selected.equals("Chicken")) {
				sandwich = new Chicken();
			}
			
			else if(selected.equals("Beef")) {
				sandwich = new Beef();

			}
			
			else {
				sandwich = new Fish();

			}
			
			for(String i : selectedIngredient) {
				Extra extra = new Extra(i);
				//messageTextArea.appendText(i + "\n");
				sandwich.extras.add(extra);
				//messageTextArea.appendText( extra.toString() + " added to " + sandwich.getSandwichType() + "\n");

			}
			
			OrderLine orderLine = new OrderLine(order.addLineNumber(), sandwich, totalPrice);
			order.add(orderLine);
			
			
			messageTextArea.appendText(sandwich.toString() + "\n");

			messageTextArea.appendText("Order added\n\n");
			
			
			//sandwichCombo.setSelectedItem("Chicken");
			sandwichCombo.setValue((String)"Chicken");
			clearSelectedIngredientToListView(actionEvent);
	
		}
	
		catch (Exception e) {
			messageTextArea.appendText("Error adding to order\n");
			return;
		}

		
	}
	
	void setSandwichPrice() {
		try {
			String selected = (String) sandwichCombo.getSelectionModel().getSelectedItem();
			if(selected.equals("Chicken")) {
				price = 8.99;
			}
			
			else if(selected.equals("Beef")) {
				price = 10.99;

			}
			
			else {
				price = 12.99;

			}
				Double extrasAmount = numOfIngredientsSelected * 1.99; 
			
				price += extrasAmount;
				priceText.setText(String.format("%.2f", price));
				return;
		}
		
		catch (Exception e) {
			messageTextArea.appendText("Error setting sandwich price\n");
			return;
		}
	}
	
	void updateSandwichPrice(Boolean isAdding) {
		
		try {
			if(isAdding) {
				price += 1.99;
				priceText.setText(String.format("%.2f", price));
				return;
			}
			
			price -= 1.99;
			priceText.setText(String.format("%.2f", price));
			return;
			
			
		}
		
		catch (Exception e) {
			messageTextArea.appendText("Error setting sandwich price\n");
			return;
		}
		
	}

	public void setSecondScene(Scene scene) {
		// TODO Auto-generated method stub
        secondScene = scene;

		
	}
	
	@FXML
	void openSecondScene(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        Scene s = secondScene;
        primaryStage.setScene(s);
        primaryStage.show();
    }
	
}
