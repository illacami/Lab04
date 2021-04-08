package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
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
    		
    		btnReset.setDisable(false);
    	}else {
    		txtResult.setText("SELEZIONARE UN CORSO DALLA TENDINA O LO SPAZIO VUOTO");
    	}

    }

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	
    	txtResult.clear();
    	
    	//non c'è il campo matricola
    	if(txtMatricola.getText().isBlank()) {
    		txtResult.setText("ERRORE! INSERIRE UNA MATRICOLA");
    		return;
    	}
    	
    	String matricola = txtMatricola.getText();
    	
    	//matricola inesistente nel db
    	if(segreteria.getNomeStudente(matricola) == null) {
    		txtResult.setText("MATRICOLA INESISTENTE, RIPROVARE");
    		return;
    	}
    	
    	//lo studente esiste ma non è iscritto a nessun corso
    	if(segreteria.getCorsiDelloStudente(matricola).isEmpty()) {
    		System.out.println("ATTENZIONE! Lo studente non è iscritto a nessun corso!");
    		return;
    	}
    	txtResult.setStyle("-fx-font-family: monospace");
    	StringBuilder sb = new StringBuilder();
    	for(Corso c : segreteria.getCorsiDelloStudente(matricola)) {
    		sb.append(c.toString());
    	}
    	txtResult.appendText(sb.toString());
    	
    }

    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {
    	
    	txtResult.setDisable(false);
    	
    	if(comboCorsi.getValue() == null || comboCorsi.getValue() == "") {
    		txtResult.setText("SELEZIONARE UN CORSO DAL MENU' A TENDINA");
    		return;
    	}
    	
    	String corso[] = comboCorsi.getValue().split(" ");
    	
    	if(segreteria.getStudentiIscrittiAlCorso(corso[0]).isEmpty()) {
    		txtResult.setText("Nessuno studente iscritto al corso selezionato");
    	}
    	
    	try {
    	if(txtMatricola.getText().isBlank() == false) {
    		
    		String matricola = txtMatricola.getText();
    		
    		boolean flag = true;
    		
    		for(Corso c : segreteria.getCorsiDelloStudente(matricola)) {
    			if(corso[0].equals(c.getCodins())) {
    				txtResult.setText("Lo studente "+segreteria.getNomeStudente(matricola)+" "+segreteria.getCognomeStudente(matricola)+" è iscritto al corso selezionato");
    				flag = false;
    			}
    		}
    		
    		if(flag)
    			txtResult.setText("Lo studente "+segreteria.getNomeStudente(matricola)+" "+segreteria.getCognomeStudente(matricola)+"  NON è iscritto al corso selezionato");
    		
    		return;
    	}
    	}catch(Exception e) {
    		txtResult.setText("ERRORE NELLA RICERCA DEGLI ISCRITTI");
    		return;
    	}
    	
    	try {
    		txtResult.setStyle("-fx-font-family: monospace");
        	StringBuilder sb = new StringBuilder();
        	
    		for(Studente s : segreteria.getStudentiIscrittiAlCorso(corso[0]))
    			sb.append(s.toString());
    		
    		txtResult.appendText(sb.toString());	
    		
    	}catch(Exception e) {
    		txtResult.setText("ERRORE NELLA RICERCA DEGLI ISCRITTI");
    		return;
    	}

    }

    @FXML
    void doCheckCompleta(ActionEvent event) {
    	
    	txtNome.clear();
    	txtCognome.clear();
    	txtResult.clear();
    	
    	
    	String matricola = txtMatricola.getText();
    	
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
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	txtMatricola.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	
    	txtResult.clear();
    	
    }

    @FXML
    void initialize() {
        assert comboCorsi != null : "fx:id=\"comboCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert CheckCompletaStudente != null : "fx:id=\"CheckCompletaStudente\" was not injected: check your FXML file 'Scene.fxml'.";
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
