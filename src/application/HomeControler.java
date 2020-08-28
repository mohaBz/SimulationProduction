package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeControler {
    @FXML
    public Button simulationBt;
    @FXML
    public Button collectBt;
    @FXML
    public Button productionBt;
    @FXML
    public Button trqnsportBt;
    @FXML
    public Button stockageBt;
    @FXML
    public Button livraisonBt;
    @FXML
    public void onButtonClick(ActionEvent event){
        String nextScreen="MainScreen.fxml";
        if(event.getSource().equals(simulationBt))
            nextScreen="MainScreen.fxml";
         else if(event.getSource().equals(collectBt))
            nextScreen="CollectScreen.fxml";
        else
         if(event.getSource().equals(productionBt))
            nextScreen="ProductionScreen.fxml";
         else if(event.getSource().equals(trqnsportBt))
             nextScreen="TransportScreen.fxml";
         else if(event.getSource().equals(stockageBt))
             nextScreen="StockageScreen.fxml";
         else if (event.getSource().equals(livraisonBt))
             nextScreen="LivraisonScreen.fxml";
        try
        {
            Stage stage=Main.getStage();
            Parent root= FXMLLoader.load(getClass().getResource(nextScreen));
            Scene scene = new Scene(root,1000,600);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
            System.out.printf("error click"+e.getMessage());
        }

    }
}
