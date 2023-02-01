package com.divby0exc.shakespearinsults.controller;

import com.divby0exc.shakespearinsults.model.ShakespearModel;
import com.divby0exc.shakespearinsults.repository.ShakespearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shakespear/*")
public class ShakespearController {
    /**@Autowired
    ShakespearServiceImpl shakespearService;**/
    @Autowired
    ShakespearRepository repo;

    @GetMapping("get-all-insults")
    public List<ShakespearModel> getAllInsults() {
        return new ArrayList<>(repo.fetchInsultList());
    }
    @GetMapping("get-insult/{id}")
    public ShakespearModel getInsult(@PathVariable Long id) {
        return repo.findById(id);
    }
    @DeleteMapping("get-insult/{id}")
    public ResponseEntity<?> deleteInsult(@PathVariable Long id) {
    return
            ResponseEntity
                    .status(200)
                    .body(repo.deleteInsultById(id));
    }
    @PutMapping("replaceInsult/{id}")
    public ResponseEntity<?> replaceInsult() {
        return null;
    }
    @PatchMapping("update-field/{id}")
    public ResponseEntity<?> partialUpdate(@RequestBody ShakespearModel shakespearModel, @PathVariable Long insultId) {
        return
                ResponseEntity
                .status(200)
                .body(repo.updateInsult(shakespearModel, insultId));
    }
    @PostMapping("add-insult")
    public ResponseEntity<?> addInsult(@RequestBody ShakespearModel shakespearModel) {
        repo.saveInsult(shakespearModel);

        return
                ResponseEntity
                        .ok("Added insult to db");
    }
}
