/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourmissions;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sh000
 */


public class HomeController implements Initializable {
    @FXML
private Button createAccount;
    @FXML
private Button login;    
    @FXML
private void handleButtonAction(ActionEvent event)throws Exception{
    Parent root =FXMLLoader.load(getClass().getResource("usertyp.fxml"));
       
   Scene scene=new Scene(root);
  Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
  window.setScene(scene);
  window.show();}
@FXML
private void a1(ActionEvent event)throws Exception{
    Parent root1 =FXMLLoader.load(getClass().getResource("usertype.fxml"));
       
   Scene scene=new Scene(root1);
  Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
  window.setScene(scene);
  window.show();}


@FXML
    private AnchorPane pane;
 @FXML
private void panemethod( MouseEvent event) throws Exception {
     
    pane.setOnMouseClicked(e->{
          if(e.getButton()==MouseButton.PRIMARY)
             pane.setStyle("-fx-border-color:GRAY;-fx-border-width:0px;-fx-Background-color: #78C7C7;");
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
