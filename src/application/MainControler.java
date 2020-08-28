package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainControler {
    public void onBackPressed(){
        try
        {
            Stage stage=Main.getStage();
            Parent root= FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
            Scene scene = new Scene(root,1000,600);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
            System.out.printf("error click"+e.getMessage());
        }
    }
    public void casUne(){
        try
        {
            Stage stage=Main.getStage();
            Parent root= FXMLLoader.load(getClass().getResource("CasUneDetails.fxml"));
            Scene scene = new Scene(root,1000,600);
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
            Scene scene = new Scene(root,1000,600);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){

        }

    }
}
