package controle;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import modelo.GeradorDeSenha;

public class FXML_GeradorDeSenhaControle implements Initializable{

    @FXML
    private RadioButton radioButton_Letras;

    @FXML
    private RadioButton radioButton_LetrasEspeciais;

    @FXML
    private RadioButton radioButton_Numeros;

    @FXML
    private TextField textField_Senha;
    
    @FXML
    private TextField textField_Tamanho;
    
    @FXML
    private Slider slider_Tamanho;
    
    private GeradorDeSenha gerador;

    @FXML
    void oneAction_GerarSenha(ActionEvent event) {
    	boolean letras, letrasEspeciais, numeros;
    	letras = radioButton_Letras.selectedProperty().getValue();
    	letrasEspeciais = radioButton_LetrasEspeciais.selectedProperty().getValue();
    	numeros = radioButton_Numeros.selectedProperty().getValue();
    	if (!letras && !letrasEspeciais && !numeros) {
    		Alert alert = new Alert(AlertType.INFORMATION, "Escolha uma ou várias opções de senha!", ButtonType.OK);
    		alert.setHeaderText("Alerta!");
    		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
    		stage.getIcons().add(new Image("/visao/png/Gerador_de_senha.png"));
    		alert.show();
    		textField_Senha.setText(null);
    	}
    	else {
    		gerador = new GeradorDeSenha();
        	gerador.setCaractere(letras);
        	gerador.setCaracteresEspeciais(letrasEspeciais);
        	gerador.setNumero(numeros);
        	gerador.setTamanhoDaSenha(Integer.parseInt(textField_Tamanho.getText()));
        	textField_Senha.setText(gerador.getSenha());
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
		slider_Tamanho.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				int tamanho = (int) slider_Tamanho.getValue();	
				textField_Tamanho.setText(String.valueOf(tamanho));
			}
			
		});
	}
}
