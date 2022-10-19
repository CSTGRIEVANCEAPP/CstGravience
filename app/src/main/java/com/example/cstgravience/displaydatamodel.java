package com.example.cstgravience;

public class displaydatamodel {

    String grievance;
    String grievanceId;
    String Name;
    String date;

    public displaydatamodel() {
    }

    public displaydatamodel(String grievance, String grievanceId, String name, String date) {
        this.grievance = grievance;
        this.grievanceId = grievanceId;
        Name = name;
        this.date = date;
    }

    public String getGrievance() {
        return grievance;
    }

    public void setGrievance(String grievance) {
        this.grievance = grievance;
    }

    public String getGrievanceId() {
        return grievanceId;
    }

    public void setGrievanceId(String grievanceId) {
        this.grievanceId = grievanceId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

//    public displaydatamodel(String grievance, String grievanceId, String name) {
//        this.grievance = grievance;
//        this.grievanceId = grievanceId;
//        Name = name;
//    }
//
//    public String getGrievance() {
//        return grievance;
//    }
//
//    public void setGrievance(String grievance) {
//        this.grievance = grievance;
//    }
//
//    public String getGrievanceId() {
//        return grievanceId;
//    }
//
//    public void setGrievanceId(String grievanceId) {
//        this.grievanceId = grievanceId;
//    }
//
//    public String getName() {
//        return Name;
//    }
//
//    public void setName(String name) {
//        Name = name;
//    }

//    public displaydatamodel(String grievance, String grievanceId) {
//        this.grievance = grievance;
//        this.grievanceId = grievanceId;
//    }
//
//    public String getGrievance() {
//        return grievance;
//    }
//
//    public void setGrievance(String grievance) {
//        this.grievance = grievance;
//    }
//
//    public String getGrievanceId() {
//        return grievanceId;
//    }
//
//    public void setGrievanceId(String grievanceId) {
//        this.grievanceId = grievanceId;
//    }
}
