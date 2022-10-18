package com.example.cstgravience;

public class HelperClass {
    String Grievance,GrievanceId,Name;

    public HelperClass(){

    }

    public HelperClass(String grievance, String grievanceId, String name) {
        Grievance = grievance;
        GrievanceId = grievanceId;
        Name = name;
    }

    public String getGrievance() {
        return Grievance;
    }

    public void setGrievance(String grievance) {
        Grievance = grievance;
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


//    public HelperClass(String grievance, String grievanceId,String Scategory) {
//        Grievance = grievance;
//        GrievanceId = grievanceId;
//        Name = Scategory;
//
//    }
//
//    public String getGrievance() {
//        return Grievance;
//    }
//
//    public void setGrievance(String grievance) {
//
//        Grievance = grievance;
//    }
//
//    public String getGrievanceId()
//    {
//        return GrievanceId;
//    }
//
//    public void setGrievanceId(String grievanceId) {
//
//        GrievanceId = grievanceId;
//    }
}
