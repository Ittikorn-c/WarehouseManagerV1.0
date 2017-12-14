import SaleControllers.controller.RequisitionController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import common.controllers.DataManager;

public class MainSale extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        DataManager dataManager = new DataManager();
        FXMLLoader root = new FXMLLoader(getClass().getResource("SaleResources/RequisitionPage.fxml"));

        primaryStage.setScene(new Scene((Parent) root.load(), 1000, 600));
        primaryStage.setTitle("Hello World");
        primaryStage.show();

        RequisitionController controller = root.getController();
        System.out.println(controller);
        System.out.println("test##########################################################################");
        controller.setDataManager(dataManager);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
