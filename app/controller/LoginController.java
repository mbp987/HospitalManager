package app.controller;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController {

	@FXML
    private Button b_enter;
    @FXML
    private TextField t_login;
    @FXML
    private TextField t_pass;

    static String login;
    static String pass;
    
    @FXML
    void enterManager(MouseEvent event) throws IOException, SQLException{
    	login = t_login.getText();
    	pass = t_pass.getText();
    	if(login.equals("admin") && pass.equals("admin")) {
    		Stage stage = new Stage(); 
    		Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/app/view/ManagerView.fxml"));
    		Scene scene = new Scene(parent);
    		stage.setScene(scene);
    		stage.setTitle("Hospital Manager");
    		stage.show();
    		((Node)(event.getSource())).getScene().getWindow().hide(); 
    	} else {
    		Alert a_help = new Alert(AlertType.ERROR);
        	a_help.setHeaderText("Incorrect login or password");
        	a_help.setContentText("Please try again");
        	a_help.setTitle("Error");
        	a_help.showAndWait();
    	}
    }
	
}
