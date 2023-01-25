package com.divby0exc.visma.repository;

import com.divby0exc.visma.model.Invoice;
import com.divby0exc.visma.model.InvoiceList;
import com.divby0exc.visma.model.Registrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;

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
    private PreparedStatement ps = null;
    private Connection con = null;

    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public void addInvoice(Invoice invoice, String username) {
        SimpleJdbcInsert jdbcInsert =
                new SimpleJdbcInsert(dataSource).withTableName("invoice");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("ownerId", findId(username));
        param.put("title", invoice.getTitle());
        param.put("description", invoice.getDescription());
        param.put("category", invoice.getCategory());
        param.put("price", invoice.getPrice());

        jdbcInsert.execute(param);
    }

    public int findId(String username) {
        int ownerId = jdbc.queryForObject("SELECT id FROM authentication WHERE username=?", Integer.class, username);

        System.out.println(ownerId);

        return ownerId;
    }

    @Override
    public void editInvoice(Invoice invoice) {


    }

    @Override
    public InvoiceList getAllInvoices(String username) throws SQLException {

        InvoiceList invoices = new InvoiceList(username);

        try {
            con = DriverManager.getConnection(CONNECTION_STRING, "root", "");
            ps = con.prepareStatement(linkSql);

            ps.setString(1, username);

            rs = ps.executeQuery();

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
                invoice.setDate(rs.getDate("date"));

                invoices.getInvoices().add(invoice);

            } while (rs.next());


            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong " + e.getMessage());
            e.printStackTrace();
        }
            assert rs == null : "ResultSet wasn't closed properly in repo";
            assert ps == null : "PreparedStatement wasn't closed properly in repo";
            assert con == null : "Connection wasn't closed properly in repo";

            return invoices;
    }

        @Override
    public void deleteInvoice(int id) {

    }

    @Override
    public boolean findUserIfExist(String username) {
        boolean exist = false;
        List<String> usernames;
        usernames = jdbc.queryForList("SELECT username FROM authentication", String.class);
        if(usernames != null) {
            if(usernames.contains(username)) {
                exist = true;
            }
        }
        return exist;
    }
    @Override
    public Registrator retrieveCredentials(String username) {
        Registrator user = new Registrator();
        try {
            con = DriverManager.getConnection(CONNECTION_STRING, "root", "");
            ps = con.prepareStatement("SELECT * FROM authentication WHERE username=?");

            ps.setString(1, username);

            rs = ps.executeQuery();

            if(!rs.next()) {return null;}

                user.setUsr(rs.getString("username"));
                user.setPwd(rs.getString("password"));
                System.out.println(user.getUsr() + " From DB");
                System.out.println(user.getPwd() + " From DB");

                rs.close();
                ps.close();
                con.close();


        } catch (SQLException e) {
            System.out.println("Something went wrong " + e.getMessage());
            e.printStackTrace();
        }
        return user;
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
