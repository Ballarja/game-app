package com.GameApp.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user")
public class Registration {
    @Id
    private UUID id = UUID.randomUUID();
    private String userName;
    private String email;
    private String password;

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
