package com.example.cstgravience;

public class HelperClass {
    String Grievance,GrievanceId;

    public HelperClass(){

    }


    public HelperClass(String grievance, String grievanceId) {
        Grievance = grievance;
        GrievanceId = grievanceId;
    }

    public String getGrievance() {
        return Grievance;
    }

    public void setGrievance(String grievance) {

        Grievance = grievance;
    }

    public String getGrievanceId()
    {
        return GrievanceId;
    }

    public void setGrievanceId(String grievanceId) {

        GrievanceId = grievanceId;
    }
}
