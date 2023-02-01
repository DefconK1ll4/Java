package com.divby0exc.shakespearinsults.controller;

import com.divby0exc.shakespearinsults.model.ShakespearModel;
import com.divby0exc.shakespearinsults.repository.ShakespearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//        return shakespearService.fetchInsultList();
        return null;
    }
    @GetMapping("get-insult/{id}")
    public ResponseEntity<?> getInsult() {
        return null;
    }
    @DeleteMapping("get-insult/{id}")
    public ResponseEntity<?> deleteInsult() {
    return null;
    }
    @PutMapping("replaceInsult/{id}")
    public ResponseEntity<?> replaceInsult() {
        return null;
    }
    @PatchMapping("update-field/{id}")
    public ShakespearModel partialUpdate(@RequestBody ShakespearModel shakespearModel, @PathVariable Long insultId) {
        //return shakespearService.updateInsult(shakespearModel, insultId);
        return null;
    }
    @PostMapping("add-insult")
    public ResponseEntity<?> addInsult(@RequestBody ShakespearModel shakespearModel) {
        repo.saveInsult(shakespearModel);

        return ResponseEntity.ok("Added insult to db");
    }
}
