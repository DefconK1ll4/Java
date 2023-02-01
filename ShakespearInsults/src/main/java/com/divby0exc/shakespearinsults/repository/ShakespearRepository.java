package com.divby0exc.shakespearinsults.repository;

import com.divby0exc.shakespearinsults.db.ShakespearDB;
import com.divby0exc.shakespearinsults.model.InsultRank;
import com.divby0exc.shakespearinsults.model.ShakespearModel;
import com.divby0exc.shakespearinsults.service.ShakespearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class ShakespearRepository {
    private ShakespearDB db = null;
    public ShakespearRepository() {
        db = ShakespearDB.getInstance();
    }
    @Autowired
    JdbcTemplate jdbc;
    @Autowired
    DataSource dataSource;

        public void
        saveInsult(ShakespearModel insult) {
            SimpleJdbcInsert jdbcInsert =
                    new SimpleJdbcInsert(dataSource).withTableName("insult");

            Map<String, Object> param = new HashMap<>();
            param.put("content", insult.getInsult());

            jdbcInsert.execute(param);
        }
        public ShakespearModel findById(Long id) {
            ShakespearModel insult = null;
            //insult = jdbc.query("SELECT * FROM insult WHERE id="+id, rs -> rs.next());
           // return insult;
            return null;
        }

        public List<ShakespearModel> fetchInsultList() {
        return jdbc.query("SELECT * FROM insult", (rs, rowNum) -> {
            ShakespearModel insult = new ShakespearModel();
            insult.setId(rs.getLong("id"));
            insult.setInsult(rs.getString("content"));

            return insult;
        });
        }

        public ShakespearModel fetchInsult(Long insultId) {
            String sql = "SELECT * FROM insult WHERE id=?";
            //ShakespearModel insult =
                    //jdbc.queryForObject(sql, new Object[] { insultId }, new ShakespearRepository());

            //return insult;
            return null;
        }




        public ShakespearModel updateInsult(ShakespearModel insult, Long insultId) {
            /**
             InsultRank db = fetchRank(rankId).get();
             String sqlName = "UPDATE courses SET name=? WHERE id=?";
             String sqlDesc = "UPDATE courses SET description=? WHERE id=?";
             String sqlAtten = "UPDATE courses SET attendees=? WHERE id=?";

             PreparedStatement pstmt = null;
             try {
             if (type.equalsIgnoreCase("name")) {
             pstmt = conn.prepareStatement(sqlName);
             pstmt.setString(1, course.getName());
             } else if(type.equalsIgnoreCase("description")) {
             pstmt = conn.prepareStatement(sqlDesc);
             pstmt.setString(1, course.getDescription());
             } else if(type.equalsIgnoreCase("attendees")) {
             pstmt = conn.prepareStatement(sqlAtten);
             pstmt.setInt(1, course.getAttendees());
             }
             pstmt.setInt(2, id);

             pstmt.executeUpdate();

             } catch (SQLException e) {
             throw new RuntimeException(e);
             }

             return course;
             **/
            return null;
        }

        public void deleteInsultById(Long insultId) {

        }


}
