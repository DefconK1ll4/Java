package com.divby0exc.shakespearinsults.repository;

import com.divby0exc.shakespearinsults.db.ShakespearDB;
import com.divby0exc.shakespearinsults.model.InsultRank;
import com.divby0exc.shakespearinsults.model.ShakespearModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class RankRepository implements RowMapper<InsultRank> {
    private ShakespearDB db = null;
    public RankRepository() {
        db = ShakespearDB.getInstance();
    }
    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbc;
    @Override
    public InsultRank mapRow(ResultSet rs, int rowNum) throws SQLException {
        InsultRank ir = new InsultRank();
        ir.setId(rs.getLong("id"));
        ir.setCreate_dt(rs.getDate("create_dt"));
        ir.setOwner_id(rs.getInt("owner_id"));
        ir.setRank(rs.getInt("rank"));

        return ir;
    }
    public void deleteRankById(Long rankId) {

    }
    public InsultRank updateRank(InsultRank rank, Long rankId, String type) {
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

    public InsultRank fetchRank(Long rankId) {
        return null;
    }
    public List<InsultRank> fetchRankList(Long id) {
        return jdbc.query("SELECT owner_id, `rank` FROM insult_rank WHERE owner_id=?", (rs, rowNum) -> {
            InsultRank ir = new InsultRank();
            ir.setOwner_id(rs.getInt("owner_id"));
            ir.setRank(rs.getInt("rank"));

            return ir;
        }, id);
    }
    public void saveRank(InsultRank rank) {
        SimpleJdbcInsert jdbcInsert =
                new SimpleJdbcInsert(dataSource).withTableName("insult_rank");
        Map<String, Object> param = new HashMap<>();
        param.put("owner_id", rank.getOwner_id());
        param.put("create_dt", rank.getCreate_dt());
        param.put("rank", rank.getRank());

        jdbcInsert.execute(param);
    }

    public List<InsultRank> getBetween(int x, int y) {
        return null;
    }

    public InsultRank getAverage() {
        return null;
    }

    public InsultRank getHighestRank() {
        return null;
    }

    public InsultRank getLowestRank() {
        return null;
    }
}
