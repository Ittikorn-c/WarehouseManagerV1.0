package WareHouseControllers.controller;

import common.controllers.DataManager;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class ShowOrderTab
{

    @FXML
    TabPane tabPane;

    public DataManager dataManager;

    @FXML
    public void initialize() {
        tabPane.getTabs().add(new Tab("abc"));
    }

}
