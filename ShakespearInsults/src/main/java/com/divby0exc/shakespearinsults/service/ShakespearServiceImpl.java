package com.divby0exc.shakespearinsults.service;

import com.divby0exc.shakespearinsults.model.InsultRank;
import com.divby0exc.shakespearinsults.model.ShakespearModel;
import com.divby0exc.shakespearinsults.repository.ShakespearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShakespearServiceImpl implements ShakespearService {

    @Autowired
    private ShakespearRepository repository;

    @Override
    public ShakespearModel saveInsult(ShakespearModel insult) {
        return null;
    }

    @Override
    public InsultRank saveRank(InsultRank rank) {
        return null;
    }

    @Override
    public List<ShakespearModel> fetchInsultList() {
        return null;
    }

    @Override
    public ShakespearModel fetchInsult(Long insultId) {
        return null;
    }

    @Override
    public List<InsultRank> fetchRankList() {
        return null;
    }

    @Override
    public InsultRank fetchRank(Long rankId) {
        return null;
    }

    @Override
    public ShakespearModel updateInsult(ShakespearModel insult, Long insultId) {
        return null;
    }

    @Override
    public InsultRank updateRank(InsultRank rank, Long rankId) {
        return null;
    }

    @Override
    public void deleteInsultById(Long insultId) {

    }

    @Override
    public void deleteRankById(Long rankId) {

    }
}
