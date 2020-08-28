package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CasUneControler {
	@FXML
	private TextField quantiteMat;
	@FXML
	private TextField numCamion;
	@FXML
	private TextField capCamion;
	@FXML
	private TextField numDepot;
	@FXML
	private TextField capDepot;
	@FXML
	private Button startSimulationBt;
	@FXML
	private Label errorLb;
	
	@FXML
	public void initialize(){
		startSimulationBt.setDisable(true);
		// force the field to be numeric only
		initTextFields(quantiteMat);
		initTextFields(numCamion);
		initTextFields(capCamion);
		initTextFields(numDepot);
		initTextFields(capDepot);
	}
	

	

	public void startSimulation(){
		DataHolder dataHolder=DataHolder.getInstance();
		dataHolder.setMatQuantity(Integer.parseInt(quantiteMat.getText()));
		dataHolder.setNumCamion(Integer.parseInt(numCamion.getText()));
		dataHolder.setCapCamion(Integer.parseInt(capCamion.getText()));
		dataHolder.setNumDepot(Integer.parseInt(numDepot.getText()));
		dataHolder.setCapDepot(Integer.parseInt(capDepot.getText()));
		int matQuant=dataHolder.getMatQuantity();
		int numTrans=(int)(matQuant-matQuant*0.1);
		int quantNett= (int) (numTrans-(matQuant-matQuant*0.1)*0.05);
		int numProduit=(int)(quantNett-quantNett*0.07);
		int numDepot=numProduit/dataHolder.getCapDepot()+1;
		int numCamion=numProduit/dataHolder.getCapCamion()+1;
		if(numCamion>dataHolder.getNumCamion())
		{
			System.out.printf("not enough camion");
			errorLb.setText("camions ne suffisent pas");
			return;
		}
		if(numDepot>dataHolder.getNumDepot())
		{
			System.out.printf("not enough depot");
			errorLb.setText("depots ne suffisent pas");
			return;
		}
		try
		{
			Stage stage=Main.getStage();
			Parent root= FXMLLoader.load(getClass().getResource("ResultSimulation.fxml"));
			Scene scene = new Scene(root,1000,600);
			stage.setScene(scene);
			stage.show();
		}catch(Exception e){

		}
	}
	private boolean verifyText(TextField text){
		return text.getText().isEmpty() || text.getText().trim().isEmpty();
	}

	private void initTextFields(TextField textField){
		textField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue,
								String newValue) {
				if (!newValue.matches("\\d*")) {
					textField.setText(newValue.replaceAll("[^\\d]", ""));
				}
				if (verifyText(quantiteMat)||verifyText(numCamion)||verifyText(capCamion)||verifyText(numDepot)||verifyText(capDepot))
					startSimulationBt.setDisable(true);
				else
					startSimulationBt.setDisable(false);
			}
		});
	}
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
}
