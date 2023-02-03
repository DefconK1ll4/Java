package com.divby0exc.shakespearinsults.controller;

import com.divby0exc.shakespearinsults.model.InsultRank;
import com.divby0exc.shakespearinsults.model.ShakespearModel;
import com.divby0exc.shakespearinsults.repository.RankRepository;
import com.divby0exc.shakespearinsults.repository.ShakespearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shakespear/*")
public class RankController {
    @Autowired
    RankRepository repo;
    @Autowired
    ShakespearRepository shakeRepo;

/**
    @GetMapping("rank/{id}")
    public ResponseEntity<?> getRank() {
        InsultRank ir = new InsultRank();

    }
 **/
    @GetMapping("ranks/{id}")
    public Map<ShakespearModel, List<InsultRank>> getAllRanks(@PathVariable Long id) {
        ShakespearModel sm = shakeRepo.findById(id);
        sm.setRankList(repo.fetchRankList(id));
        Map<ShakespearModel, List<InsultRank>> linking = new HashMap<>();
        linking.put(sm, sm.getRankList());
        return linking;
    }

    @PostMapping("add-rank")
    public ResponseEntity<?> addRank(@RequestBody InsultRank ir) {
        repo.saveRank(ir);

        return ResponseEntity
                .ok("Added to db");
    }
/**    @GetMapping("ranks/between-dates")
    public ResponseEntity<?> rankBetweenDates() {

    }
    @GetMapping("ranks/average-rank")
    public ResponseEntity<?> averageRank() {

    }
    @GetMapping("ranks/highest-rank")
    public ResponseEntity<?> highestRankedInsult() {

    }
    @GetMapping("ranks/lowest-rank")
    public ResponseEntity<?> lowestRankedInsult() {

    }

}
**/
}