package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


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

    @FXML
    public void initialize(){
        int matQuant=DataHolder.getInstance().getMatQuantity();
        int numTrans=(int)(matQuant-matQuant*0.1);
        int quantNett= (int) (numTrans-(matQuant-matQuant*0.1)*0.05);
        int numProduit=(int)(quantNett-quantNett*0.07);
        int numDepot=numProduit/DataHolder.getInstance().getCapDepot()+1;
        int numCamion=numProduit/DataHolder.getInstance().getCapCamion()+1;

        quantiteMatLb.setText(matQuant+"");
        numCamionLb.setText(numCamion+"");
        quantiteTransport.setText(""+numTrans);
        numDepotLb.setText(numDepot+"");
        quantiteNettoyage.setText(quantNett+"");
        quantiteProduit.setText(numProduit+"");

    }

}
