package com.example.cstgravience;

public class hdatamodel {
    String grievance;

    public String getGrievance() {
        return grievance;
    }

    public void setGrievance(String grievance) {
        this.grievance = grievance;
    }

    public String getGrievanceId() {
        return GrievanceId;
    }

    public void setGrievanceId(String grievanceId) {
        GrievanceId = grievanceId;
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

    String GrievanceId;
    String Name;
    String date;

    public hdatamodel() {
    }

    public hdatamodel(String grievance, String grievanceId, String name, String date) {
        this.grievance = grievance;
        GrievanceId = grievanceId;
        Name = name;
        this.date = date;
    }

//    public hdatamodel(String grievance, String grievanceId, String name) {
//        this.grievance = grievance;
//        GrievanceId = grievanceId;
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
//        return GrievanceId;
//    }
//
//    public void setGrievanceId(String grievanceId) {
//        GrievanceId = grievanceId;
//    }
//
//    public String getName() {
//        return Name;
//    }
//
//    public void setName(String name) {
//        Name = name;
//    }


//    public hdatamodel(String grievance, String grievanceId) {
//        this.grievance = grievance;
//        GrievanceId = grievanceId;
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
//        return GrievanceId;
//    }
//
//    public void setGrievanceId(String grievanceId) {
//        GrievanceId = grievanceId;
//    }
}

