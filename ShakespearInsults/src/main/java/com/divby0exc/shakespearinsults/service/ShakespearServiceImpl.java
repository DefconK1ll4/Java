package com.divby0exc.shakespearinsults.service;

import com.divby0exc.shakespearinsults.db.ShakespearDB;
import com.divby0exc.shakespearinsults.model.InsultRank;
import com.divby0exc.shakespearinsults.model.ShakespearModel;
import com.divby0exc.shakespearinsults.repository.RankRepository;
import com.divby0exc.shakespearinsults.repository.ShakespearRepository;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

//@Service
//public class ShakespearServiceImpl implements ShakespearService {
/**
    @Autowired
    private ShakespearRepository insultRepo;
    @Autowired
    private RankRepository rankRepo;

    @Override
    public ShakespearModel saveInsult(ShakespearModel insult) {
        return insultRepo.save(insult);
    }

    @Override
    public InsultRank saveRank(InsultRank rank) {
        return rankRepo.save(rank);
    }

    @Override
    public List<ShakespearModel> fetchInsultList() {
        return (List<ShakespearModel>) insultRepo.findAll();
    }

    @Override
    public Optional<ShakespearModel> fetchInsult(Long insultId) {
        return insultRepo.findById(insultId);
    }

    @Override
    public List<InsultRank> fetchRankList() {
        return (List<InsultRank>) rankRepo.findAll();
    }

    @Override
    public Optional<InsultRank> fetchRank(Long rankId) {
        return rankRepo.findById(rankId);
    }

    @Override
    public ShakespearModel updateInsult(ShakespearModel insult, Long insultId) {
        return null;
    }

    @Override
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

        return null;
    }
/**
    @Override
    public void deleteInsultById(Long insultId) {

    }

    @Override
    public void deleteRankById(Long rankId) {

    }
**/
//}
