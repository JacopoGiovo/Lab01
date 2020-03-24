package it.polito.tdp.parole;
 
import it.polito.tdp.parole.model.Parole;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
    Parole elenco ;
   
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private Button btnCancella;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private TextField txtTempoRisposta;

    @FXML
    void doDelete(ActionEvent event) {
    	if(txtParola.getText().equals("") || txtParola.getText().contains("0") || txtParola.getText().contains("1") ||txtParola.getText().contains("2") ||txtParola.getText().contains("3") ||txtParola.getText().contains("4") ||txtParola.getText().contains("5") ||txtParola.getText().contains("6") ||txtParola.getText().contains("7") ||txtParola.getText().contains("8") ||txtParola.getText().contains("9"))
    	   {
    		   txtResult.setText("La parola non è nel dataset e non può essere eliminata!!!\n");
    		   txtParola.setText("");
    		   txtTempoRisposta.setText(""+System.nanoTime());
    		   return;
    	   }
    	else if(elenco.contieneParola(txtParola.getText())==true)
    		{
    		elenco.eliminaParola(txtParola.getText());
    		txtResult.setText(""+elenco.toString());
    		txtTempoRisposta.setText(""+System.nanoTime());
    		}
    	else
    	{
    	   txtResult.setText("La parola non è nel dataset e non può essere eliminata!!!\n");
 		   txtParola.setText("");
 		   elenco.getElenco();
 		   txtTempoRisposta.setText(""+System.nanoTime());
 		   return;
    	}
    }

    @FXML
    void doInsert(ActionEvent event) {
     if(txtParola.getText().equals(""))
	   return;
   if(txtParola.getText().contains("0") || txtParola.getText().contains("1") ||txtParola.getText().contains("2") ||txtParola.getText().contains("3") ||txtParola.getText().contains("4") ||txtParola.getText().contains("5") ||txtParola.getText().contains("6") ||txtParola.getText().contains("7") ||txtParola.getText().contains("8") ||txtParola.getText().contains("9"))
   {
	   txtResult.setText("Inserisci solo lettere cretino!!!\n");
	   txtParola.setText("");
	   return;
   }
   elenco.addParola(txtParola.getText());
   txtParola.clear();
   txtResult.setText(""+elenco.toString());
   txtTempoRisposta.setText(""+System.nanoTime());

    }

    @FXML
    void doReset(ActionEvent event) {
     	elenco.reset();
    	txtResult.setText("");
    	txtTempoRisposta.setText(""+System.nanoTime());
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempoRisposta != null : "fx:id=\"txtTempoRisposta\" was not injected: check your FXML file 'Scene.fxml'.";
        elenco = new Parole() ;
    }
}


