package com.example.cstgravience;

public class HelperClass {
    String Grievance,GrievanceId,Name,date;

    public HelperClass(){

    }

    public HelperClass(String grievance, String grievanceId, String name, String date) {
        Grievance = grievance;
        GrievanceId = grievanceId;
        Name = name;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

//    public HelperClass(String grievance, String grievanceId, String name) {
//        Grievance = grievance;
//        GrievanceId = grievanceId;
//        Name = name;
//    }
//
//    public String getGrievance() {
//        return Grievance;
//    }
//
//    public void setGrievance(String grievance) {
//        Grievance = grievance;
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
