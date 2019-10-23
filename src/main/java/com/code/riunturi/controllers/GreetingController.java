package com.code.riunturi.controllers;

import com.code.riunturi.data.dto.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/randoms")
public class GreetingController {




    @RequestMapping("/greeting")
    public Greeting greeting() {

        System.out.println();
        return new Greeting(2,
                            "hey");
    }
}
