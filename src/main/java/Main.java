import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controllers.DataManager;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        DataManager dataManager = new DataManager();
        Parent root = FXMLLoader.load(getClass().getResource("SaleResources/RequisitionPage.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
