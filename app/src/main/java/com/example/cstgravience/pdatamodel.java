package com.example.cstgravience;

public class pdatamodel {
    String grievance;
    String GrievanceId;
    String Name;
    String date;

    public pdatamodel() {
    }

    public pdatamodel(String grievance, String grievanceId, String name, String date) {
        this.grievance = grievance;
        GrievanceId = grievanceId;
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



//    public pdatamodel(String grievance, String grievanceId, String name) {
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


//    public pdatamodel(String grievance, String grievanceId) {
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
