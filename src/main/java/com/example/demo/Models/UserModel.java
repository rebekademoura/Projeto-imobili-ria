package com.example.demo.Models;

import java.io.Serializable;

import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Todas as alterações feitas na classe Model são refletidas no banco de dados
@Entity //indica que a classe é uma entidade do banco de dados
@Table(name = "users") //nome da tabela no banco de dados
public class UserModel implements Serializable{ 
    private static final long serialVersionUID = 1L; //controle de versionamento da classe

    @Id //chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-incremento do id
    private Integer id;

    private String name;

    private String email;

    private String password;

    private String role;

    public UserModel() {};

    public UserModel(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public UserModel(Integer id, String name, String email, String password, String role){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters e Setters - métodos construtores de acesso aos atributos da classe
    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }
    
    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getRole(){
        return role;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }


    //métodos hashCode e equals - comparação de objetos da classe
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserModel other = (UserModel) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
    
}
