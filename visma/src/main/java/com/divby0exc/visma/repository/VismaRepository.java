package com.divby0exc.visma.repository;

import com.divby0exc.visma.model.Invoice;
import com.divby0exc.visma.model.InvoiceList;
import com.divby0exc.visma.model.Registrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.LocalTime.now;

@Repository
public class VismaRepository implements IVismaRepository {
    public final String DB_NAME = "visma";
    public final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/visma";
    public String getIdFromUser = "SELECT id FROM authentication WHERE username=?";
    public  String linkSql = "SELECT * FROM invoice " +
            "JOIN authentication " +
            "ON invoice.ownerId=authentication.id " +
            "WHERE authentication.username=?";
    public String insertStmt = "INSERT INTO invoice (ownerId, title, description, category, price) " +
            "VALUES (?, ?, ?, ?, ?)";
    private ResultSet rs = null;
    private PreparedStatement pstmt = null;
    private Connection con = null;

    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public void addInvoice(Invoice invoice, String username) {
        try {
            con = DriverManager.getConnection(CONNECTION_STRING);
            pstmt = con.prepareStatement(getIdFromUser);

            pstmt.setString(1, username);

            rs = pstmt.executeQuery();

            int ownerId = rs.getInt("id");

            pstmt = con.prepareStatement(insertStmt);

            pstmt.setInt(1, ownerId);
            pstmt.setString(2, invoice.getTitle());
            pstmt.setString(3, invoice.getDescription());
            pstmt.setString(4, invoice.getCategory());
            pstmt.setDouble(5, invoice.getPrice());

            pstmt.execute();

            rs.close();
            pstmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong " + e.getMessage());
            e.printStackTrace();
        }
        assert rs == null : "ResultSet wasn't closed properly in repo";
        assert pstmt == null : "PreparedStatement wasn't closed properly in repo";
        assert con == null : "Connection wasn't closed properly in repo";
    }

    @Override
    public void editInvoice(Invoice invoice) {


    }

    @Override
    public InvoiceList getAllInvoices(String username) throws SQLException {

        InvoiceList invoices = new InvoiceList(username);

        try {
            con = DriverManager.getConnection(CONNECTION_STRING);
            pstmt = con.prepareStatement(linkSql);

            pstmt.setString(1, username);

            rs = pstmt.executeQuery();

            if (!rs.next()) {
                return null;
            }

            do {
                // title, description, category, price
                Invoice invoice = new Invoice();
                invoice.setTitle(rs.getString("title"));
                invoice.setDescription(rs.getString("description"));
                invoice.setCategory(rs.getString("category"));
                invoice.setPrice(rs.getDouble("price"));

                invoices.getInvoices().add(invoice);

            } while (rs.next());


            rs.close();
            pstmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong " + e.getMessage());
            e.printStackTrace();
        }
            assert rs == null : "ResultSet wasn't closed properly in repo";
            assert pstmt == null : "PreparedStatement wasn't closed properly in repo";
            assert con == null : "Connection wasn't closed properly in repo";

            return invoices;
    }

        @Override
    public void deleteInvoice(int id) {

    }

    @Override
    public boolean findUserIfExist(String username) {
        boolean exist = false;
        String user = jdbc.queryForObject("SELECT username FROM authentication", String.class);
        if(user != null) {
            exist = true;
        }
        return exist;
    }

    @Override
    public void addUserToDB(Registrator user) {
        SimpleJdbcInsert jdbcInsert =
                new SimpleJdbcInsert(dataSource).withTableName("authentication");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", user.getUsr());
        param.put("password", user.getPwd());

        jdbcInsert.execute(param);
    }
}
