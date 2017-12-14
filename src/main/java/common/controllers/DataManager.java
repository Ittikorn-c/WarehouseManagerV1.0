package common.controllers;

import common.dataSources.DBConnector;
import common.model.Goods;
import common.model.Requisition;

import java.util.ArrayList;

public class DataManager {
    public ArrayList<Goods> getGoodses() {
        return goodses;
    }

    public void setGoodses(ArrayList<Goods> goodses) {
        this.goodses = goodses;
    }

    private ArrayList<Goods> goodses = new ArrayList<Goods>();
    private DBConnector dbConnector = new DBConnector();

    public  DataManager(){
        getAllData();
    }

    private void getAllData(){
        goodses = dbConnector.getAllGoodses();
    }

    public void insertRequisition(Requisition requisition){
        dbConnector.insertRequisition(requisition);
    }
}
