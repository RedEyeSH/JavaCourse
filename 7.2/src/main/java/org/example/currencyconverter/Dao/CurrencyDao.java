package org.example.currencyconverter.Dao;

import org.example.currencyconverter.DataSource.MariaDbConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDao {
    public List<String> getAllCurrencyAbbreviations() {
        List<String> currencyAbbreviations = new ArrayList<>();
        String query = "SELECT abbreviation FROM currency";

        try (Connection conn = MariaDbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                currencyAbbreviations.add(rs.getString("abbreviation"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return currencyAbbreviations;
    }

    public double getExchangeRate(String abbreviation) {
        String query = "SELECT exchange_rate FROM currency WHERE abbreviation = ?";
        try (Connection conn = MariaDbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, abbreviation);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getDouble("exchange_rate");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
