package com.code.riunturi.controllers;

import com.code.riunturi.config.GeneralConfigs;
import com.code.riunturi.data.dto.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/random")
public class RandomController {
    @Autowired
    GeneralConfigs configs;



    @RequestMapping("/random")
    public Random getRandom(){
        System.out.println(configs.getAppname());
        System.out.println(configs.getGeneralManager());
    return (new Random(1));
    }


}
