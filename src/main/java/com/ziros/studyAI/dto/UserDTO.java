package com.ziros.studyAI.dto;

import com.ziros.studyAI.model.User;

public record UserDTO (Long idUser, String name, String email, String password){

    public UserDTO(User user){
        this(user.getId(), user.getName(), user.getEmail(), user.getPassword());
    }
}


