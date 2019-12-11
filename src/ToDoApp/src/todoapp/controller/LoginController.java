/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoapp.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author kcwill1231
 */
public class LoginController implements Initializable {
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginUserName;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private Button loginButton;

    @FXML
    private Button loginNewUserButton;

    private Database databaseHandler;
    
    @FXML
    void initialize() 
    {
        databaseHandler = new Database();
                
        loginButton.setOnAction(event -> {
            
        String loginName = loginUserName.getText().trim();
        String loginPass = loginPassword.getText().trim();
        
        User user = new User();
        user.setUserName(loginName);
        user.setPassword(loginPassword);
        
        ResultSet userRow = databaseHandler.getUser(user);
          
        int counter = 0;
         
        try {
            while (userRow.next()){
              counter++;
        }
          
        if (counter == 1){
              
            showAddItemScreen();
        }
            } 
        catch (SQLException e) {
                  e.printStackTrace();
                  }
        });
        
        loginNewUserButton.setOnAction(event -> 
                {
                    //Displays Registration Screen
                    loginNewUserButton.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("NewUser.fxml"));
                    
                    try {
                        loader.load();
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                });
        
    }
    
    private void showAddItemScreen()
    {
        //Displays Add Item Screen
        loginNewUserButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("additem.fxml"));
                    
        try {
            loader.load();
        } catch (Exception e){
            e.printStackTrace();
            }
                    
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }        
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }  

    private void loginUser(String userName, String userPass) {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
                             
    }
        
    }
       
    

