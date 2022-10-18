package com.example.cstgravience;

public class hdatamodel {
    String grievance,GrievanceId,Name;

    public hdatamodel() {
    }

    public hdatamodel(String grievance, String grievanceId, String name) {
        this.grievance = grievance;
        GrievanceId = grievanceId;
        Name = name;
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

