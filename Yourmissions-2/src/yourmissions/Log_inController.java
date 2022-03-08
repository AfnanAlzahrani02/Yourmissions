
package yourmissions;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author Sh000
 */
public class Log_inController implements Initializable {
    
    private Stage stage;
private Scene scene;
private Parent root;

 @FXML
    private Button button;
 @FXML
    private TextField username;

    @FXML
    private PasswordField passwod;

@FXML
    protected void handleLoginButtonAction(ActionEvent event)  throws IOException{
         user user1=new user();
         user1=null;
         Window owner =button.getScene().getWindow();
        if (username.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your Username");
            return;
        }
        if (passwod.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your Password");
            return;
        }
        
        List<user> users = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from user");
        users = query.list();
        session.close();
        
        for (user s : users) {
         if (username.getText().equals( s.getUsername()) && passwod.getText().equals( s.getPassword()))
             
         {
           user1 = s;
         }
        }
        
        if (user1 != null) 
        {
            showAlert(Alert.AlertType.CONFIRMATION,owner,"Registration Successful!","Welcome Mr/Miss ( "+user1.getUsername()+")");
        Parent root=FXMLLoader.load(getClass().getResource("HPUser.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
        else
        {
         showAlert(Alert.AlertType.ERROR,owner,"Form Error!","No acount Of this name ");
        }
    }
     public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {

        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
     
     
       @FXML
    void swichToCreateAcount(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("Creat_account_user.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
     @FXML
    private AnchorPane pane;
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

    public void switchcreate_user(ActionEvent event) throws IOException {
  root = FXMLLoader.load(getClass().getResource("Creat_account_user.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();}
  
    
    public void switchtoHome(ActionEvent event)throws Exception{
    Parent root1 =FXMLLoader.load(getClass().getResource("Home.fxml"));
       
   Scene scene=new Scene(root1);
  Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
  window.setScene(scene);
  window.show();}
      
    
    
    
}
