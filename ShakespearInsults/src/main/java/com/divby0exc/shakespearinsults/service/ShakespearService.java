package com.divby0exc.shakespearinsults.service;

import com.divby0exc.shakespearinsults.model.InsultRank;
import com.divby0exc.shakespearinsults.model.ShakespearModel;

import java.util.List;

public interface ShakespearService {

    ShakespearModel saveInsult(ShakespearModel insult);
    InsultRank saveRank(InsultRank rank);

    List<ShakespearModel> fetchInsultList();
    ShakespearModel fetchInsult(Long insultId);
    List<InsultRank> fetchRankList();
    InsultRank fetchRank(Long rankId);
    ShakespearModel updateInsult(ShakespearModel insult, Long insultId);
    InsultRank updateRank(InsultRank rank, Long rankId);
    void deleteInsultById(Long insultId);
    void deleteRankById(Long rankId);
}
