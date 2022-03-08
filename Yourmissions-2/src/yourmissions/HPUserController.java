/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourmissions;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author Sh000
 */


public class HPUserController implements Initializable {
@FXML
private TextField taskno;
@FXML
private TextArea description;
 @FXML
private Button addtasks;
@FXML
private Button EXIT;

String worker;    
private Stage stage;
private Scene scene;
private Parent root;
 @FXML
 private void addtasks(ActionEvent event)throws Exception{
    tasks t1 = new tasks();
    t1.setTasks_no(taskno.getText());
    t1.setDescription(description.getText());
    worker=Co.getValue().toString();
    t1.setWorker_username(worker);
    
    Session session2 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session2.beginTransaction();
      session2.save(t1);
        tx.commit();
        session2.close();  
        
   Alert alert = new Alert(Alert.AlertType.CONFIRMATION); 
             alert.setTitle("Confirmation"); 
             alert.setHeaderText("The task has been added. "
                     + "Do you want to add another task? ");
             Optional<ButtonType> choise = alert.showAndWait ();
             
             if (choise.get() == ButtonType.OK){
             String t=taskno.getText();
            taskno.setText(null);
            Co.setValue(null);
            description.setText(null);
            
   
             }
       
             
 }
 
 @FXML
private void EXIT(ActionEvent event)throws Exception{
    Parent root=FXMLLoader.load(getClass().getResource("endPage.fxml"));
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
    /**
     * Initializes the controller class.
     */
@FXML
public ComboBox <String> Co ;
@FXML
public ObservableList<String> username = FXCollections.observableArrayList();;
   
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
Session session = HibernateUtil.getSessionFactory().openSession();      
      List<worker> sList = null;
       String queryStr = "from worker";
        Query query = session.createQuery(queryStr);
        sList = query.list();
       session.close();
     
       
       for(worker s: sList)
        {
          
            username.add(s.getUsername());
            System.out.println(s.getUsername());
             
        }
        Co.setItems(username);
       
}
    
       
       
}
