package com.example.cstgravience;

public class pdatamodel {
    String grievance,GrievanceId;

    public pdatamodel() {
    }


    public pdatamodel(String grievance, String grievanceId) {
        this.grievance = grievance;
        GrievanceId = grievanceId;
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
}
