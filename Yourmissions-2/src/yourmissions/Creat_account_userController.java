/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourmissions;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author DEEMA
 */
public class Creat_account_userController implements Initializable {
     private Stage stage;
 private Scene scene;
 private Parent root;
 @FXML
    private AnchorPane pane;
@FXML
    private TextField t1;
    
    @FXML
    private TextField t6;
    
    @FXML
    private TextField t3;
    @FXML
    private TextField t4;
    
    @FXML
    private TextField t5;
    
    @FXML
    private TextField t2;
    
    
    @FXML
    private Label e1;
    
    @FXML
    private Label p1;
    @FXML
    private Label u1;
    @FXML
    private Label f1;
    @FXML
    private Label D1;
    @FXML
    private Label N1;
    @FXML
    private Label s;
    
    
    @FXML
    private void creatuser( ActionEvent event) throws Exception {
    String p=t2.getText();
    String e=t1.getText();
    String u=t3.getText();  
    String f=t4.getText();
    String D=t5.getText();
    String N=t6.getText();
    
    
        
   /* Session session33 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session33.beginTransaction();*/
    
        
        
        if(e.isEmpty() || u.isEmpty()|| f.isEmpty()|| D.isEmpty()||N.isEmpty()){
        
        s.setText("There is an empty box");
        s.setStyle("-fx-width:2px ;-fx-border-color:red");
        
        }
        else{
        
        user r= new user();
          r.setEmail(e);
          r.setUsername(u);
          r.setFullname(f);
          r.setNID(N);
          r.setDOB(D);
          r.setPassword(p);
          
          Session session22 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session22.beginTransaction();
      session22.save(r);
        tx1.commit();
        session22.close();
        
          root = FXMLLoader.load(getClass().getResource("log_in.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
        }
        
  
        
        
        
        
    }
    
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
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   
 public void switclogin_user(ActionEvent event) throws IOException {
 root = FXMLLoader.load(getClass().getResource("log_in.fxml"));
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
    

