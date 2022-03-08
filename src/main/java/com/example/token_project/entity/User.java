package com.example.token_project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_tBL")
public class User {
    @Id
    private  int id;
    private  String userName;
    private  String password;
    private  String email;

}
