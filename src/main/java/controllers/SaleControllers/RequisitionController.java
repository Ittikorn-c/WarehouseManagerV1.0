package controllers.SaleControllers;

import controllers.ComboBoxAutoComplete;
import controllers.DataManager;
import controllers.SaleControllers.AddAmountOrderController;
import controllers.SaleControllers.AddNewGoodsController;
import dataSources.DBConnector;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.Goods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RequisitionController {

    @FXML
    ComboBox<String> typeComboBox;
    @FXML
    ComboBox<String> brandComboBox;
    @FXML
    TextField nameTextField;

    @FXML
    TableView tableViewGoods;
    @FXML
    TableColumn<Goods, Integer> columnGoodsID;
    @FXML
    TableColumn<Goods, String> columnGoodsType;
    @FXML
    TableColumn<Goods, String> columnGoodsBrand;
    @FXML
    TableColumn<Goods, String> columnGoodsName;

    @FXML
    TableView tableViewOrder;
    @FXML
    TableColumn<Goods, Integer> columnOrderID;
    @FXML
    TableColumn<Goods, String> columnOrderType;
    @FXML
    TableColumn<Goods, String> columnOrderBrand;
    @FXML
    TableColumn<Goods, String> columnOrderName;
    @FXML
    TableColumn<Goods, Integer> columnOrderAmount;

    @FXML
    Button addBtn;

    public List<Goods> listGoods = new ArrayList();

    public ObservableList<Goods> observableListGoods;

    public List<Goods> listOrder = new ArrayList();

    public ObservableList<Goods> observableListOrder;

    DBConnector dbConnector = new DBConnector();
    ArrayList<Goods> goodses = new ArrayList<Goods>();

    public void setDataManager(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    private DataManager dataManager;

    @FXML
    public void initialize(){
        goodses = dbConnector.getAllGoodses();
        for(Goods g : goodses){
            listGoods.add(g);
        }

        typeComboBox.getItems().addAll("A", "ab", "bb", "ca", "dd");

        new ComboBoxAutoComplete<String>(typeComboBox);


        this.columnGoodsID.setCellValueFactory(new PropertyValueFactory<Goods, Integer>("id"));
        this.columnGoodsType.setCellValueFactory(new PropertyValueFactory<Goods, String>("type"));
        this.columnGoodsBrand.setCellValueFactory(new PropertyValueFactory<Goods, String>("brand"));
        this.columnGoodsName.setCellValueFactory(new PropertyValueFactory<Goods, String>("name"));

        observableListGoods = FXCollections.observableArrayList(listGoods);
        tableViewGoods.setItems(observableListGoods);

        this.columnOrderID.setCellValueFactory(new PropertyValueFactory<Goods, Integer>("id"));
        this.columnOrderType.setCellValueFactory(new PropertyValueFactory<Goods, String>("type"));
        this.columnOrderBrand.setCellValueFactory(new PropertyValueFactory<Goods, String>("brand"));
        this.columnOrderName.setCellValueFactory(new PropertyValueFactory<Goods, String>("name"));
        this.columnOrderAmount.setCellValueFactory(new PropertyValueFactory<Goods, Integer>("amount"));

        observableListOrder = FXCollections.observableArrayList(listOrder);
        tableViewOrder.setItems(observableListOrder);
    }

    @FXML
    public void reGoodsTable(){
        goodses = dbConnector.getAllGoodses();
        listGoods = new ArrayList();
        for(Goods g : goodses){
            listGoods.add(g);
        }

        observableListGoods = FXCollections.observableArrayList(listGoods);
        tableViewGoods.setItems(observableListGoods);
    }

    @FXML
    public void addOrder(){
        Goods g = (Goods) this.tableViewGoods.getSelectionModel().getSelectedItem();
        Goods order = new Goods(g.getId(), g.getType(), g.getBrand(), g.getName(), g.getAmount());

        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/SaleResources/AddAmountOrderPage.fxml"));

        try {
            stage.setScene(new Scene((Parent) loader.load()));
            AddAmountOrderController controller = loader.getController();
            controller.idLabel.setText(String.valueOf(g.getId()));
            controller.typeLabel.setText(g.getType());
            controller.brandLabel.setText(g.getBrand());
            controller.nameLabel.setText(g.getName());
            controller.goods = order;
            stage.setTitle("Appointment list");
            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }


        this.listOrder.add(order);
        observableListOrder = FXCollections.observableArrayList(listOrder);
        tableViewOrder.setItems(observableListOrder);

    }

    @FXML
    public void addNewGoods(){
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/SaleResources/AddNewGoodsPage.fxml"));

        try {
            stage.setScene(new Scene((Parent) loader.load()));
            AddNewGoodsController controller = loader.getController();

            stage.setTitle("Appointment list");
            stage.showAndWait();
            reGoodsTable();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrder(){
        System.out.println(listOrder);
        System.out.println(this.tableViewOrder.getSelectionModel().getSelectedItem());
        listOrder.remove(this.tableViewOrder.getSelectionModel().getSelectedItem());

        observableListOrder = FXCollections.observableArrayList(listOrder);
        tableViewOrder.setItems(observableListOrder);
    }

    public void cancelOrder(){
        listOrder = new ArrayList<Goods>();

        observableListOrder = FXCollections.observableArrayList(listOrder);
        tableViewOrder.setItems(observableListOrder);
    }
}
