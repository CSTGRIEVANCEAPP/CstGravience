package com.example.cstgravience;

public class DraftGrievance {
    private String Grievance_Category;
    private String Grievance_Text;
    private String GrievanceKey;
    private String grievanceID;
    private String date;

    public DraftGrievance(){

    }

    public DraftGrievance(String grievance_Category, String grievance_Text, String grievanceKey, String grievanceID, String date) {
        Grievance_Category = grievance_Category;
        Grievance_Text = grievance_Text;
        GrievanceKey = grievanceKey;
        this.grievanceID = grievanceID;
        this.date = date;
    }

    public String getGrievance_Category() {
        return Grievance_Category;
    }

    public void setGrievance_Category(String grievance_Category) {
        Grievance_Category = grievance_Category;
    }

    public String getGrievance_Text() {
        return Grievance_Text;
    }

    public void setGrievance_Text(String grievance_Text) {
        Grievance_Text = grievance_Text;
    }

    public String getGrievanceKey() {
        return GrievanceKey;
    }

    public void setGrievanceKey(String grievanceKey) {
        GrievanceKey = grievanceKey;
    }

    public String getGrievanceID() {
        return grievanceID;
    }

    public void setGrievanceID(String grievanceID) {
        this.grievanceID = grievanceID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

//    public DraftGrievance(String grievance_Category, String grievance_Text, String grievanceKey, String grievanceID) {
//        Grievance_Category = grievance_Category;
//        Grievance_Text = grievance_Text;
//        GrievanceKey = grievanceKey;
//        this.grievanceID = grievanceID;
//    }
//
//    public String getGrievance_Category() {
//        return Grievance_Category;
//    }
//
//    public void setGrievance_Category(String grievance_Category) {
//        Grievance_Category = grievance_Category;
//    }
//
//    public String getGrievance_Text() {
//        return Grievance_Text;
//    }
//
//    public void setGrievance_Text(String grievance_Text) {
//        Grievance_Text = grievance_Text;
//    }
//
//    public String getGrievanceKey() {
//        return GrievanceKey;
//    }
//
//    public void setGrievanceKey(String grievanceKey) {
//        GrievanceKey = grievanceKey;
//    }
//
//    public String getGrievanceID() {
//        return grievanceID;
//    }
//
//    public void setGrievanceID(String grievanceID) {
//        this.grievanceID = grievanceID;
//    }


//    public DraftGrievance(String grievance_Category, String grievance_Text, String grievanceKey) {
//        Grievance_Category = grievance_Category;
//        Grievance_Text = grievance_Text;
//        GrievanceKey = grievanceKey;
//    }
//
//    public String getGrievance_Category() {
//        return Grievance_Category;
//    }
//
//    public void setGrievance_Category(String grievance_Category) {
//        Grievance_Category = grievance_Category;
//    }
//
//    public String getGrievance_Text() {
//        return Grievance_Text;
//    }
//
//    public void setGrievance_Text(String grievance_Text) {
//        Grievance_Text = grievance_Text;
//    }
//
//    public String getGrievanceKey() {
//        return GrievanceKey;
//    }
//
//    public void setGrievanceKey(String grievanceKey) {
//        GrievanceKey = grievanceKey;
//    }
}
