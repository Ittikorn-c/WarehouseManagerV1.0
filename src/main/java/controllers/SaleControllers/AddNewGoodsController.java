package controllers.SaleControllers;


import dataSources.DBConnector;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Goods;

public class AddNewGoodsController {

    @FXML
    ComboBox typeComboBox;
    @FXML
    ComboBox brandComboBox;
    @FXML
    TextField nameTextField;
    @FXML
    Button addBtn;

    @FXML
    TextField amountTextField;

    Goods goods;

    @FXML
    public void initialize(){

    }

    @FXML
    public void addNewGoods(){
        DBConnector dbConnector = new DBConnector();
        String t = (String) typeComboBox.getSelectionModel().getSelectedItem();
        String b = (String) brandComboBox.getSelectionModel().getSelectedItem();
        String n = nameTextField.getText();
        Goods g = new Goods(0, t, b, n, 0);
        dbConnector.insertGoodes(g);
        addBtn .getScene().getWindow().hide();

    }
}
