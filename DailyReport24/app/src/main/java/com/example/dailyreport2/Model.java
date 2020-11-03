package com.example.dailyreport2;

public class Model {
    String id,date,project,challenge,difficulty,staffname,time,village,persongroup,meetingpoint,actionpoint,nextdayPlanning;
    public Model(String id,String date,String project,String challenge,String difficulty,String staffname, String time, String village, String persongroup, String meetingpoint, String actionpoint, String nextdayPlanning) {
        this.id = id;
        this.date = date;
        this.project = project;
        this.challenge = challenge;
        this.difficulty = difficulty;
        this.staffname = staffname;
        this.time = time;
        this.village = village;
        this.persongroup = persongroup;
        this.meetingpoint = meetingpoint;
        this.actionpoint = actionpoint;
        this.nextdayPlanning = nextdayPlanning;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getChallenge() {
        return challenge;
    }

    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getPersongroup() {
        return persongroup;
    }

    public void setPersongroup(String persongroup) {
        this.persongroup = persongroup;
    }

    public String getMeetingpoint() {
        return meetingpoint;
    }

    public void setMeetingpoint(String meetingpoint) {
        this.meetingpoint = meetingpoint;
    }

    public String getActionpoint() {
        return actionpoint;
    }

    public void setActionpoint(String actionpoint) {
        this.actionpoint = actionpoint;
    }

    public String getNextdayPlanning() {
        return nextdayPlanning;
    }

    public void setNextdayPlanning(String nextdayPlanning) {
        this.nextdayPlanning = nextdayPlanning;
    }
}


