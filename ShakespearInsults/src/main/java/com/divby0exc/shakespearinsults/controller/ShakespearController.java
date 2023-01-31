package com.divby0exc.shakespearinsults.controller;

import com.divby0exc.shakespearinsults.service.ShakespearServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shakespear/*")
public class ShakespearController {
    @Autowired
    ShakespearServiceImpl shakespearServiceImpl;

    @GetMapping("get-all-insults")
    public ResponseEntity<?> getAllInsults() {

    }
    @GetMapping("get-insult/{id}")
    public ResponseEntity<?> getInsult() {

    }
    @DeleteMapping("get-insult/{id}")
    public ResponseEntity<?> deleteInsult() {

    }
    @PutMapping("replaceInsult/{id}")
    public ResponseEntity<?> replaceInsult() {

    }
    @PatchMapping("update-field/{id}")
    public ResponseEntity<?> partialUpdate() {

    }
    @PostMapping("add-insult")
    public ResponseEntity<?> addInsult() {

    }
}
