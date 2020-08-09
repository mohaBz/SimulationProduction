package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainControler {

    public void casUne(){
        try
        {
            Stage stage=Main.getStage();
            Parent root= FXMLLoader.load(getClass().getResource("CasUneDetails.fxml"));
            Scene scene = new Scene(root,600,400);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){

        }

    }
    public void casDeux(){
        try
        {
            Stage stage=Main.getStage();
            Parent root= FXMLLoader.load(getClass().getResource("CasDeuxDetails.fxml"));
            Scene scene = new Scene(root,600,400);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){

        }

    }
}
