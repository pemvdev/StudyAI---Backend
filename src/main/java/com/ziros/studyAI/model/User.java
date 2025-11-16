package com.ziros.studyAI.model;

import com.ziros.studyAI.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    public User(){}

    public User(UserDTO dto){
        this.name = dto.name();
        this.email = dto.email();
        this.password = dto.password();
    }
}
