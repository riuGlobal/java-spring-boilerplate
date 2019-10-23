/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.code.riunturi.controllers;

import com.code.riunturi.data.dto.RiuDateDto;
import com.code.riunturi.utils.RiuDate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ricardo
 */
@RestController
@RequestMapping("api/riudate")
public class RiuDateController {
   
    @RequestMapping("/now")
    public RiuDateDto now(){
    
        return new RiuDateDto(RiuDate.now());
    }
    
    
}
