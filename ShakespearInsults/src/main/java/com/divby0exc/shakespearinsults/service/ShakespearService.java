package com.divby0exc.shakespearinsults.service;

import com.divby0exc.shakespearinsults.model.InsultRank;
import com.divby0exc.shakespearinsults.model.ShakespearModel;

import java.util.List;
import java.util.Optional;

public interface ShakespearService {

    ShakespearModel saveInsult(ShakespearModel insult);
    InsultRank saveRank(InsultRank rank);

    List<ShakespearModel> fetchInsultList();
    Optional<ShakespearModel> fetchInsult(Long insultId);
    List<InsultRank> fetchRankList();
    Optional<InsultRank> fetchRank(Long rankId);
    ShakespearModel updateInsult(ShakespearModel insult, Long insultId);
    InsultRank updateRank(InsultRank rank, Long rankId, String type);
    void deleteInsultById(Long insultId);
    void deleteRankById(Long rankId);
}
