package kz.Prudnikov.ATM;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class DataBase {

    private HashMap<String, Integer> loginP = new HashMap<>();
    private HashMap<String, Integer> MoneyP = new HashMap<>();

    public DataBase(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.2:3306/bankdb", "root", "Mysql4512345123");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from accounts");

            while (resultSet.next()) {
                loginP.put(resultSet.getString("ownername"), resultSet.getInt("accountnumber"));
                MoneyP.put(resultSet.getString("ownername"), resultSet.getInt("money"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public HashMap<String, Integer> getLoginP() {
        return loginP;
    }

    public HashMap<String, Integer> getMoneyP() {
        return MoneyP;
    }



}
