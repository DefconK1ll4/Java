package com.divby0exc.shakespearinsults.controller;

import com.divby0exc.shakespearinsults.service.ShakespearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RankController {

    @Autowired
    ShakespearService shakespearService;

    @GetMapping("rank/{id}")
    public ResponseEntity<?> getRank() {

    }
    @GetMapping("ranks")
    public ResponseEntity<?> getAllRanks() {

    }
    @PostMapping("add-rank")
    public ResponseEntity<?> addRank() {

    }
    @GetMapping("ranks/between-dates")
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
