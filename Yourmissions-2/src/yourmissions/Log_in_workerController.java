/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourmissions;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author Sh000
 */
public class Log_in_workerController implements Initializable {
@FXML
public   Stage stage;
@FXML
public   Scene scene;
@FXML
public  Parent root;
 @FXML
public Button button;
 @FXML
public TextField username=new TextField();
@FXML
public PasswordField passwod;
 @FXML
    private AnchorPane pane1;
 
 @FXML
 private Button btn;
 
@FXML
private void panemethod( MouseEvent event) throws Exception {
     
    pane1.setOnMouseClicked(e->{
          if(e.getButton()==MouseButton.PRIMARY)
             pane1.setStyle("-fx-border-color:GRAY;-fx-border-width:0px;-fx-Background-color: #78C7C7;");
          else if(e.getButton()==MouseButton.SECONDARY)
             pane1.setStyle("-fx-border-color:GRAY;-fx-border-width:7px;-fx-Background-color: #78C7C7;");
      });
      
      
}

 @FXML
private void pane1method( KeyEvent event) throws Exception {
    pane1.setOnKeyPressed(e -> {
            
if (e.getCode() == KeyCode.N) {
pane1.setStyle("-fx-Background-color: #36454F;");
}
else if (e.getCode() == KeyCode.M) {
  pane1.setStyle("-fx-Background-color: #78C7C7;");
}
    });
            }




@FXML
   public  void handleLoginButtonAction(ActionEvent event)  throws IOException{
           worker w1=new worker();
             w1=null;

         Window owner =button.getScene().getWindow();
        if (username.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your Username");
            return;
        }
        if (passwod.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your Password");
            return;
        }
        List<worker> workers = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from worker");
        workers = query.list();
        session.close();
        for (worker s : workers) {

         if (username.getText().equals( s.getUsername())&&passwod.getText().equals(s.getPassword()))
         {
           w1 = s;

         }
        }
        if (w1!= null) 
        {
        showAlert(Alert.AlertType.CONFIRMATION,owner,"Registration Successful!","Welcome Mr/Miss ( "+w1.getUsername()+")");

        
          FXMLLoader loader = new FXMLLoader( getClass().getResource("HPWorker.fxml"  ) );
          HPWorkerController controller = new HPWorkerController (username.getText());
          loader.setController(controller);
        Scene scene=new Scene(loader.load());
         stage = new Stage(StageStyle.DECORATED);
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
    public void swichToCreateAcount(ActionEvent event) throws IOException {
        Parent root=FXMLLoader.load(getClass().getResource("Creat_account.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 
    
      public void switchcreate_worker(ActionEvent event) throws IOException {
  root = FXMLLoader.load(getClass().getResource("create_account.fxml"));
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
