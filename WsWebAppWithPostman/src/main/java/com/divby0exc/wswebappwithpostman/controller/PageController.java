package com.divby0exc.wswebappwithpostman.controller;

import com.divby0exc.wswebappwithpostman.model.Animal;
import com.divby0exc.wswebappwithpostman.model.Msg;
import com.divby0exc.wswebappwithpostman.service.AnimalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animal/*")
public class PageController {
    @Autowired
    AnimalServiceImpl service;
    @Autowired
    MsgController msgCon;

    @GetMapping("get/{id}")
    public Msg getAnimal(@PathVariable Long id) {
        Animal a = service.getAnimalById(id);
        Msg msg = new Msg();
        msg.setMessage("------Requested an animal------\n" + a.toString());
        return msgCon.send( msg);



    }
    @PostMapping("add")
    public Msg addAnimal( @RequestBody Animal a ) {

        service.save(a);
        Msg msg = new Msg();
        msg.setMessage("------Created an animal------\n" + a.toString());
        return msgCon.send(msg);
    }
}
