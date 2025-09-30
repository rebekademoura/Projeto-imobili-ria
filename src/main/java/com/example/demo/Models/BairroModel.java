package com.example.demo.Models;

import java.io.Serializable;

import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Todas as alterações feitas na classe Model são refletidas no banco de dados
@Entity //indica que a classe é uma entidade do banco de dados
@Table(name = "bairros") //nome da tabela no banco de dados
public class BairroModel implements Serializable{ 
    private static final long serialVersionUID = 1L; //contcepFinal de versionamento da classe

    @Id //chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-incremento do id
    private Integer id;

    private String name;

    private String estado;

    private String cepInicial;

    private String cepFinal;

    public BairroModel() {};

    public BairroModel(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public BairroModel(Integer id, String name, String estado, String cepInicial, String cepFinal){
        this.id = id;
        this.name = name;
        this.estado = estado;
        this.cepInicial = cepInicial;
        this.cepFinal = cepFinal;
    }

    // Getters e Setters - métodos construtores de acesso aos atributos da classe
    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }
    
    public String getestado(){
        return estado;
    }

    public String getCepInicial(){
        return cepInicial;
    }

    public String getCepFinal(){
        return cepFinal;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCepInicial(String cepInicial) {
        this.cepInicial = cepInicial;
    }

    public void setCepFinal(String cepFinal) {
        this.cepFinal = cepFinal;
    }


    /*métodos hashCode e equals - comparação de objetos da classe
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
    }*/

    
    
}
