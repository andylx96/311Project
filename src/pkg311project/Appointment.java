/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg311project;

/**
 *
 * @author zabuz
 */
public class Appointment {

    String name, startTime, startAmPM, endTime, endAmPm, dateMonth, dateDay, dateYear;

    Appointment(String name, String dateMonth, String dateDay, String dateYear, String startTime, String startAmPm, String endTime, String endAmPm) {
        this.name = name;
        this.dateMonth = dateMonth;
        this.dateDay = dateDay;
        this.dateYear = dateYear;
        this.startTime = startTime;
        this.startAmPM = startAmPm;
        this.endTime = endTime;
        this.endAmPm = endAmPm;

    }

    public String getDateMonth() {
        return dateMonth;
    }

    public void setDateMonth(String dateMonth) {
        this.dateMonth = dateMonth;
    }

    public String getDateDay() {
        return dateDay;
    }

    public void setDateDay(String dateDay) {
        this.dateDay = dateDay;
    }

    public String getDateYear() {
        return dateYear;
    }

    public void setDateYear(String dateYear) {
        this.dateYear = dateYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartAmPM() {
        return startAmPM;
    }

    public void setStartAmPM(String startAmPM) {
        this.startAmPM = startAmPM;
    }

    public String getEndAmPm() {
        return endAmPm;
    }

    public void setEndAmPm(String endAmPm) {
        this.endAmPm = endAmPm;
    }

}
