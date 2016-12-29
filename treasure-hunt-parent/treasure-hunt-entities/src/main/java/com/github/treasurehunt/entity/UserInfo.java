package com.github.treasurehunt.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@Entity
@Table(name = "user_info")
public class UserInfo implements Serializable {
    @Id
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String team_name;
    @NotNull
    private String team_members;
    @NotNull
    private String user_role = "ROLE_USER";
}
