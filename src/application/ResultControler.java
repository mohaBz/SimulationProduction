package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class ResultControler {
//    @FXML
    @FXML
    private Label quantiteMatLb;
    @FXML
    private Label numCamionLb;
    @FXML
    private Label quantiteTransport;
    @FXML
    private Label numDepotLb;
    @FXML
    private Label quantiteNettoyage;
    @FXML
    private Label quantiteProduit;
    public void onBackPressed(){
        try
        {
            Stage stage=Main.getStage();
            Parent root= FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
            Scene scene = new Scene(root,1000,600);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
            System.out.printf("error click"+e.getMessage());
        }
    }
    @FXML
    public void initialize(){
        DataHolder dataHolder =DataHolder.getInstance();
        if(dataHolder.isPremMat()){
            int matQuant=dataHolder.getMatQuantity();
            int numTrans=(int)(matQuant-matQuant*0.0025);
            int quantNett= (int) (numTrans-(matQuant-matQuant*0.0025)*0.0025);
            int numProduit=(int)(quantNett-quantNett*0.07);
            int numDepot=numProduit/DataHolder.getInstance().getCapDepot()+1;
            int numCamion=numProduit/DataHolder.getInstance().getCapCamion()+1;
            quantiteMatLb.setText(matQuant+" Kg");
            numCamionLb.setText(numCamion+"");
            quantiteTransport.setText(numTrans+" Kg");
            numDepotLb.setText(numDepot+"");
            quantiteNettoyage.setText(quantNett+" Kg");
            quantiteProduit.setText(numProduit+" Kg");
//            4950
//                    4702
//                            4372
        }
        else {
            int numProduit=dataHolder.getMatQuantity();
            int quantNett= (int) (numProduit/0.93)+1;
            int numTrans=(int)(quantNett/0.9975)+1;
            int matQuant=(int)(numTrans/0.9975);
            int numDepot=numProduit/DataHolder.getInstance().getCapDepot()+1;
            int numCamion=numProduit/DataHolder.getInstance().getCapCamion()+1;
            quantiteMatLb.setText(matQuant+" Kg");
            numCamionLb.setText(numCamion+"");
            quantiteTransport.setText(numTrans+" Kg");
            numDepotLb.setText(numDepot+"");
            quantiteNettoyage.setText(quantNett+" Kg");
            quantiteProduit.setText(numProduit+" Kg");
        }



    }

}
