/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.code.riunturi.utils;

import java.io.Serializable;
import java.time.DayOfWeek;
import static java.time.DayOfWeek.SUNDAY;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/** a date based on my system of numeration. Where I have the following : N1.N1.N3.N4
 *N1 is a letter that corresponds to a day of the week
 * N2 is the number of week that goes from 1 to 4.
 * N3 is the number of the period, analogue to the month is a group of 4 weeks, and 13 make up an era
 * slightly shorter than a year, analogue to it its the combination of 13 period of 4 weeks each.
 * No riudate before the origin 
 * The origin is the 13th of may of 2012 where the U.1.1.1 is set meaning the begging of times according to this system
 * @author Riunturi
 */
public class RiuDate implements Serializable{

    /**
     * When U.1.1.1 is set meaning the beginning of times according to this system
     */
    public static final LocalDate ORIGIN = LocalDate.of(2012, Month.MAY, 13);
//    
    /**
     * the day of the week
     */
    private final DayOfWeek day;
    /**
     * The week number that goes from 1 to 4 ( both included.
     */
    private final int week;
    /**
     * The period that goes from 1 to 13 both included. Analogue to a month, but set to be 4 weeks always.(so also always 28 days)
     */
    private final int period;
    /**
     * Analog to a year. Is 13 periods, slightly shorter than a year, its set to be 13 periods so always 13*28 days. 
     */
    private final int era;
//
    /**
     * The constructor
     * @param day the day of the week
     * @param week the week number from 1 to 4
     * @param period the period number from 1 to 13
     * @param era the era number
     */
    private RiuDate(DayOfWeek day, int week, int period, int era) {
        this.day = day;
        this.week = week;
        this.period = period;
        this.era = era;
    }
    
    public static List<LocalDate> getDaysOfThisWeek (LocalDate date){
    
        List<LocalDate> list = new ArrayList();
        
        LocalDate sunday = date.minusDays(date.getDayOfWeek()==SUNDAY?0:date.getDayOfWeek().getValue());
        
        for (int i=0; i<7;i++){
            list.add(sunday.plusDays(i));
        }
    
                return list;
    }
    
    public static List<LocalDate> getDaysOfThisWeek (RiuDate date){
    
        return getDaysOfThisWeek(date.toLocalDate());
    }
    
    public static List<LocalDate> getDaysOfThisWeek (Integer week,Integer period, Integer era){
    
        return getDaysOfThisWeek(new RiuDate(SUNDAY, week, period, era));
    }
    
//    
    /**
     * changes a localDate to the RiuDate systemDates before the origin (2012-May-13) are not supported.
     * @param date the dated wished to be changed to the RiuDate system.
     * @return 
     */
    public static RiuDate of(LocalDate date) {

//         LocalDate ORIGIN= LocalDate.of(2012, Month.MAY, 13);
//        LocalDate test= LocalDate.of(2017, Month.AUGUST,28);
        long elapsedDays = ChronoUnit.DAYS.between(ORIGIN, date);
        //long elapsedDays = 28;

        DayOfWeek day = date.getDayOfWeek();
        int week = Long.valueOf((((elapsedDays / 7)) % 4) + 1).intValue();
        int period = Long.valueOf((((elapsedDays / 28)) % 13) + 1).intValue();
        int era = Long.valueOf((elapsedDays / (28 * 13)) + 1).intValue();
        
        return new RiuDate(day, week, period, era);

    }
    
    /**
     * 
     * @return the current date in the riuDate format 
     */
    public static RiuDate now (){
    return RiuDate.of(LocalDate.now());
    }
    
    /**
     * 
     * @return a LocalDate corresponding to the this riuDate. Dates before the origin are not supported 
     */
    
    public LocalDate toLocalDate(){
    int elapsedDays= this.day.getValue()==7? 0:this.day.getValue();
    elapsedDays+= (this.week-1)*7;
    elapsedDays+= (this.period-1)*28;
    elapsedDays+=(this.era-1)*28*13;
    
    return ORIGIN.plusDays(elapsedDays);
    }
    
    @Override
    public String toString(){
    return RiuDate.weekAcronym(this.day)+"."+this.week+"."+this.period+"."+this.era;
    
    }
    
    public static String weekAcronym(DayOfWeek week){
    
        switch(week){
            case SUNDAY: return "U";
            case MONDAY: return "M";
            case TUESDAY: return "T";
            
            case WEDNESDAY: return "W";
            case THURSDAY: return "R";
            case FRIDAY: return "F";
            
            case SATURDAY :return "S";
            
                
                    }        
   throw   new RuntimeException("problem changing week to acronym");
    }

    

    /**
     * Made this for testing purposes
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

 
        for(LocalDate date: getDaysOfThisWeek(LocalDate.now())){
            System.out.println(date.toString());
        }
        

    }

    public DayOfWeek getDay() {
        return day;
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
