/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoapp.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author kcwill1231
 */
public class RegistrationController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField regNewUserName;

    @FXML
    private PasswordField regNewUserPassword;

    @FXML
    private Button regRegisterButton;

    @FXML
    void initialize() {
        regRegisterButton.setOnAction(event -> {
        createUser();  
        });
    }
        
    private void createUser() {
        Database databaseHandler = new Database();
        
        String userName = regNewUserName.getText();
        String userPass = regNewUserPassword.getText();
        
        User user = new User(userName, userPass);
        
        databaseHandler.addUser(user);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    
    
}
