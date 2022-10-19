package com.example.cstgravience;

public class StarredDataModel {

    String cuEmail,GrievanceTITLE,GrieveanceTEXT;

    StarredDataModel(){

    }

    public StarredDataModel(String cuEmail, String grievanceTITLE, String grieveanceTEXT) {
        this.cuEmail = cuEmail;
        GrievanceTITLE = grievanceTITLE;
        GrieveanceTEXT = grieveanceTEXT;
    }

    public String getCuEmail() {
        return cuEmail;
    }

    public void setCuEmail(String cuEmail) {
        this.cuEmail = cuEmail;
    }

    public String getGrievanceTITLE() {
        return GrievanceTITLE;
    }

    public void setGrievanceTITLE(String grievanceTITLE) {
        GrievanceTITLE = grievanceTITLE;
    }

    public String getGrieveanceTEXT() {
        return GrieveanceTEXT;
    }

    public void setGrieveanceTEXT(String grieveanceTEXT) {
        GrieveanceTEXT = grieveanceTEXT;
    }
}
