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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author kcwill1231
 */
public class AdditemController implements Initializable {
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private AnchorPane rootAnchorPane;

    @FXML
    private Label noTaskLabel;
    
    @FXML
    private ImageView addButton;

    @FXML
    void initialize() {
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        addButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event ->{
            
            
            //clear the screen
            System.out.println("Clickers");
            addButton.setOpacity(0);
            noTaskLabel.setOpacity(0);
            
            addButton.relocate(0, 20);
            noTaskLabel.relocate(0, 21);
            
            try {
                AnchorPane formPane = FXMLLoader.load("addItemForm.fxml");
                rootAnchorPane.getChildren().setAll(formPane);
            } catch (Exception e){
                e.printStackTrace();
            }
            
        });
    }    
    
}
