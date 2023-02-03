package com.divby0exc.shakespearinsults.repository;

import com.divby0exc.shakespearinsults.db.ShakespearDB;
import com.divby0exc.shakespearinsults.model.InsultRank;
import com.divby0exc.shakespearinsults.model.ShakespearModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
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
    @Autowired
    RankRepository rankRepo;

        public void
        saveInsult(ShakespearModel insult) {
            SimpleJdbcInsert jdbcInsert =
                    new SimpleJdbcInsert(dataSource).withTableName("insult");

            Map<String, Object> param = new HashMap<>();
            param.put("content", insult.getContent());

            jdbcInsert.execute(param);
        }
        public ShakespearModel findById(Long id) {

            return jdbc.queryForObject(
                    "SELECT * FROM insult WHERE id=?",
                    new Object[] {id},
                    (rs, rowNum) -> {
                        ShakespearModel insult = new ShakespearModel();
                        insult.setId(rs.getLong("id"));
                        insult.setContent(rs.getString("content"));
                        insult.setRankList(rankRepo.fetchRankList(id));

                        return insult;
                    });
        }

        public List<ShakespearModel> fetchInsultList() {
        return jdbc.query("SELECT * FROM insult", (rs, rowNum) -> {
            ShakespearModel insult = new ShakespearModel();
            insult.setId(rs.getLong("id"));
            insult.setContent(rs.getString("content"));

            return insult;
        });
        }

        public int updateInsult(ShakespearModel insult, Long insultId) {
            String sql = "UPDATE insult SET content=? WHERE id=?";

            return jdbc.update(sql, insult.getContent(), insultId);
        }

        public int deleteInsultById(Long insultId) {
            String sql = "DELETE FROM insult WHERE id=?";
            return jdbc.update(sql, insultId);
        }


}
