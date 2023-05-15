/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCalcola"
    private Button btnCalcola; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorretti"
    private TextArea txtCorretti; // Value injected by FXMLLoader

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtSbagliati"
    private TextArea txtSbagliati; // Value injected by FXMLLoader

    @FXML
    void doAnagrammi(ActionEvent event) {
    	
    	String parola = txtParola.getText();
    	ArrayList<String> anagrammi = model.trovaAnagrammi(parola);
    	
    	for (String giusto : this.model.trovaAnagrammiCorretti(anagrammi)) {
    		this.txtCorretti.appendText(giusto + '\n'); 
    	}
    	
    	for (String sbagliato : this.model.trovaAnagrammiSbagliati(anagrammi)) {
    		this.txtSbagliati.appendText(sbagliato + '\n'); 
    	}
    }

    @FXML
    void doReset(ActionEvent event) {

    	this.txtParola.clear();
    	this.txtCorretti.clear();
    	this.txtSbagliati.clear();
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtSbagliati != null : "fx:id=\"txtSbagliati\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;;
		
	}

}
