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
import javafx.scene.control.RadioButton;
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
 * @author Sh000
 */
public class Create_accountController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private Stage stage;
 private Scene scene;
 private Parent root;
 @FXML
    private AnchorPane pane;
    @FXML
    private TextField tt1;
    
    @FXML
    private TextField tt2;
    
    @FXML
    private TextField tt3;
    
    @FXML
    private TextField tt4;
    
    @FXML
    private TextField tt5;
    
    @FXML
    private TextField tt6;
    
    @FXML
    private TextField tt7;
    @FXML
    private TextField tt8;
    
    @FXML
    private Label e2;
    
    @FXML
    private Label p2;
    @FXML
    private Label u2;
    @FXML
    private Label f2;
    @FXML
    private Label D2;
    @FXML
    private Label N2;
    
     @FXML
    private Label jop;
      @FXML
    private Label sex;
      
       @FXML
    private Label s1;
       
    
    @FXML
    private void creatworker( ActionEvent event) throws Exception {
    
    
    String pp=tt2.getText();
    String ee=tt1.getText();
    String uu=tt3.getText();  
    String ff=tt4.getText();
    String DD=tt5.getText();
    String NN=tt6.getText();
    String jj=tt7.getText();  
    String sex=tt8.getText();  
        
         
      /* Session session333 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session333.beginTransaction(); */
        
        
        
        if(ee.isEmpty() || uu.isEmpty()|| ff.isEmpty()|| DD.isEmpty()||NN.isEmpty() ||  jj.isEmpty() ||pp.isEmpty()){
        
        s1.setText("There is an empty box");
        s1.setStyle("-fx-width:2px ;-fx-border-color:red");
        
        }
        else{
        
        worker w= new worker();
          w.setDOB(DD);
          w.setEmail(ee);
          w.setFullname(ff);
          w.setJop(jj);
          w.setPassword(pp);
          w.setUsername(uu);
         
          w.setW_NID(NN);
          w.setSex(sex);
          
          Session session222 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx2 = session222.beginTransaction();
      session222.save(w);
        tx2.commit();
        session222.close();  
          
  root = FXMLLoader.load(getClass().getResource("log_in_worker.fxml"));
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


public void switchtoHome(ActionEvent event)throws Exception{
    Parent root1 =FXMLLoader.load(getClass().getResource("Home.fxml"));
       
   Scene scene=new Scene(root1);
  Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
  window.setScene(scene);
  window.show();}
      

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
   public void switchLog_in(ActionEvent event) throws IOException {
  root = FXMLLoader.load(getClass().getResource("log_in_worker.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();}
      
}
