/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.code.riunturi.data.dto;

import com.code.riunturi.utils.RiuDate;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 *
 * @author ricardo
 */
public class RiuDateDto {
    
    private final int dayOfWeek;
    private final int week;
    private final int period;
    private final int era;
    private final String label;
    
    public RiuDateDto(RiuDate riudate){
    this.dayOfWeek = riudate.getDay().getValue();
    this.week = riudate.getWeek();
    this.period = riudate.getPeriod();
    this.era = riudate.getEra();
    this.label = riudate.toString();
    
    }

    public String getLabel() {
        return label;
    }
    
    

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public int getWeek() {
        return week;
    }

    public int getPeriod() {
        return period;
    }

    public int getEra() {
        return era;
    }
    
    
}
