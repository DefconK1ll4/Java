package com.divby0exc.shakespearinsults.repository;

import com.divby0exc.shakespearinsults.db.ShakespearDB;
import com.divby0exc.shakespearinsults.model.InsultRank;
import com.divby0exc.shakespearinsults.model.ShakespearModel;
import com.divby0exc.shakespearinsults.service.ShakespearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class ShakespearRepository implements RowMapper<ShakespearModel> {
    private ShakespearDB db = null;
    public ShakespearRepository() {
        db = ShakespearDB.getInstance();
    }
    @Autowired
    DataSource dataSource;

        public void saveInsult(ShakespearModel insult) {
            SimpleJdbcInsert jdbcInsert =
                    new SimpleJdbcInsert(dataSource).withTableName("insult");

            Map<String, Object> param = new HashMap<>();
            param.put("content", insult.getInsult());

            jdbcInsert.execute(param);
        }

        public List<ShakespearModel> fetchInsultList() {
            return (List<ShakespearModel>) insultRepo.findAll();
        }

        public Optional<ShakespearModel> fetchInsult(Long insultId) {
            return insultRepo.findById(insultId);
        }




        public ShakespearModel updateInsult(ShakespearModel insult, Long insultId) {
            return null;
        }

        public void deleteInsultById(Long insultId) {

        }
        @Override
    public ShakespearModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            ShakespearModel insult = new ShakespearModel();
            insult.setId(rs.getLong("id"));
            insult.setInsult(rs.getString("content"));

            return insult;
    }


}
