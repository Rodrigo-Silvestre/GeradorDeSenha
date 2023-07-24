package controle;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import modelo.GeradorDeSenha;

public class FXML_GeradorDeSenhaControle implements Initializable{

    @FXML
    private CheckBox checkBox_Letras;

    @FXML
    private CheckBox checkBox_LetrasEspeciais;

    @FXML
    private CheckBox checkBox_Numeros;

    @FXML
    private TextField textField_Senha;
    
    @FXML
    private TextField textField_Tamanho;
    
    @FXML
    private Slider slider_Tamanho;

    @FXML
    void oneAction_GerarSenha(ActionEvent event) {
    	GeradorDeSenha gerador = new GeradorDeSenha();
    	gerador.setCaracter(true);
    	gerador.setCaracteresEspeciais(true);
    	gerador.setNumero(true);
    	gerador.setTamanhoDaSenha(Integer.parseInt(textField_Tamanho.getText()));
    	textField_Senha.setText(gerador.getSenha());
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
