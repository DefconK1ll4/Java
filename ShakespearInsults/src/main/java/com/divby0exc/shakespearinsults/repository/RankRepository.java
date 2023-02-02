package com.divby0exc.shakespearinsults.repository;

import com.divby0exc.shakespearinsults.db.ShakespearDB;
import com.divby0exc.shakespearinsults.model.InsultRank;
import com.divby0exc.shakespearinsults.model.ShakespearModel;
import org.springframework.beans.factory.annotation.Autowired;
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
    ShakespearRepository shakeRepository;
    @Override
    public InsultRank mapRow(ResultSet rs, int rowNum) throws SQLException {
        InsultRank ir = new InsultRank();
        ir.setId(rs.getLong("id"));
        ir.setCreate_dt(rs.getDate("create_dt"));
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

    public ShakespearModel fetchRank(Long rankId) {
        ShakespearModel sm = shakeRepository.findById(rankId);
        return sm;
    }
    public List<InsultRank> fetchRankList(Long id) {

    }
    public void saveRank(InsultRank rank) {
        SimpleJdbcInsert jdbcInsert =
                new SimpleJdbcInsert(dataSource).withTableName("insult_rank");
        Map<String, Object> param = new HashMap<>();
        param.put("id", rank.getId());
        param.put("owner_id", rank.getOwner_id());
        param.put("create_dt", rank.getCreate_dt());
        param.put("rank", rank.getRank());

        jdbcInsert.execute(param);
    }
}
