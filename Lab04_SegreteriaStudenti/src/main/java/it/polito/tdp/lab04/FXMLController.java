package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model segreteria;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboCorsi;

    @FXML
    private Button btnCercaIscrittiCorso;

    @FXML
    private TextField txtMatricola;

    @FXML
    private CheckBox CheckCompletaStudente;

    @FXML
    private Button btnCompletaStudente;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doActivation(ActionEvent event) {
    	
    	if(comboCorsi.getValue() != null) {
    		
    		btnCercaIscrittiCorso.setDisable(false);
    		
    		txtMatricola.setDisable(false);
    		CheckCompletaStudente.setDisable(false);
    		
    		btnCercaCorsi.setDisable(false);
    		btnIscrivi.setDisable(false);
    		
    	}else {
    		txtResult.setText("SELEZIONARE UN CORSO DALLA TENDINA O LO SPAZIO VUOTO");
    	}

    }

    @FXML
    void doCercaCorsi(ActionEvent event) {

    }

    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {

    }

    @FXML
    void doCheckCompleta(ActionEvent event) {
    	
    	txtNome.clear();
    	txtCognome.clear();
    	txtResult.clear();
    	
    	
    	Integer matricola;
    	
    	try {
    		matricola = Integer.parseInt(txtMatricola.getText());
    	}
    	catch(NumberFormatException e){
    		txtResult.setText("ERRORE! LA MATRICOLA DEVE CONTENERE SOLO CARATTERI NUMERICI");
    		return;
    	}
    	
    	if(segreteria.getCognomeStudente(matricola)!= null) {
    		
    		txtNome.setDisable(false);
    		txtCognome.setDisable(false);
    		
    		txtNome.setText(segreteria.getNomeStudente(matricola));
    		txtCognome.setText(segreteria.getCognomeStudente(matricola));
    	}
    	else {
    		txtResult.setText("ERRORE! MATRICOLA NON PRESENTE NEL DATABASE");
    		return;
    	}
    }

    @FXML
    void doCompletaStudente(ActionEvent event) {
    	Integer matricola;
    	
    	try {
    		matricola = Integer.parseInt(txtMatricola.getText());
    	}
    	catch(NumberFormatException e){
    		txtResult.setText("ERRORE! LA MATRICOLA DEVE CONTENERE SOLO CARATTERI NUMERICI");
    		return;
    	}
    	
    	if(segreteria.getCognomeStudente(matricola)!= null) {
    		txtNome.setText(segreteria.getNomeStudente(matricola));
    		txtCognome.setText(segreteria.getCognomeStudente(matricola));
    	}
    	else {
    		txtResult.setText("ERRORE! MATRICOLA NON PRESENTE NEL DATABASE");
    		return;
    	}
    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert comboCorsi != null : "fx:id=\"comboCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert CheckCompletaStudente != null : "fx:id=\"CheckCompletaStudente\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCompletaStudente != null : "fx:id=\"btnCompletaStudente\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		
		comboCorsi.getItems().addAll(model.getTuttiICorsiString()); 
		
		btnCercaIscrittiCorso.setDisable(true);
		
		txtMatricola.setDisable(true);
		CheckCompletaStudente.setDisable(true);
		txtNome.setDisable(true);
		txtCognome.setDisable(true);
		
		btnCercaCorsi.setDisable(true);
		btnIscrivi.setDisable(true);
		
		txtResult.setDisable(true);
		
		btnReset.setDisable(true);
		
		this.segreteria = model;
	}
}
