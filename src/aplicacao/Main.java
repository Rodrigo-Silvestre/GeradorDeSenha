package aplicacao;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		Pane root = new FXMLLoader(Main.class.getResource("/visao/FXML_GeradorDeSenha.fxml")).load();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("Gerador de Senha");
		stage.getIcons().add(new Image("/visao/png/Gerador_de_senha.png"));
		stage.show();
	}
}
