import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage palco) throws Exception {
        Parent raiz = FXMLLoader.load(getClass().getResource("HelloWorld.fxml"));
        Scene tela = new Scene(raiz);
        palco.setTitle("Faça sua viagem dos sonhos.");
        palco.setScene(tela);

        palco.show();
    }
}