package com.amjad.school.model;

import androidx.annotation.Keep;

import com.google.gson.annotations.SerializedName;

public class Teacher extends User {

    @Keep
    @SerializedName("major")
    private String major;

    @Keep
    @SerializedName("degree")
    private String degree;

    @Keep
    @SerializedName("experiences")
    private String experiences;

    @Keep
    @SerializedName("skills")
    private String skills;

    @Keep
    @SerializedName("identification")
    private String identification;

    @Keep
    @SerializedName("education")
    private String education;

    @Keep
    @SerializedName("medicalRecord")
    private String medicalRecord;

    @Keep
    @SerializedName("accountStatement")
    private String accountStatement;

    public Teacher() {
    }

    public Teacher(String major, String degree, String experiences, String skills, String identification, String education, String medicalRecord, String accountStatement) {
        this.major = major;
        this.degree = degree;
        this.experiences = experiences;
        this.skills = skills;
        this.identification = identification;
        this.education = education;
        this.medicalRecord = medicalRecord;
        this.accountStatement = accountStatement;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getExperiences() {
        return experiences;
    }

    public void setExperiences(String experiences) {
        this.experiences = experiences;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(String medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public String getAccountStatement() {
        return accountStatement;
    }

    public void setAccountStatement(String accountStatement) {
        this.accountStatement = accountStatement;
    }
}