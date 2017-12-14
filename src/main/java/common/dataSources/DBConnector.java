package common.dataSources;

import common.model.Goods;
import common.model.Requisition;

import java.sql.*;
import java.util.ArrayList;

public class DBConnector {
    Connection conn;
    String url;

    public DBConnector() {
        this.url = "//localhost:3306/sa_database";
    }

    void connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql:" + url, "root", "");
    }

    public ResultSet getData(String tableName) throws SQLException {
        ResultSet resultSet = null;
        try {
            connect();
            String query = "SELECT * FROM " + tableName;
            Statement statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        conn.close();
        return resultSet;
    }

    public ArrayList<Goods> getAllGoodses() {
        ArrayList<Goods> goodses = new ArrayList<Goods>();
        try {
            connect();
            String query = "SELECT * FROM goodses";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String type = resultSet.getString(2);
                String brand = resultSet.getString(3);
                String name = resultSet.getString(4);
                int amount = resultSet.getInt(5);
                Goods goods = new Goods(id,type,brand,name,amount);

                goodses.add(goods);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return goodses;
    }

    public void insertGoodes(Goods goods){
        try {
            connect();
            String query = "INSERT INTO goodses(id,type,brand,name,quantity,available) VALUES (NULL," + goods.getType() + "," + goods.getBrand() + "," + goods.getName() + "," + "0,0" + ")";
            query = String.format("INSERT INTO `goodses` (`id`, `type`, `brand`, `name`, `quantity`, `available`) VALUES (NULL,'%s', '%s', '%s', 0, 0)",goods.getType(),goods.getBrand(),goods.getName());
            System.out.println(query);
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public  void insertRequisition(Requisition requisition){
        try {
            connect();
            String query = String.format("INSERT INTO `requisitions` (`req_id`, `status`) VALUES (NULL,'%s')",requisition.getStatus());
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);

            query = String.format("SELECT MAX(`req_id`) FROM `requisitions`");
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            int req_id = resultSet.getInt(1);

            for (Goods g : requisition.getListGoods()) {
                query = String.format("INSERT INTO `requisitiongoods` (`req_id`, `good_id`, `quantity`) VALUES (%d, %d, %d)",req_id,g.getId(),g.getAmount());
                statement.executeUpdate(query);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
