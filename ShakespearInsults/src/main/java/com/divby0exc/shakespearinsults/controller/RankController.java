package com.divby0exc.shakespearinsults.controller;

import com.divby0exc.shakespearinsults.model.InsultRank;
import com.divby0exc.shakespearinsults.repository.RankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shakespear/*")
public class RankController {
    @Autowired
    RankRepository repo;

/**
    @GetMapping("rank/{id}")
    public ResponseEntity<?> getRank() {
        InsultRank ir = new InsultRank();

    }
    @GetMapping("ranks")
    public ResponseEntity<?> getAllRanks() {

    }
**/
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