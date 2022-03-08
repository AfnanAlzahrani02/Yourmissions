/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourmissions;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author Sh000
 */
public class HPWorkerController implements Initializable {
    
     @FXML  
   TextArea textaria;
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


    
    
static String x="";
    public  HPWorkerController(String username) {
        x=username;
    }
 
   
   @FXML
    public void finishTask(ActionEvent event) throws IOException {
 
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION); 
             alert.setTitle("Confirmation"); 
             alert.setHeaderText("are you sure you finish all the task ?");
       
             
             Optional<ButtonType> choise = alert.showAndWait ();
             if (choise.get() == ButtonType.OK)
             { 
                           
        Session session1 = HibernateUtil.getSessionFactory().openSession();
         
        List<tasks> dList ;
        
        String queryStr = "From tasks";
        
        Query query = session1.createQuery(queryStr);
        
        dList = query.list();
        
        session1.close();
      
       
        for(tasks s: dList)
        {     
         if(s.getWorker_username().equals(x)){ 
            
          String y=s.getTasks_no();
        
          Session session6 = HibernateUtil.getSessionFactory().openSession();
          Transaction tx = session6.beginTransaction();
        
          tasks Supdate = null;      
          Supdate = (tasks)session6.get(tasks.class,y);
          session6.delete(Supdate);
    
          tx.commit();
       
         session6.close();
         textaria.clear();
     }                                
        }     
 
             }
             else { return; }
   
        
 } 

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  Session session1 = HibernateUtil.getSessionFactory().openSession();
         
        List<tasks> sList ;
        
        String queryStr = "From tasks";
        
        Query query = session1.createQuery(queryStr);
        
        sList = query.list();
        
        session1.close();
      
       
        for(tasks s: sList)
        {
        if( s.getWorker_username().equals(x)){ 
          textaria.setText(textaria.getText()+"\n"+s.getDescription());
                                        }
        }
             
                                                       }      
    
}
