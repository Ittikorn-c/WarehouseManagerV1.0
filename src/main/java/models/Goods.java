package models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Goods {
    public SimpleIntegerProperty id;
    private SimpleStringProperty type;
    private SimpleStringProperty brand;
    private SimpleStringProperty name;
    private SimpleIntegerProperty amount;

    public Integer getId() {
        return id.get();
    }

    public String getType() {
        return type.get();
    }

    public String getBrand() {
        return brand.get();
    }

    public String getName() {
        return name.get();
    }

    public Integer getAmount() {
        return amount.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public void setBrand(String brand) {
        this.brand.set(brand);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setAmount(int amount) {
        this.amount.set(amount);
    }

    public Goods(int id, String type, String brand, String name, int amount){
        this.id = new SimpleIntegerProperty(id);
        this.type = new SimpleStringProperty(type);
        this.brand = new SimpleStringProperty(brand);
        this.name = new SimpleStringProperty(name);
        this.amount =  new SimpleIntegerProperty(amount);
    }
}
