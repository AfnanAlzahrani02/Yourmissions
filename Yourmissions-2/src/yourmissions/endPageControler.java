/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourmissions;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author zubair
 */
public class endPageControler implements Initializable {
    
    String path="C:\\Users\\TOSHIBA\\Documents\\NetBeansProjects\\Yourmissions\\src\\voice.MP3";
    
    Media media=new Media(new File(path).toURI().toString());
    MediaPlayer  mediaplayer =new MediaPlayer(media);
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mediaplayer.play();
        // TODO
    }    
      
}
