package com.divby0exc.shakespearinsults.controller;

import com.divby0exc.shakespearinsults.model.ShakespearModel;
import com.divby0exc.shakespearinsults.service.ShakespearServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shakespear/*")
public class ShakespearController {
    @Autowired
    ShakespearServiceImpl shakespearService;

    @GetMapping("get-all-insults")
    public List<ShakespearModel> getAllInsults() {

        return shakespearService.fetchInsultList();
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
        return shakespearService.updateInsult(shakespearModel, insultId);
    }
    @PostMapping("add-insult")
    public ShakespearModel addInsult(@RequestBody ShakespearModel shakespearModel) {
        return shakespearService.saveInsult(shakespearModel);
    }
}
