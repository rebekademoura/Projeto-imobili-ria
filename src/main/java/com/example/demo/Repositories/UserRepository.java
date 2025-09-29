package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.UserModel;

//Interface que estende JpaRepository para fornecer operações CRUD para UserModel
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    
}