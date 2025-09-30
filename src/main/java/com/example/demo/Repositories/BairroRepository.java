package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.BairroModel;

//Interface que estende JpaRepository para fornecer operações CRUD para UserModel
public interface BairroRepository extends JpaRepository<BairroModel, Integer> {

    
}