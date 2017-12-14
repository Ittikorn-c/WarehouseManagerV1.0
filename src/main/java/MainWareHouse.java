import WareHouseControllers.controller.ShowOrderTab;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import common.controllers.DataManager;

public class MainWareHouse extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        DataManager dataManager = new DataManager();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("WareHouse/ShowOrderPage.fxml"));



        Parent root = loader.load();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();

        ShowOrderTab controller = loader.getController();
        controller.dataManager = dataManager;
    }


    public static void main(String[] args) {
        launch(args);
    }

    FXMLLoader loader = new FXMLLoader(getClass().getResource("/SaleResources/AddAmountOrderPage.fxml"));


}
