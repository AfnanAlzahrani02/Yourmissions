/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourmissions;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DEEMA
 */
public class UsertypController implements Initializable {
private Stage stage;
 private Scene scene;
 private Parent root;
 
 @FXML
    private AnchorPane pane;
 
    /**
     * Initializes the controller class.
     */
 
 
 
 @FXML
private void panemethod( MouseEvent event) throws Exception {
     
    pane.setOnMouseClicked(e->{
          if(e.getButton()==MouseButton.PRIMARY)
             pane.setStyle("-fx-border-color:GRAY;-fx-border-width:0 px;-fx-Background-color: #78C7C7;");
          else if(e.getButton()==MouseButton.SECONDARY)
             pane.setStyle("-fx-border-color:GRAY;-fx-border-width:7px;-fx-Background-color: #78C7C7;");
      });
      
      
}

 @FXML
private void pane1method( KeyEvent event) throws Exception {
    pane.setOnKeyPressed(e -> {
            
if (e.getCode() == KeyCode.N) {
pane.setStyle("-fx-Background-color: #36454F;");
}
else if (e.getCode() == KeyCode.M) {
  pane.setStyle("-fx-Background-color: #78C7C7;");
}
    });
            }




    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
      
        
        
        
    }  
    
    
    
    
    
      public void switchCreat_account_user(ActionEvent event) throws IOException {
  root = FXMLLoader.load(getClass().getResource("Creat_account_user.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();}
      
      
      
      public void switchCreate_account(ActionEvent event) throws IOException {
  root = FXMLLoader.load(getClass().getResource("create_account.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();}
      
      
      
    }    
      
       
    

