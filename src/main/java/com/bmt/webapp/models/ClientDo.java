package com.bmt.webapp.models;

import jakarta.validation.constraints.*;

public class ClientDo {
    
    @NotEmpty(message = "The First Name is required")
    private String firstName;  // 修正變數名稱
    
    @NotEmpty(message = "The Last Name is required")
    private String lastName;
    
    @NotEmpty(message = "The Email is required")
    @Email
    private String email;
    
    private String phone;
    private String address;
    
    @NotEmpty(message = "The Status is required")
    private String status;

    // 修正 getter 和 setter 方法
    public String getFirstName() {  // 修正方法名稱
        return firstName;
    }

    public void setFirstName(String firstName) {  // 修正方法名稱
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
