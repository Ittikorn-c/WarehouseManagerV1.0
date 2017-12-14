package common.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import common.model.Goods;

public class OrderController {

    @FXML
    Label idLabel;
    @FXML
    Label typeLabel;
    @FXML
    Label brandLabel;
    @FXML
    Label nameLabel;
    @FXML
    Button addBtn;

    @FXML
    TextField amountTextField;

    Goods goods;

    @FXML
    public void initialize(){

    }

    @FXML
    public void addOrder(){
        this.goods.setAmount(Integer.parseInt(this.amountTextField.getText()));
        addBtn .getScene().getWindow().hide();
    }
}
