package com.divby0exc.shakespearinsults.repository;

import com.divby0exc.shakespearinsults.db.ShakespearDB;
import com.divby0exc.shakespearinsults.model.InsultRank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class RankRepository implements RowMapper<InsultRank> {
    private ShakespearDB db = null;
    public RankRepository() {
        db = ShakespearDB.getInstance();
    }
    @Autowired
    DataSource dataSource;
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

    public Optional<InsultRank> fetchRank(Long rankId) {
        //return rankRepo.findById(rankId);
        return null;
    }
    public List<InsultRank> fetchRankList() {
        //return (List<InsultRank>) rankRepo.findAll();
        return null;
    }
    public void saveRank(InsultRank rank) {
        SimpleJdbcInsert jdbcInsert =
                new SimpleJdbcInsert(dataSource).withTableName("insultrank");
        Map<String, Object> param = new HashMap<>();
        param.put("id", rank.getId());
        param.put("create_dt", rank.getCreate_dt());
        param.put("rank", rank.getRank());

        jdbcInsert.execute(param);
    }
}
