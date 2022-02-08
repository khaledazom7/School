package com.amjad.school.model;

import com.google.gson.annotations.SerializedName;

import androidx.annotation.Keep;

public class User {

    @Keep
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("userImage")
    private String userImage;
    @SerializedName("dateOfBirth")
    private String dateOfBirth;
    @SerializedName("gender")
    private String gender;
    @SerializedName("userType")
    private String userType;
    @SerializedName("studentLevel")
    private String studentLevel;
    @SerializedName("phone")
    private String phone;
    @SerializedName("address")
    private String address;
    @SerializedName("dateCreate")
    private String dateCreate;
    @SerializedName("status")
    private boolean status;

    public User(String name, String email, String userImage, String dateOfBirth, String gender, String userType, String studentLevel, String phone, String address, String dateCreate, boolean status) {
        this.name = name;
        this.email = email;
        this.userImage = userImage;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.userType = userType;
        this.studentLevel = studentLevel;
        this.phone = phone;
        this.address = address;
        this.dateCreate = dateCreate;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getStudentLevel() {
        return studentLevel;
    }

    public void setStudentLevel(String studentLevel) {
        this.studentLevel = studentLevel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
