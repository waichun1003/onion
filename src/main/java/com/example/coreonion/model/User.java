package com.example.coreonion.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long userId;
    private String email;
    private String passwordHash;
    private String role;
    private Date createdAt;
    private Date updatedAt;
    private boolean emailVerified;
    private String verificationToken;

//    public User(Long userId, String email,String passwordHash,String role,Date createdAt,
//                Date updatedAt,boolean emailVerified, String verificationToken) {
//        this.userId = userId;
//        this.email = email;
//        this.passwordHash = passwordHash;
//        this.role = role;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
//        this.emailVerified = emailVerified;
//        this.verificationToken = verificationToken;
//
//    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getVerificationToken() {
        return verificationToken;
    }

    public void setVerificationToken(String verificationToken) {
        this.verificationToken = verificationToken;
    }
}
