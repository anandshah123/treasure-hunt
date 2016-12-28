package com.github.treasurehunt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "user_info")
public class UserInfo {

    @Id
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String teamName;
    @NotNull
    private String teamMembers;
    @NotNull
    private String userRole;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(String teamMembers) {
        this.teamMembers = teamMembers;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
