package com.divby0exc.visma.repository;

import com.divby0exc.visma.db.DB;
import com.divby0exc.visma.model.Receipt;
import com.divby0exc.visma.model.ReceiptList;
import com.divby0exc.visma.model.Registrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

import static java.time.LocalTime.now;

@Repository
public class VismaRepository implements IVismaRepository, RowMapper<Receipt> {
    private DB db;
    public VismaRepository() {
        db = db.getInstance();
    }
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
    public void addReceipt(Receipt receipt, String username) {
        SimpleJdbcInsert jdbcInsert =
                new SimpleJdbcInsert(dataSource).withTableName("invoice");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("ownerId", findId(username));
        param.put("title", receipt.getTitle());
        param.put("description", receipt.getDescription());
        param.put("category", receipt.getCategory());
        param.put("price", receipt.getPrice());
        param.put("date", Date.valueOf(LocalDate.now()));

        jdbcInsert.execute(param);
    }

    @Override
    public int findId(String username) {
        int ownerId = jdbc.queryForObject("SELECT id FROM authentication WHERE username=?", Integer.class, username);

        System.out.println(ownerId);

        return ownerId;
    }

    @Override
    public int updateReceipt(Receipt receipt) {
        String updateSql = "UPDATE invoice SET title = ?, category = ?, description  = ?, price  = ?, date = ? where id = ?";

        return jdbc.update(updateSql, receipt.getTitle(),
                receipt.getCategory(), receipt.getDescription(),
                receipt.getPrice(),
                receipt.getDate(), receipt.getId());
    }
    @Override
    public int deleteReceipt(int id) {
        String sql = "DELETE FROM invoice WHERE id = ?";

        return jdbc.update(sql,id);
    }

    @Override
    public Receipt getReceiptById(int id) {
        String sql = "SELECT * FROM invoice WHERE id = ?";
        Receipt receipt =
                jdbc.queryForObject(sql, new Object[] { id }, new VismaRepository());

        return receipt;
    }
    @Override
    public Receipt mapRow(ResultSet rs, int rowNum) throws SQLException {
        Receipt receipt = new Receipt();
        receipt.setTitle(rs.getString("title"));
        receipt.setCategory(rs.getString("category"));
        receipt.setPrice(rs.getDouble("price"));
        receipt.setDescription(rs.getString("description"));
        receipt.setDate(rs.getDate("date"));
        receipt.setId(rs.getInt("id"));

        return receipt;
    }

    @Override
    public ReceiptList getAllReceipts(String username) throws SQLException {

        ReceiptList recipes = new ReceiptList(username);

        try {
            con = db.getConnection();
            ps = con.prepareStatement(linkSql);

            ps.setString(1, username);

            rs = ps.executeQuery();

            if (!rs.next()) {
                return null;
            }

            do {
                // title, description, category, price
                Receipt receipt = new Receipt();
                receipt.setTitle(rs.getString("title"));
                receipt.setDescription(rs.getString("description"));
                receipt.setCategory(rs.getString("category"));
                receipt.setPrice(rs.getDouble("price"));
                receipt.setDate(rs.getDate("date"));
                receipt.setId(rs.getInt("id"));

                recipes.getRecipes().add(receipt);

            } while (rs.next());


            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error message: " + e.getMessage());
            e.printStackTrace();
        }
            assert rs == null : "ResultSet wasn't closed properly in repo";
            assert ps == null : "PreparedStatement wasn't closed properly in repo";
            assert con == null : "Connection wasn't closed properly in repo";

            return recipes;
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
            con = db.getConnection();
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
        assert rs == null : "ResultSet wasn't closed properly in repo";
        assert ps == null : "PreparedStatement wasn't closed properly in repo";
        assert con == null : "Connection wasn't closed properly in repo";

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
