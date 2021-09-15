package kz.Prudnikov.ATM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ChangeTheData {

    public ChangeTheData(int password, String nameForRewrite, int depositInAccount) {
        //////Delete/////

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.2:3306/bankdb", "root", "Mysql4512345123");
            String query = "delete from bankdb.accounts where accountNumber = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, password);
            preparedStmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /////Add///

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.2:3306/bankdb", "root", "Mysql4512345123");
            String sql = "INSERT INTO bankdb.accounts (accountNumber, OwnerName, Money) VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, password);
            preparedStatement.setString(2, nameForRewrite);
            preparedStatement.setInt(3, depositInAccount);

            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Updated Successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
