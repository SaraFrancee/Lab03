/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Correttore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Correttore model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private TextField txtField;

    @FXML
    private URL location;

    @FXML
    private Button bttClear;

    @FXML
    private Button bttSpellCheck;

    @FXML
    private ComboBox<String> cmbBox;

    @FXML
    private Label labelErrori;

    @FXML
    private Label labelPrestazioni;

    @FXML
    private TextArea txtArea;

    @FXML
    void doCmbBox(ActionEvent event) {
    	this.bttSpellCheck.setDisable(false);
    }

    
    @FXML
    void doClear(ActionEvent event) {
    	txtArea.setText("");
    	txtField.setText("");
    	return;
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	long tempoI = System.nanoTime();
    	String lingua = cmbBox.getValue();
    	String testo = txtField.getText();
    	List<String> errori = model.correggi(lingua, testo);
    	if (errori == null) {
    		txtArea.setText("You need to select a language");
    		return;
    	}
    	for (String p : errori) {
    		txtArea.appendText(p);
    		txtArea.appendText("\n");
    	}
    	if (errori.size()==1)
    		labelErrori.setText("The text contains "+errori.size()+" error");
    	else
    		labelErrori.setText("The text contains "+errori.size()+" errors");
    	long tempoF = System.nanoTime();
    	double tempo = (tempoF-tempoI)/100000000.0;
    	labelPrestazioni.setText("Spell check completed in "+ tempo + " seconds");
        return;
    }

    @FXML
    void initialize() {
        assert bttClear != null : "fx:id=\"bttClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert bttSpellCheck != null : "fx:id=\"bttSpellCheck\" was not injected: check your FXML file 'Scene.fxml'.";
        assert cmbBox != null : "fx:id=\"cmbBox\" was not injected: check your FXML file 'Scene.fxml'.";
        assert labelErrori != null : "fx:id=\"labelErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert labelPrestazioni != null : "fx:id=\"labelPrestazioni\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtField != null : "fx:id=\"txtField\" was not injected: check your FXML file 'Scene.fxml'.";
        
        cmbBox.getItems().add("English");
        cmbBox.getItems().add("Italian");

    }
    
    public void setModel(Correttore model) {
    	this.model = model;
    }

}



