package com.divby0exc.wswebappwithpostman.controller;

import com.divby0exc.wswebappwithpostman.model.DTOChannel;
import com.divby0exc.wswebappwithpostman.service.ChannelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

/**

 Studerande väljer hur deltagare av borttagna kanaler hanteras. Det är ok att låta de vara kvar efter att annonsen är borttagen.

 */

@RestController
public class APIController {
    @Autowired
    ChannelServiceImpl cs;
 /**[GET] /channels/ ← Hämtar en lista över annonserade kanaler**/
    @GetMapping("/channels")
    public ResponseEntity<List<DTOChannel>> getAllChannels() {
        List<DTOChannel> channels = new ArrayList<>();
        if (cs.getAll().isEmpty()) {
            ResponseEntity.status(204)
                    .build();
        }
        channels.addAll(cs.getAll());

        return
                ResponseEntity
                        .status(200)
                        .body(channels);
    }
    /**[POST] - /channels/ ← skapar en ny kanal som annonseras i den permanenta chatt-kanalen.**/
    @PostMapping("/channels/{channelId}")
    public ResponseEntity addNewChannel(@PathVariable int channelId) {
        return
                ResponseEntity
                        .status(200)
                        .body("Channel with ID: " + channelId + " has been created");
    }
    /**[DELETE] /channels/{id} ← tar bort en annonserad kanal**/
    @DeleteMapping("/channels/{channelId}")
    public ResponseEntity deleteChannel(@PathVariable Long channelId) {
        cs.deleteDTOChannelById(channelId);
        assert cs.getDTOChannelById(channelId)==null;
        //Assert.isTrue(cs.getDTOChannelById(channelId)==null, "Deleted channel with ID: " + channelId);
        return ResponseEntity
                .status(410)
                .build();
    }
}
