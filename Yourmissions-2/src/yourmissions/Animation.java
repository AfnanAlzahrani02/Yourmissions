/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourmissions;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author zubair
 */
public class Animation implements Initializable {
          private Stage stage;
 @FXML
    private Label label;
 @FXML
    private Circle c1;
    @FXML
    private Circle c2;
    @FXML
    private Circle c3;
    @FXML
    private Button paly;
    @FXML
    private Circle c4;
    @FXML
    private Circle c5;
    @FXML
    private Circle c6;
    @FXML
    private Circle c7;
    @FXML
  private void Start(ActionEvent event) throws IOException {
 Parent root=FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();  
   }
    private void setRotate(Circle c,boolean reverse,int angle ,int duration){
    RotateTransition rt=new RotateTransition(Duration.seconds(duration),c);
    rt.setAutoReverse(reverse);
    rt.setByAngle(angle);
    rt.setDelay(Duration.seconds(0));
    rt.setRate(3);
    rt.setCycleCount(18);
    rt.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
setRotate(c1,true,360,10);
setRotate(c2,true,180,18);
setRotate(c3,true,180,20);
setRotate(c4,true,180,22);
setRotate(c5,true,180,28);
setRotate(c6,true,180,15);
setRotate(c7,true,180,17);




    }    
    
}
