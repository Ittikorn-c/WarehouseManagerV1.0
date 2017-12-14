package common.model;

import java.util.ArrayList;

public class Requisition {
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Goods> getListGoods() {
        return listGoods;
    }

    public void setListGoods(ArrayList<Goods> listGoods) {
        this.listGoods = listGoods;
    }

    private String status = "OK";
    private ArrayList<Goods> listGoods;
    public Requisition(ArrayList<Goods> listGoods){
        this.listGoods = listGoods;
    }


}
