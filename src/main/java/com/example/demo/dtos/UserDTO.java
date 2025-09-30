package com.example.demo.dtos;

import com.example.demo.Models.UserModel;

import lombok.Getter;
import lombok.Setter;

@Getter //cria os métodos getters automaticamente - não visíveis no código
@Setter //cria os métodos setters automaticamente - não visíveis no código
public class UserDTO {
    
    private Integer id;
    private String name;
    private String email;
    private String role;

    public UserDTO() {
        
    }

    public UserDTO(Integer id, String name, String email, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this. role = role;
    }

    public UserDTO(UserModel userModel){
        this.id = userModel.getId();
        this.name = userModel.getName();
        this.email = userModel.getEmail(); 
        this.role = userModel.getRole(); 
    }


}
