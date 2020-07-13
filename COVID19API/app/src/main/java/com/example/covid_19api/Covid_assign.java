package com.example.covid_19api;

public class Covid_assign {
    private String confirmed, active, deaths, date;

    public Covid_assign(String confirmed, String active, String deaths, String date){
        this.confirmed = confirmed;
        this.active = active;
        this.deaths = deaths;
        this.date= date;
    }

    public String getConfirmed() {
        return active;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }
}
