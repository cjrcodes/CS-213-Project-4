package application;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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

public class SecondController {
	
	
	
	@FXML
	private Scene firstScene;
	@FXML
	ListView<String> orderListView;
	
	@FXML
	Button sameOrderButton;
	
	@FXML
	Button removeOrderButton;
	
	@FXML
	Button clearOrderButton;
	
	@FXML
	Button backButton;
	
	@FXML
	TextField orderTotalTextField;
	
	@FXML
	Button saveOrderToFileButton;
	
	@FXML
	void initialize() {
		//System.out.println("Second controller reached");
		//System.out.println(MainController.order.toString());

		orderLinesToList();
		orderTotalTextField.setText(getTotalPrice());

		orderListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}

	/*public void setView1Controller(MainController mainController) {
		// TODO Auto-generated method stub
		
		
		
	}*/
	
	@FXML
	void addSameOrder(ActionEvent actionEvent) {
	try {			//System.out.println("addSameOrder reached");

		ObservableList<Integer> selectedOrderLine = FXCollections.observableArrayList(orderListView.getSelectionModel().getSelectedIndices());
		//System.out.println(selectedOrderLine);
		/*if(selectedOrderLine.size() == 0) {
			return;
		}*/
		
		//OrderLine ol = MainController.order.getOrderLines().get(0);
		
		//MainController.order.add(ol);
		
		for(int i : selectedOrderLine) {
			ArrayList<OrderLine> orderLines = MainController.order.getOrderLines();
			
			OrderLine orderLine = orderLines.get(i);
			OrderLine orderLineToAdd = new OrderLine(MainController.order.addLineNumber(), orderLine.getSandwich(), orderLine.getPrice());
			
			//ol.setLineNumber(MainController.order.lineNumber);
			
			MainController.order.add(orderLineToAdd);

		}
		
		orderLinesToList();
		orderTotalTextField.setText(getTotalPrice());
		//System.out.println("addSameOrder reached");

		
	}
	
	
	catch(Exception e) {
		return;
	}
	}
	
	public String getTotalPrice() {
		try {
			if(MainController.order == null) {
				return String.format("%.2f", 0.00);

			}
			
			Order order =MainController.order;
			Double totalPrice = 0.00;
			for(OrderLine ol: order.getOrderLines()) {
				//orderListView.getItems().add(ol.toString());
				totalPrice += ol.getPrice();
			}
			
			return String.format("%.2f", totalPrice);
		}
		
		
		catch(Exception e) {
			return "";
		}
		}
	
		
	
	
	public void orderLinesToList() {
		/*Order o = new Order();
		Chicken c = new Chicken();
		OrderLine ol1 = new OrderLine(1, c, 4.56);
		*/
		try {
			orderListView.getItems().clear();
			orderTotalTextField.setText(getTotalPrice());

			Order order =MainController.order;
			
			for(OrderLine ol: order.getOrderLines()) {
				orderListView.getItems().add(ol.toString());
			}
			orderTotalTextField.setText(getTotalPrice());

		}
		
		
		
		catch(Exception e) {
			return;
		}
		}
	
	
	
	/*public void getOrderDetails(Order order) {
		this.order = order;
	}*/

	/*public void setFirstScene(Scene scene) {
		// TODO Auto-generated method stub
		 firstScene = scene;
		
	}
	
	@FXML
	public void openFirstScene(ActionEvent actionEvent) {    
        Stage primaryStage = (Stage)(((Node)actionEvent.getSource()).getScene().getWindow());
        primaryStage.setScene(firstScene);
        
    }*/
	
	@FXML
	public void backToMainScene(ActionEvent actionEvent) {
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Controller.fxml"));
		Parent root = loader.load();
		
		
		//MainController controller = loader.getController();
		
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
		//messageTextArea.appendText("Error occurred listing extra ingredients\n");
		return;
	}
	}
	
	@FXML
	public void removeOrderLine(ActionEvent actionEvent) {
		try {
		ObservableList<String> selectedOrderLine = FXCollections.observableArrayList(orderListView.getSelectionModel().getSelectedItems());
		ObservableList<Integer> selectedIndices = FXCollections.observableArrayList(orderListView.getSelectionModel().getSelectedIndices());
		//System.out.println(MainController.order.getOrderLines().toString());
		//System.out.println(MainController.order.toString());

		//System.out.println(selectedOrderLine + "\n");
		//System.out.println(selectedOrderLine.size() + "\n");

		//System.out.println(selectedIndices + "\n");
		//System.out.println(selectedIndices.size() + "\n");

		//messageTextArea.appendText(selectedIngredient + "\n");
			//int j = 0;
			/*for(String i : selectedOrderLine) {


				orderListView.getItems().remove(i);
				/*OrderLine ol = MainController.order.getOrderLines().get(selectedIndices.get(j));
				MainController.order.remove(ol);
				j++;*/
			//}
			
			for(int i = 0; i < selectedIndices.size(); i++) {
				
			OrderLine ol = MainController.order.getOrderLines().get(selectedIndices.get(0));
			//System.out.println(ol.toString());
				MainController.order.remove(ol);
			}
			
			orderLinesToList();
			orderTotalTextField.setText(getTotalPrice());
			//System.out.println(MainController.order.getOrderLines().toString());
			//System.out.println("Orderlines with removed: " + MainController.order.toString());

			//System.out.println(selectedOrderLine + "\n");
			//System.out.println(selectedIndices + "\n");
			

			
			return;
			
	}
	
	catch (Exception e) {
		
		return;
	}
	}
	
	@FXML
	void clearOrder(ActionEvent actionEvent) {
		MainController.order = null;
		orderLinesToList();
		orderTotalTextField.setText(getTotalPrice());

	}
	
	
	
	/*MainController view1controller = ;
	MainController.someMethod();*/
	
	

}
